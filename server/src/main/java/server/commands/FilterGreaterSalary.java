package commands;

import worker.Worker;
import static support.Loader.repo;

/**

 The FilterGreaterSalary class implements the ArgumentCommand interface and represents a command that filters

 the collection and prints all workers with a salary greater than the specified value.
 */
public class FilterGreaterSalary implements ArgumentCommand{
    private int salary;

    /**

     Executes the command by iterating over the map of workers in the repository and printing all workers
     with a salary greater than the specified value.
     */
    @Override
    public void execute() {
        for (Worker worker : repo.map.values()) {
            if (worker.getSalary() > salary){
                System.out.println(repo.map.get(worker.getId()).toString());
            }
        }
    }

    /**

     Parses the argument and sets the salary value. If the argument is empty or not a positive integer,

     an IllegalArgumentException is thrown. If the salary value is successfully set, the execute() method is called.

     @param arg the argument passed to the command

     @throws IllegalArgumentException if the argument is empty or not a positive integer
     */
    @Override
    public void getArgument(String arg){
        if (arg.isBlank()) throw new IllegalArgumentException("Значение зарплаты не может быть пустым");

        try {
            if (!(Integer.parseInt(arg)>0)) throw new IllegalArgumentException("Зарплата должна быть больше 0");
            salary = Integer.parseInt(arg);
        }catch (NumberFormatException e){
            System.out.println("Введенная зарплата должна быть числом");
        }catch (IllegalArgumentException e){
            e.getMessage();
        }
        execute();
    }
    /**
     Returns a String representation of the command, including its name and purpose.
     @return a String representation of the command
     */
    @Override
    public String toString(){
        return "filter_greater_than_salary : вывести элементы, значение поля salary которых больше заданного";
    }
}
