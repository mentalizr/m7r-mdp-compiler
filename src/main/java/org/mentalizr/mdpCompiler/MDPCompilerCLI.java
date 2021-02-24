package org.mentalizr.mdpCompiler;

import de.arthurpicht.cli.*;
import de.arthurpicht.cli.command.CommandSequenceBuilder;
import de.arthurpicht.cli.command.Commands;
import de.arthurpicht.cli.common.UnrecognizedArgumentException;
import de.arthurpicht.cli.option.*;
import de.arthurpicht.cli.parameter.ParametersMin;
import org.mentalizr.mdpCompiler.cli.CommandExecutorClean;
import org.mentalizr.mdpCompiler.cli.CommandExecutorCompile;

public class MDPCompilerCLI {

    public static final String ID_NO_CLEAN = "no-clean";
    public static final String ID_VERBOSE = "verbose";
    public static final String ID_SILENT = "silent";
    public static final String ID_SHOW_STACKTRACE = "stacktrace";

    public static final String COMPILE = "compile";
    public static final String FILE = "file";
    public static final String PROGRAM = "program";
    public static final String CLEAN = "clean";

    private static Cli createCli() {

        Options globalOptions = new Options()
                .add(new VersionOption())
                .add(new HelpOption())
                .add(new ManOption())
                .add(new OptionBuilder().withLongName("no-clean").withDescription("Omit cleaning preexisting html files.").build(ID_NO_CLEAN))
                .add(new OptionBuilder().withLongName("silent").withDescription("Proceed without any output to console.").build(ID_SILENT))
                .add(new OptionBuilder().withLongName("verbose").withDescription("Show extended output if necessary.").build(ID_VERBOSE))
                .add(new OptionBuilder().withLongName("stacktrace").withDescription("Print stacktrace in case of error occurrence.").build(ID_SHOW_STACKTRACE));

        Options specificOptionsCompile = new Options()
                .add(new HelpOption())
                .add(new OptionBuilder().withLongName("no-clean").withDescription("Omit cleaning preexisting html files.").build(ID_NO_CLEAN));

        Commands commands = new Commands()
                .add(new CommandSequenceBuilder()
                        .addCommands(COMPILE, FILE)
                        .withSpecificOptions(specificOptionsCompile)
                        .withParameters(new ParametersMin(0, "file", ".mdp files to be compiled."))
                        .withCommandExecutor(new CommandExecutorCompile())
                        .withDescription("Compiles one ore more .mdp file(s).")
                        .withHelpPriority(1)
                        .build())
                .add(new CommandSequenceBuilder()
                        .addCommands(COMPILE, PROGRAM)
                        .withSpecificOptions(specificOptionsCompile)
                        .withParameters(new ParametersMin(0, "program-dir", "Program directory to be compiled."))
                        .withCommandExecutor(new CommandExecutorCompile())
                        .withDescription("Compile one or more programs.")
                        .withHelpPriority(2)
                        .build())
                .add(new CommandSequenceBuilder()
                        .addCommands(CLEAN)
                        .withSpecificOptions(new Options().add(new HelpOption()))
                        .withCommandExecutor(new CommandExecutorClean())
                        .withDescription("Deletes all compile products. (NIY)")
                        .withHelpPriority(3)
                        .build());

        CliDescription cliDescription = new CliDescriptionBuilder("mdpc")
                .withDescription("Markdown for psychoeducation compiler\nmdpc is part of the mentalizr project\nSee https://github.com/mentalizr/m7r-mdp-compiler for more info.")
                .withVersion(Const.VERSION)
                .withDate(Const.VERSION_DATE)
                .build();

        return new CliBuilder()
                .withGlobalOptions(globalOptions)
                .withCommands(commands)
                .build(cliDescription);
    }

    public static void main(String[] args) {

        Cli cli = createCli();
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
