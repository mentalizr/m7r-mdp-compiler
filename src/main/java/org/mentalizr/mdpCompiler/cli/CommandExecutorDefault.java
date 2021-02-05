package org.mentalizr.mdpCompiler.cli;

import de.arthurpicht.cli.CommandExecutor;
import de.arthurpicht.cli.option.OptionParserResult;
import org.mentalizr.mdpCompiler.Const;

import java.util.List;

import static org.mentalizr.mdpCompiler.MDPCompilerCLI.ID_HELP;
import static org.mentalizr.mdpCompiler.MDPCompilerCLI.ID_VERSION;

public class CommandExecutorDefault implements CommandExecutor {

    @Override
    public void execute(
            OptionParserResult optionParserResultGlobal,
            List<String> commandList,
            OptionParserResult optionParserResultSpecific,
            List<String> parameterList) {

        if (optionParserResultGlobal.hasOption(ID_VERSION)) {
            System.out.println("mdpc version " + Const.VERSION + " from " + Const.VERSION_DATE);
        } else if (optionParserResultGlobal.hasOption(ID_HELP)) {
            HelpText.basic();
        } else {
            System.out.println("mpdc. Call --version or --help for more information.");
        }

    }

}
