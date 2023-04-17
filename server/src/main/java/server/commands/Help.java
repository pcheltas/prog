package commands;

/**
 The Help class implements the Command interface and represents the command that shows the list of available commands.
 */
public class Help implements Command{

    /**
     Executes the Help command and prints the list of available commands with their descriptions.
     */
    @Override
    public void execute(){
        System.out.println(
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
