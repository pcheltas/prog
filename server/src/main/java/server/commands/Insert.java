package server.commands;

import worker.Worker;

import static common.data.Worker.getCounter;

public class Insert implements Command {
    Loader loader;
    public Insert (Loader loader){
        this.loader = new Loader();
    }
    public Insert(){}

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

    @Override
    public String toString(){
        return "insert null {element} : добавить новый элемент с заданным ключом";
    }
}