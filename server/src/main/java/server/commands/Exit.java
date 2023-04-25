package server.commands;

/**
 * This class represents a command that exits the application.
 */
public class Exit implements Command {
    Loader loader;
    public Exit(Loader loader){this.loader = loader;}
    public Exit(){}
    @Override
    public void execute()  {
        System.out.println("Вы вышли из приложения. До новых встреч!");
        System.exit(0);
    }

    /**
     Returns a String representation of the command, including its name and purpose.
     @return a String representation of the command
     */
    @Override
    public String toString(){
        return "exit : завершить программу (без сохранения в файл)";
    }
    @Override
    public String toString(){
        return "exit : завершить программу (без сохранения в файл)";
    }



}
