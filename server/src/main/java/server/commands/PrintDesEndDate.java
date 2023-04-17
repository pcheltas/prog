package commands;

import worker.Worker;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static support.Loader.repo;

/**

 The PrintDesEndDate class implements Command interface that prints a list of all worker end dates in descending order.
 */
public class PrintDesEndDate implements Command{

    /**

     Executes the command to print a list of all worker end dates in descending order.
     Uses a Comparator to sort the list of end dates in descending order,
     then prints the list to the console.
     */
    @Override
    public void execute() {
        Comparator<LocalDateTime> comparator = Collections.reverseOrder();
        ArrayList<LocalDateTime> endDates = new ArrayList<>();
        for (Worker worker : repo.map.values()) {
            if (worker.getEndDate() != null){
                endDates.add(worker.getEndDate());
            }
        }
        endDates.sort(comparator);
        System.out.println(endDates);
    }
    /**
     Returns a String representation of the command, including its name and purpose.
     @return a String representation of the command
     */
    @Override
    public String toString(){
        return "print_field_descending_end_date : вывести значения поля endDate всех элементов в порядке убывания";
    }



}
