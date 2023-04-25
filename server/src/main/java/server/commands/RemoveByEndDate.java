package server.commands;


import server.utils.Loader;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;


public class RemoveByEndDate implements Command{
    private LocalDateTime dateTime;
    Loader loader;

    public RemoveByEndDate(Loader loader) {
        this.loader = loader;
    }
    public RemoveByEndDate(){}

    @Override
    public void execute(String argument, Object commandObjectArgument){
        try{
            if (argument.isBlank()) throw new IllegalArgumentException("Дата не может быть пустой");
            String regex1 = "^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])t([01]\\d|2[0-3]):([0-5]\\d):([0-5]\\d)$";
            if (argument.matches(regex1)){
                this.dateTime = LocalDateTime.parse(argument);
                loader.removeByEndDate(dateTime);
            }else{
                throw new IllegalArgumentException("Неверный формат ввода даты. Строгий вормат ввода даты: гггг-мм-ддtчч:mm:ss");
            }
        }catch (Exception e){
            e.getMessage();
        }

    }

    @Override
    public String toString(){
        return "remove_any_by_end_date : удалить из коллекции один элемент, значение поля endDate которого меньше " +
                "экввалентному. Строгий вормат ввода даты: гггг-мм-ддtчч:mm:ss";
    }
}
