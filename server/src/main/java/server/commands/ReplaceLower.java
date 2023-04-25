package server.commands;

import common.data.Worker;
import common.exceptions.WrongArgumentsException;
import common.functional.WorkerPacket;
import server.utils.Loader;
import server.utils.ResponseOutputer;

import static common.data.Worker.getCounter;

public class ReplaceLower implements Command{
    Loader loader;

    public ReplaceLower(Loader loader){
        this.loader = loader;
    }
    public ReplaceLower(){}

    @Override
    public void execute(String argument, Object commandObjectArgument) {
        try {
            if (!argument.isEmpty() || commandObjectArgument == null)
                throw new WrongArgumentsException("Необходимо ввести работника");
            WorkerPacket workerPacket = (WorkerPacket) commandObjectArgument;
            Worker.setCounter(getCounter() + 1);
            Worker worker = new Worker(Worker.getCounter(),
                    workerPacket.getName(),
                    workerPacket.getCoordinates(),
                    workerPacket.getCreationDate(),
                    workerPacket.getSalary(),
                    workerPacket.getStartDate(),
                    workerPacket.getEndDate(),
                    workerPacket.getStatus(),
                    workerPacket.getOrganization());
            loader.replaceGreater(worker);
        }catch (Exception e){
            ResponseOutputer.appendln(e.getMessage());
        }
    }
    @Override
    public String toString(){
        return "replace_if_lowe null {element} : заменить значение по ключу еслии новое значение меньше старого";
    }
}
