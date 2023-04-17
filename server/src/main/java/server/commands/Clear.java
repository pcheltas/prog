package commands;

import static support.Loader.repo;

/**
 A class that implements the Command interface and is designed to remove all elements from the collection.
 */
public class Clear implements Command{

    /**
     * Removes all elements from the collection using the clear() method of the HashMap class.
     * If the collection is already empty, a message is displayed to that effect.
     *
     * @throws NullPointerException if the collection was not initialized (equals null).
     */
    @Override
    public void execute() throws NullPointerException {
        try {
            repo.map.clear();
            System.out.println("Все элементы коллекции успешно удалены. Коллекция пуста");
        } catch (NullPointerException e) {
            System.out.println("Коллекция уже пуста");
        }
    }

    /**
     Returns a String representation of the command, including its name and purpose.
     @return a String representation of the command
     */
    @Override
    public String toString(){
        return "clear: очистить коллекцию";
    }

}
