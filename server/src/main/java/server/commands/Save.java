package server.commands;

import server.commands.Command;
import com.fasterxml.jackson.databind.ObjectMapper;
import server.utils.Loader;
import server.utils.ResponseOutputer;

import java.io.IOException;

public class Save implements Command {
    public static ObjectMapper objectMapper = new ObjectMapper();
    Loader loader;


    public Save(Loader loader){
        this.loader = loader;
    }
    public Save(){}

    @Override
    public void execute(String argument, Object commandObjectArgument) {
        try {
            if (!argument.isEmpty() || commandObjectArgument != null) throw new IllegalArgumentException("Аргумент к " +
                    "команде не требуется");
            loader.save();
        }catch (IllegalArgumentException e){
            ResponseOutputer.appendln(e.getMessage());
        } catch (IOException e) {
            ResponseOutputer.appendln("Возникла проблема с файлом. Убедитесь, что файл существует и имеет достаточные права " +
                    "и перезапустите приложение");
            System.exit(1);
        }
    }
    /**
     Returns a String representation of the command, including its name and purpose.
     @return a String representation of the command
     */
    @Override
    public String toString(){
        return "save : сохранить коллекцию в файл";
    }
}
