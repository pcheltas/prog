package server.commands;

import server.utils.Loader;
import server.utils.ResponseOutputer;


public class PrintDesEndDate implements Command{
    Loader loader;

    public PrintDesEndDate (Loader loader){
        this.loader = loader;
    }
    public PrintDesEndDate (){}
    @Override
    public void execute(String commandArgument, Object commandObjectArgument) {
        try{
            loader.printDesEndDate();
        }catch (Exception e){
            ResponseOutputer.appendln(e.getMessage());
        }

    }
    @Override
    public String toString(){
        return "print_field_descending_end_date : вывести значения поля endDate всех элементов в порядке убывания";
    }



}
