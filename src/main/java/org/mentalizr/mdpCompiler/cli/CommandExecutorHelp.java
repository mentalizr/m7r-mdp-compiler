package org.mentalizr.mdpCompiler.cli;

import de.arthurpicht.cli.CommandExecutor;
import de.arthurpicht.cli.option.OptionParserResult;

import java.util.List;

public class CommandExecutorHelp implements CommandExecutor {

    @Override
    public void execute(OptionParserResult optionParserResultGlobal, List<String> commandList, OptionParserResult optionParserResultSpecific, List<String> parameterList) {
        HelpText.basic();
    }
}
