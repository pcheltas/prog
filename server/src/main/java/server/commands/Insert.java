package commands;

import worker.Worker;

import static support.Loader.repo;

/**

 Implements the Command interface and defines the behavior of inserting a new element into the collection
 */
public class Insert implements Command{
    private int key;

    /**

     Inserts a new element into the collection

     by getting worker object from ConsoleCreation object,

     setting the object's ID, and adding it to the TreeMap.

     If the key already exists in the map, then it is incremented to the next unused value.
     */
    @Override
    public void execute() {
        ConsoleCreation create = new ConsoleCreation();
        create.execute();
        create.getWorker().setId(Worker.getCounter()+1);
        Worker.setCounter(Worker.getCounter()+1);
        while (repo.map.containsKey(Worker.getCounter())){
            create.getWorker().setId(Worker.getCounter()+1);
            Worker.setCounter(Worker.getCounter()+1);
        }

        repo.map.put( create.getWorker().getId(), create.getWorker());
    }
    /**
     Returns a String representation of the command, including its name and purpose.
     @return a String representation of the command
     */
    @Override
    public String toString(){
        return "insert null {element} : добавить новый элемент с заданным ключом";
    }
}