package commands;

import worker.Worker;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

import static support.Loader.repo;

/**

 The RemoveByEndDate class represents a command to remove a worker from the repository by their end date.
 */
public class RemoveByEndDate implements ArgumentCommand{
    private LocalDateTime dateTime;

    /**
     Removes a worker from the repository by their end date.
     If there is a worker with the matching end date, it will be removed from the repository.
     If there are multiple workers with the same end date, only the first one found will be removed.
     If there is no worker with the specified end date, no worker will be removed.
     */
    @Override
    public void execute(){
        try{
            for (Worker worker : repo.map.values()){
                if (worker.getEndDate() != null && worker.getEndDate().equals(dateTime)){
                    repo.map.remove(worker.getId());
                    break;
                }
            }
        }catch (Exception e){
            e.getMessage();
        }

    }

    /**

     Parses the specified command argument as a LocalDateTime object in the format yyyy-MM-dd'T'HH:mm:ss
     and sets it as the end date of the worker to be removed.
     @throws IllegalArgumentException if the specified argument is blank or does not match the required format.
     Calls the execute method after parsing the argument.
     @param arg the command argument specifying the end date of the worker to be removed
     */
    @Override
    public void getArgument(String arg){
        if (arg.isBlank()) throw new IllegalArgumentException("Дата не может быть пустой");
        try {
            String regex1 = "^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])t([01]\\d|2[0-3]):([0-5]\\d):([0-5]\\d)$";
            if (arg.matches(regex1)){
                this.dateTime = LocalDateTime.parse(arg);
            }else{
                throw new IllegalArgumentException();
            }
        }catch (IllegalArgumentException | DateTimeParseException e){
            System.out.println("Неверный формат ввода даты. Строгий вормат ввода даты: гггг-мм-ддtчч:mm:ss");
        }
        execute();
    }
    /**
     Returns a String representation of the command, including its name and purpose.
     @return a String representation of the command
     */
    @Override
    public String toString(){
        return "remove_any_by_end_date : удалить из коллекции один элемент, значение поля endDate которого меньше " +
                "экввалентному. Строгий вормат ввода даты: гггг-мм-ддtчч:mm:ss";
    }
}
