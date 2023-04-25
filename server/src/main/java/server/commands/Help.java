package server.commands;

import server.utils.Loader;
import server.utils.ResponseOutputer;

public class Help implements Command {
    Loader loader;
    public Help(Loader loader) {
        this.loader = loader;
    }

    @Override
    public void execute(String argument, Object commandObjectArgument){
        ResponseOutputer.appendln(
        new Info().toString() + "\n" +
        new Show().toString() + "\n" +
        new Insert().toString() + "\n" +
        new Update().toString() + "\n" +
        new RemoveKey().toString()  + "\n" +
        new Clear().toString() + "\n" +
        new Save().toString() + "\n" +
        new ExecuteScript().toString() + "\n" +
        new Exit().toString() + "\n" +
        new ReplaceGreater().toString() + "\n" +
        new ReplaceLower().toString() + "\n" +
        new RemoveByEndDate().toString() + "\n" +
        new FilterGreaterSalary().toString() + "\n" +
        new PrintDesEndDate().toString() + "\n");
    }
}
