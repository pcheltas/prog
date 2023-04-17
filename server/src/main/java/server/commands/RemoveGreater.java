package commands;

import worker.Worker;

import static support.Loader.repo;

/**

 The RemoveGreater class implements the Command interface.

 This command removes the elements of the collection that are greater than the specified element.
 */
public class RemoveGreater implements Command{
    /**

     Executes the command to remove the elements that are greater than the specified element.
     Creates a new worker instance using ConsoleCreation class and compares it to each worker in the collection.
     If the current worker in the collection is less than the new worker, removes the current worker from the collection.
     */
    @Override
    public void execute() {
        ConsoleCreation create = new ConsoleCreation();
        create.execute();
        for (Worker worker : repo.map.values()){
            if (worker.compareTo(create.getWorker()) < 0){
                create.getWorker().setId(worker.getId());
                repo.map.remove(worker.getId());
                break;
            }
        }
    }
    /**
     Returns a String representation of the command, including its name and purpose.
     @return a String representation of the command
     */
    @Override
    public String toString(){
        return "remove_if_greater null {element} : удалить значение по ключу если новое значение больше старого";
    }
}
