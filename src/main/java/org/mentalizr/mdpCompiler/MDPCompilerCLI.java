package org.mentalizr.mdpCompiler;

import de.arthurpicht.cli.CommandExecutorException;
import de.arthurpicht.cli.CommandLineInterface;
import de.arthurpicht.cli.CommandLineInterfaceBuilder;
import de.arthurpicht.cli.command.CommandSequenceBuilder;
import de.arthurpicht.cli.command.Commands;
import de.arthurpicht.cli.command.DefaultCommandBuilder;
import de.arthurpicht.cli.common.UnrecognizedArgumentException;
import de.arthurpicht.cli.option.OptionBuilder;
import de.arthurpicht.cli.option.Options;
import de.arthurpicht.cli.parameter.ParametersVar;
import org.mentalizr.mdpCompiler.cli.CommandExecutorClean;
import org.mentalizr.mdpCompiler.cli.CommandExecutorCompile;
import org.mentalizr.mdpCompiler.cli.CommandExecutorDefault;
import org.mentalizr.mdpCompiler.cli.CommandExecutorHelp;

public class MDPCompilerCLI {

    public static final String ID_VERSION = "version";
    public static final String ID_NO_CLEAN = "no-clean";
    public static final String ID_HELP = "help";
    public static final String ID_VERBOSE = "verbose";
    public static final String ID_SILENT = "silent";
    public static final String ID_SHOW_STACKTRACE = "stacktrace";

    public static final String COMPILE = "compile";
    public static final String FILE = "file";
    public static final String PROGRAM = "program";
    public static final String CLEAN = "clean";
    public static final String HELP = "help";

    private static CommandLineInterface createCommandLineInterface() {

        Options globalOptions = new Options()
                .add(new OptionBuilder().withShortName('v').withLongName("version").withDescription("show Version").build(ID_VERSION))
                .add(new OptionBuilder().withLongName("no-clean").withDescription("omit cleaning preexisting html files").build(ID_NO_CLEAN))
                .add(new OptionBuilder().withShortName('h').withLongName("help").withDescription("show help text").build(ID_HELP))
                .add(new OptionBuilder().withLongName("silent").withDescription("silent").build(ID_SILENT))
                .add(new OptionBuilder().withLongName("verbose").withDescription("verbose").build(ID_VERBOSE))
                .add(new OptionBuilder().withLongName("stacktrace").build(ID_SHOW_STACKTRACE));

        Options specificOptionsCompile = new Options()
                .add(new OptionBuilder().withLongName("no-clean").withDescription("omit cleaning preexisting html files").build(ID_NO_CLEAN));

        Commands commands = new Commands()
                .setDefaultCommand(new DefaultCommandBuilder().withCommandExecutor(new CommandExecutorDefault()).build())
                .add(new CommandSequenceBuilder()
                        .addCommands(COMPILE, FILE)
                        .withSpecificOptions(specificOptionsCompile)
                        .withParameters(new ParametersVar(0))
                        .withCommandExecutor(new CommandExecutorCompile())
                        .build())
                .add(new CommandSequenceBuilder()
                        .addCommands(COMPILE, PROGRAM)
                        .withSpecificOptions(specificOptionsCompile)
                        .withParameters(new ParametersVar(0))
                        .withCommandExecutor(new CommandExecutorCompile())
                        .build())
                .add(new CommandSequenceBuilder()
                        .addCommands(CLEAN)
                        .withCommandExecutor(new CommandExecutorClean())
                        .build())
                .add(new CommandSequenceBuilder()
                        .addCommands(HELP)
                        .withCommandExecutor(new CommandExecutorHelp())
                        .build());

        return new CommandLineInterfaceBuilder()
                .withGlobalOptions(globalOptions)
                .withCommands(commands)
                .build();
    }

    public static void main(String[] args) {

        CommandLineInterface cli = createCommandLineInterface();
        try {
            cli.execute(args);

        } catch (UnrecognizedArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("mdpc " + e.getArgsAsString());
            System.out.println("     " + e.getArgumentPointerString());
            System.exit(1);
        } catch (CommandExecutorException e) {
            System.out.println("Error: " + e.getMessage());
            System.exit(1);
        }
    }

}
