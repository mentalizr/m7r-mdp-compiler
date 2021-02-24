package org.mentalizr.mdpCompiler.cli;

import de.arthurpicht.cli.CliCall;
import de.arthurpicht.cli.CommandExecutor;
import de.arthurpicht.cli.CommandExecutorException;
import de.arthurpicht.cli.option.OptionParserResult;
import org.mentalizr.mdpCompiler.ContentCompiler;
import org.mentalizr.mdpCompiler.MDPSyntaxErrorCollector;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.mentalizr.mdpCompiler.MDPCompilerCLI.*;

public class CommandExecutorCompile implements CommandExecutor {

    @Override
    public void execute(CliCall cliCall) throws CommandExecutorException {

        OptionParserResult optionParserResultGlobal = cliCall.getOptionParserResultGlobal();
        List<String> commandList = cliCall.getCommandList();
        OptionParserResult optionParserResultSpecific = cliCall.getOptionParserResultSpecific();
        List<String> parameterList = cliCall.getParameterList();

        GlobalConfiguration globalConfiguration = createGlobalConfiguration(optionParserResultGlobal);
        CompileConfiguration compileConfiguration = new CompileConfiguration();

        if (commandList.get(1).equals(PROGRAM)) {
            compileConfiguration.setCompileMode(CompileConfiguration.CompileMode.PROGRAM);
        } else {
            compileConfiguration.setCompileMode(CompileConfiguration.CompileMode.FILE);
        }

        compileConfiguration.setClean(!optionParserResultSpecific.hasOption(ID_NO_CLEAN));

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

    private static GlobalConfiguration createGlobalConfiguration(OptionParserResult optionParserResult) {

        GlobalConfiguration globalConfiguration = new GlobalConfiguration();

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

        return globalConfiguration;
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

}
