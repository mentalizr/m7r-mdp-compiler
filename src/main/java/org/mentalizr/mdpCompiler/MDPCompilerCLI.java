package org.mentalizr.mdpCompiler;

import de.arthurpicht.cli.CommandLineInterface;
import de.arthurpicht.cli.CommandLineInterfaceBuilder;
import de.arthurpicht.cli.ParserResult;
import de.arthurpicht.cli.command.Commands;
import de.arthurpicht.cli.common.ArgsHelper;
import de.arthurpicht.cli.common.UnrecognizedArgumentException;
import de.arthurpicht.cli.option.OptionBuilder;
import de.arthurpicht.cli.option.OptionParserResult;
import de.arthurpicht.cli.option.Options;
import de.arthurpicht.cli.parameter.ParametersVar;
import org.mentalizr.mdpCompiler.cli.CompileConfiguration;
import org.mentalizr.mdpCompiler.cli.FileChecker;
import org.mentalizr.mdpCompiler.cli.FileSystemCheckerException;
import org.mentalizr.mdpCompiler.cli.GlobalConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MDPCompilerCLI {

    private static final String ID_VERSION = "version";
    private static final String ID_PROGRAM = "program";
    private static final String ID_FILE = "file";
    private static final String ID_NO_CLEAN = "no-clean";
    private static final String ID_HELP = "help";
    private static final String ID_VERBOSE = "verbose";
    private static final String ID_SILENT = "silent";
    private static final String ID_SHOW_STACKTRACE = "stacktrace";

    private static final GlobalConfiguration globalConfiguration = new GlobalConfiguration();

    private static CommandLineInterface prepareCLI() {

        return new CommandLineInterfaceBuilder()
                .withGlobalOptions(new Options()
                        .add(new OptionBuilder().withShortName('v').withLongName("version").withDescription("show Version").build(ID_VERSION))
                        .add(new OptionBuilder().withShortName('p').withLongName("program").withDescription("compile program").build(ID_PROGRAM))
                        .add(new OptionBuilder().withShortName('f').withLongName("file").withDescription("compile mdp file").build(ID_FILE))
                        .add(new OptionBuilder().withLongName("no-clean").withDescription("omit cleaning preexisting html files").build(ID_NO_CLEAN))
                        .add(new OptionBuilder().withShortName('h').withLongName("help").withDescription("show help text").build(ID_HELP))
                        .add(new OptionBuilder().withLongName("silent").withDescription("silent").build(ID_SILENT))
                        .add(new OptionBuilder().withLongName("verbose").withDescription("verbose").build(ID_VERBOSE))
                        .add(new OptionBuilder().withLongName("stacktrace").build(ID_SHOW_STACKTRACE))
                )
                .withCommands(new Commands()
                        .add("compile").addOneOf("file", "program")
                        .withSpecificOptions(new Options()
                                .add(new OptionBuilder().withLongName("no-clean").withDescription("omit cleaning preexisting html files").build(ID_NO_CLEAN))
                        )
                        .root().add("clean")
                        .root().add("help")
                        .root().add("version")
                )
                .withParameters(new ParametersVar(0))
                .build();
    }

    private static void processParserResultGlobalOptions(OptionParserResult optionParserResult) {

        if (optionParserResult.hasOption(ID_VERBOSE)) {
            globalConfiguration.setVerbosityLevel(GlobalConfiguration.VerbosityLevel.VERBOSE);
        } else if (optionParserResult.hasOption(ID_SILENT)) {
            globalConfiguration.setVerbosityLevel(GlobalConfiguration.VerbosityLevel.SILENT);
        } else {
            globalConfiguration.setVerbosityLevel(GlobalConfiguration.VerbosityLevel.NORMAL);
        }

        if (optionParserResult.hasOption(ID_SHOW_STACKTRACE)) {
            globalConfiguration.setShowStacktrace(true);
        }

    }

    private static void processParserResultCommandCompile(List<String> commands, OptionParserResult optionParserResultSpecific, List<String> parameterList) {

        CompileConfiguration compileConfiguration = new CompileConfiguration();

        if (commands.get(1).equals("program")) {
            compileConfiguration.setCompileMode(CompileConfiguration.CompileMode.PROGRAM);
        } else {
            compileConfiguration.setCompileMode(CompileConfiguration.CompileMode.FILE);
        }

        if (optionParserResultSpecific.hasOption(ID_NO_CLEAN)) {
            compileConfiguration.setClean(false);
        } else {
            compileConfiguration.setClean(true);
        }

        if (parameterList.size() == 0) {
            System.out.println("Error. No file or directory specified.");
            System.exit(1);
        }

        List<File> fileList = checkFiles(compileConfiguration.getCompileMode(), parameterList);
        compileConfiguration.setFiles(fileList);

        try {
            MDPSyntaxErrorCollector mdpSyntaxErrorCollector = ContentCompiler.compile(globalConfiguration, compileConfiguration);
            if (!mdpSyntaxErrorCollector.isEmpty()) System.exit(1);

        } catch (IOException e) {
            if (globalConfiguration.getVerbosityLevel() != GlobalConfiguration.VerbosityLevel.SILENT) {
                System.out.println("Error: " + e.getMessage());
            }
            System.exit(1);
        }
    }

    private static List<File> checkFiles(CompileConfiguration.CompileMode compileMode, List<String> parameterList) {

        List<File> fileList = new ArrayList<>();

        try {
            for (String fileName : parameterList) {
                if (compileMode.equals(CompileConfiguration.CompileMode.PROGRAM)) {
                    fileList.add(FileChecker.assertMdpProgramDir(fileName));
                } else {
                    fileList.add(FileChecker.assertMdpFile(fileName));
                }
            }
        } catch (FileSystemCheckerException e) {
            System.out.println("Error: " + e.getMessage());
            System.exit(1);
        }

        return fileList;
    }

    private static void showVersion() {
        System.out.println("mdpc version " + Const.VERSION + " from " + Const.VERSION_DATE);
    }

    private static void showHelp() {
        // TODO
        System.out.println("show help text. Not implemented yet.");
    }

    public static void main(String[] args) {

//        System.out.println("Args: " + Strings.listing(Arrays.asList(args), ", "));

        CommandLineInterface cli = prepareCLI();
        try {
            ParserResult parserResult = cli.parse(args);
            processParserResultGlobalOptions(parserResult.getOptionParserResultGlobal());

            if (parserResult.getCommandList().get(0).equals("version")) {
                showVersion();
                System.exit(0);
            }

            if (parserResult.getCommandList().get(0).equals("help")) {
                showHelp();
                System.exit(0);
            }

            if (parserResult.getCommandList().get(0).equals("compile")) {
                processParserResultCommandCompile(parserResult.getCommandList(), parserResult.getOptionParserResultSpecific(), parserResult.getParameterList());
            }

        } catch (UnrecognizedArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("mdpc " + ArgsHelper.getArgsString(args));
            System.out.println("     " + e.getArgumentPointerString());

//            System.out.println(e.getArgumentIndex());

        }

    }


}
