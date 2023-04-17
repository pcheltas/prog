package commands;

import static support.Loader.repo;

/**

 The Update class implements the ArgumentCommand interface and represents a command for updating an element in the collection

 with the specified key.
 */
public class Update implements ArgumentCommand{
    private int key;

    /**

     Executes the command to update an element in the collection with the specified key.
     It creates a new worker object by getting worker object from ConsoleCreation object and updates the
     existing element with the specified key with this new worker object.
     */
    @Override
    public void execute() {
        ConsoleCreation create = new ConsoleCreation();
        create.execute();
        create.getWorker().setId(key);
        repo.map.put(key, create.getWorker());
    }
    /**

     Gets the argument of the command, which is the key of the element to update.
     @param arg the key of the element to update
     @throws IllegalArgumentException if the key is less than or equal to 0
     */
    @Override
    public void getArgument(String arg){
        if (!(Integer.parseInt(arg)>0)) throw new IllegalArgumentException("Ключ должен быть больше 0");
        key = Integer.parseInt(arg);
        execute();
    }
    /**
     Returns a String representation of the command, including its name and purpose.
     @return a String representation of the command
     */
    @Override
    public String toString(){
        return "update id {element} : обновить значение элемента коллекции, id которого равен заданному";
    }
}
