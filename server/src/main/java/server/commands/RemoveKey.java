package commands;

import static support.Loader.repo;
/**

 The RemoveKey class represents a command to remove an element from the collection by its key.

 The key is received as an argument.
 */
public class RemoveKey implements ArgumentCommand{

    private int key;

    /**
     This method removes the element with the specified key from the collection.
     If the element with the specified key is not found in the collection, a message is printed.
     */
    @Override
    public void execute(){
        if (repo.map.get(key) != null) {
            repo.map.remove(key);
            System.out.println("Элемент коллекции успешно удален");
        }else {
            System.out.println("Значения по заданному ключу не найдено");
        }
    }

    /**
     This method sets the argument for the command - the key.
     If the key is not found in the collection, a message is printed.
     @throws NumberFormatException if the specified argument is blank or does not match the required format.
     @param arg a string representing the key to be removed from the collection
     */
    @Override
    public void getArgument(String arg){
        try {
            if (repo.map.containsKey(Integer.parseInt(arg))) {
                key = Integer.parseInt(arg);
                execute();
            }else{
                System.out.println("Коллекция не имеет элемента по заданному ключу");
            }
        } catch (NumberFormatException e){
            System.err.println("Ключ введен неверно");
        }
    }
    /**
     Returns a String representation of the command, including its name and purpose.
     @return a String representation of the command
     */
    @Override
    public String toString(){
        return "remove_key {key}:  удалить элемент из коллекции по его ключу";
    }
}
