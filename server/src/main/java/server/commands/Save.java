package commands;

import support.Loader;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;


/**

 The Save class represents a command to save the current state of the collection to a file.
 */
public class Save implements Command{
    public static ObjectMapper objectMapper = new ObjectMapper();


    /**

     Saves the current state of the collection to a file.
     Uses the FILE_PATH environment variable to determine the path of the file.
     If the file does not exist or cannot be accessed, the program exits with an error message.
     */
    @Override
    public void execute() {
        try {
            objectMapper.registerModule(new JavaTimeModule());
            //objectMapper.writeValue(new File(System.getenv("FILE")), Loader.repo);
            objectMapper.writeValue(new File(System.getenv("FILE_PATH")), Loader.repo);
            System.out.println("Коллекция успешно сохранена");
        } catch (IOException e) {
            System.out.println("Возникла проблема с файлом. Убедитесь, что файл существует и имеет достаточные права " +
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
