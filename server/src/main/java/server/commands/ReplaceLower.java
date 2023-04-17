package commands;

import worker.Worker;

import static support.Loader.repo;

/**

 The ReplaceLower implements the Command interface and represents a command to replace a worker in the collection
 with a new one if it is lower than the given one.

 */
public class ReplaceLower implements Command{

    /**

     Replaces a worker in the collection with a new one if it is lower than the given one.
     The new worker is obtained from user input using ConsoleCreation class.
     If the new worker is lower than the existing one, the existing worker is removed from the collection
     and the new worker is added.
     */
    @Override
    public void execute() {
        ConsoleCreation create = new ConsoleCreation();
        create.execute();
        for (Worker worker : repo.map.values()){
            if (worker.compareTo(create.getWorker()) > 0){
                create.getWorker().setId(worker.getId());
                repo.map.put(worker.getId(), create.getWorker());
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
        return "replace_if_lowe null {element} : заменить значение по ключу еслии новое значение меньше старого";
    }
}
