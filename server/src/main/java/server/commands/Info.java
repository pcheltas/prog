package commands;

import support.Loader;

/**

 Implements the Command interface and represents the "info" command in the application.

 When executed, it prints information about the collection such as its creation date, type, and size.
 */
public class Info implements Command{

    /**
     Prints information about the collection, such as its creation date, type, and size.
     */
    @Override
    public void execute() {
        System.out.println("Дата создания коллекции: " + Loader.getCreation());
        System.out.println("Тип коллекции: TreeMap, хранит данные о работниках");
        System.out.println("Количество элементов: " + Loader.repo.map.size());
    }

    /**
     Returns a String representation of the command, including its name and purpose.
     @return a String representation of the command
     */
    @Override
    public String toString(){
        return "info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов)";
    }
}
