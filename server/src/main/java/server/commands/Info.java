package server.commands;

import server.utils.Loader;
import server.utils.ResponseOutputer;


public class Info implements Command {
    Loader loader;
    public Info(Loader loader){this.loader = loader;}
    public Info(){}

    @Override
    public void execute(String argument, Object commandObjectArgument) {
        try {
            if (!argument.isEmpty()) throw new IllegalArgumentException();
            loader.info();
        } catch (IllegalArgumentException e) {
            ResponseOutputer.appendln(e.getMessage());
        }
    }


    @Override
    public String toString(){
        return "info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов)";
    }
}
