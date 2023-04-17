package commands;

import java.io.IOException;

public interface Command {
    /**
     * Executes the command.
     *
     * @throws IOException if there is an error during execution.
     */
    public void execute(String commandArgument, Object commandObjectArgument) throws IOException;
}
