package commands;


public interface ArgumentCommand extends Command{
    /**
     * Accepts an argument that will be used in the execution of the command.
     *
     * @param arg the argument to be passed to the command.
     */
    void getArgument(String arg);
}
