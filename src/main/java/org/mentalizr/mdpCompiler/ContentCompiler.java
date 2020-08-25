package org.mentalizr.mdpCompiler;

import org.mentalizr.mdpCompiler.cli.CompileConfiguration;
import org.mentalizr.mdpCompiler.cli.GlobalConfiguration;
import org.mentalizr.mdpCompiler.helper.ConsoleColor;
import org.mentalizr.mdpCompiler.helper.TextFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashSet;
import java.util.List;

import static org.mentalizr.mdpCompiler.helper.ConsoleColor.ANSI_RED;
import static org.mentalizr.mdpCompiler.helper.ConsoleColor.ANSI_RESET;


public class ContentCompiler {

    private static final String SUFFIX_MDP_FILE = "mdp";
    private static final String SUFFIX_HTML_FILE = "html";

    public static MDPSyntaxErrorCollector compile(GlobalConfiguration globalConfiguration, CompileConfiguration compileConfiguration) throws IOException {

        MDPSyntaxErrorCollector mdpSyntaxErrorCollector = new MDPSyntaxErrorCollector();

        for (File mdpFile : compileConfiguration.getFiles()) {

            if (compileConfiguration.getCompileMode().equals(CompileConfiguration.CompileMode.PROGRAM)) {
                compileProgram(mdpFile, compileConfiguration.isClean(), globalConfiguration, mdpSyntaxErrorCollector);
            } else {
                compileFile(mdpFile, globalConfiguration, mdpSyntaxErrorCollector, true);
            }
        }

        return mdpSyntaxErrorCollector;
    }

    private static void compileFile(File mdpFile, GlobalConfiguration globalConfiguration, MDPSyntaxErrorCollector mdpSyntaxErrorCollector, boolean singleFile) throws IOException {

        File htmlFile = new File(mdpFile.getParentFile(), makeHtmlFileNameFromMDPFileName(mdpFile.getName()));
        consoleLogFileToCompile(mdpFile, htmlFile, globalConfiguration, singleFile);
        try {
            MDPCompiler.compile(mdpFile, htmlFile);
        } catch (MDPSyntaxError mdpSyntaxError) {
            mdpSyntaxErrorCollector.add(mdpFile, mdpSyntaxError);
            consoleLogMDPSyntaxErrorMessage(mdpSyntaxError, mdpFile, singleFile, globalConfiguration);
        }
    }

    private static void consoleLogFileToCompile(File mdpFile, File htmlFile, GlobalConfiguration globalConfiguration, boolean singleFile) {
        if (globalConfiguration.getVerbosityLevel() == GlobalConfiguration.VerbosityLevel.SILENT) return;
        if (singleFile || globalConfiguration.getVerbosityLevel() == GlobalConfiguration.VerbosityLevel.VERBOSE) {
            System.out.println("Compile [MDP][" + mdpFile.getAbsolutePath() + "] to [HTML][" + htmlFile.getAbsolutePath() + "]");
        }
    }

    private static void consoleLogMDPSyntaxErrorMessage(MDPSyntaxError mdpSyntaxError, File mdpFile, boolean singleFile, GlobalConfiguration globalConfiguration) {

        GlobalConfiguration.VerbosityLevel verbosityLevel = globalConfiguration.getVerbosityLevel();

        if (verbosityLevel == GlobalConfiguration.VerbosityLevel.SILENT) return;

        if (singleFile || verbosityLevel == GlobalConfiguration.VerbosityLevel.VERBOSE) {
            consoleLogErrorMessage(mdpFile, mdpSyntaxError, globalConfiguration);

            if (globalConfiguration.isShowStacktrace()) {
                mdpSyntaxError.printStackTrace();
            }
        }
    }

    private static void consoleLogProgramSummary(MDPSyntaxErrorCollector mdpSyntaxErrorCollector, GlobalConfiguration globalConfiguration) {

        if (globalConfiguration.getVerbosityLevel() == GlobalConfiguration.VerbosityLevel.SILENT) return;

        if (mdpSyntaxErrorCollector.isEmpty()) {
            System.out.println("Program compiled successfully.");
        } else {
            System.out.println("Program compilation finished with errors:");
            for (MDPSyntaxErrorCollector.MDPSyntaxErrorWrapper mdpSyntaxErrorWrapper : mdpSyntaxErrorCollector.getMdpSyntaxErrorWrapperList()) {
                File mdpFile = mdpSyntaxErrorWrapper.getMdpFile();
                MDPSyntaxError mdpSyntaxError = mdpSyntaxErrorWrapper.getMdpSyntaxError();
                consoleLogErrorMessage(mdpFile, mdpSyntaxError, globalConfiguration);

                if (globalConfiguration.isShowStacktrace()) {
                    mdpSyntaxError.printStackTrace();
                }

            }
        }
    }

    private static void consoleLogErrorMessage(File mdpFile, MDPSyntaxError mdpSyntaxError, GlobalConfiguration globalConfiguration) {
        if (globalConfiguration.getVerbosityLevel() == GlobalConfiguration.VerbosityLevel.SILENT) return;
        System.out.println(ANSI_RED + "Syntaxerror in [" + mdpFile.getAbsolutePath() + ":" + mdpSyntaxError.getLine().getLineNr() + "]: " + mdpSyntaxError.getMessage() + ANSI_RESET);
        System.out.println(">>> " + mdpSyntaxError.getLine().asString());
    }

    private static void compileProgram(File programRoot, boolean clean, GlobalConfiguration globalConfiguration, MDPSyntaxErrorCollector mdpSyntaxErrorCollector) throws IOException {

        Path startPath = programRoot.toPath();
        int maxDepth = 4;

        if (clean) clean(programRoot, maxDepth, globalConfiguration);

        Files.walkFileTree(startPath, new HashSet<>(), maxDepth, new SimpleFileVisitor<>(){

            public FileVisitResult visitFile(Path path, BasicFileAttributes basicFileAttributes) throws IOException {

//                System.out.println("Besuche: " + path.toString() + " -- " + path.getFileName());

                String dotSuffix = "." + SUFFIX_MDP_FILE;
//                System.out.println(dotSuffix);

                if (path.getFileName().toString().endsWith(dotSuffix)) {

//                    System.out.println("GEFUNDEN!");

                    File mdpFile = path.toFile();
//                    File htmlFile = new File(getParent(path), makeHtmlFileNameFromMDPFileName(mdpFile.getName()));
//
//                    MDPCompiler.compile(mdpFile, htmlFile, globalConfiguration, mdpSyntaxErrorCollector);
                    compileFile(mdpFile, globalConfiguration, mdpSyntaxErrorCollector, false);

                }

                return FileVisitResult.CONTINUE;
            }

        });

        consoleLogProgramSummary(mdpSyntaxErrorCollector, globalConfiguration);
    }

    public static void clean(File contentRoot, int maxDepth, GlobalConfiguration globalConfiguration) throws IOException {

//        System.out.println("Clean html files compiled from mdp ...");

        Path startPath = contentRoot.toPath();

        Files.walkFileTree(startPath, new HashSet<>(), maxDepth, new SimpleFileVisitor<>() {

            public FileVisitResult visitFile(Path path, BasicFileAttributes basicFileAttributes) throws IOException {

                String dottedSuffix = "." + SUFFIX_HTML_FILE;
                if (path.getFileName().toString().endsWith(dottedSuffix)) {

//                    System.out.println("Prüfe: " + path.getFileName());

                    File htmlFile = path.toFile();
                    cleanFile(htmlFile, globalConfiguration);
//                    if (isCompiledFromMDP(htmlFile)) {
//                        System.out.println("Clean [HTML][" + htmlFile.getAbsolutePath() + "]");
//                        htmlFile.delete();
//                    } else {
//                        // TODO aulagern in CleanWarnings o.ä. so wie CompilerWarnings
//                        System.out.println(ConsoleColor.ANSI_YELLOW + "Warning for [" + htmlFile.getAbsolutePath() + "]: HTML-File from unknown source. Not deleted." + ANSI_RESET);
//                    }

                }

                return FileVisitResult.CONTINUE;
            }
        });
    }

    private static void cleanFile(File htmlFile, GlobalConfiguration globalConfiguration) throws IOException {
        if (isCompiledFromMDP(htmlFile)) {
            consoleLogClean(htmlFile, globalConfiguration);
            htmlFile.delete();
        } else {
            // TODO aulagern in CleanWarnings o.ä. so wie CompilerWarnings
            if (globalConfiguration.getVerbosityLevel() == GlobalConfiguration.VerbosityLevel.SILENT) return;
            System.out.println(ConsoleColor.ANSI_YELLOW + "Warning for [" + htmlFile.getAbsolutePath() + "]: HTML-File from unknown source. Not deleted." + ANSI_RESET);
        }
    }

    private static void consoleLogClean(File htmlFile, GlobalConfiguration globalConfiguration) {
        if (globalConfiguration.getVerbosityLevel() != GlobalConfiguration.VerbosityLevel.VERBOSE) return;
        System.out.println("Clean [HTML][" + htmlFile.getAbsolutePath() + "]");
    }

    private static boolean isCompiledFromMDP(File file) throws IOException {
        List<String> lines = TextFile.getLinesAsStrings(file);
        return lines.get(lines.size() - 1).startsWith("<!-- MDP");
    }

    private static String makeHtmlFileNameFromMDPFileName(String mdpFileName) {

        int prefixEndIndex = mdpFileName.length() - (SUFFIX_MDP_FILE.length() + 1);
        String prefix = mdpFileName.substring(0, prefixEndIndex);
        return prefix + "." + SUFFIX_HTML_FILE;
    }

}
