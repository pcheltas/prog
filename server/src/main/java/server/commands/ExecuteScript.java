package commands;

import support.CommandReader;
import support.Loader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.EmptyStackException;
import java.util.Objects;
import java.util.Scanner;
import java.util.Stack;

import static support.Loader.lineReader;

/**

 The ExecuteScript class implements the ArgumentCommand interface and represents

 a command that executes a script of commands from a specified file.
 */
public class ExecuteScript implements ArgumentCommand{
    static Stack<String> stackWithFiles = new Stack<>();
    static Stack<Scanner> stackWithScanners = new Stack<>();

    private String link;
    private String fileName;
    private FileReader fileReader;

    private Loader loader;
    private File file;


    /**

     Executes the script by reading commands from the specified file,

     checking for recursion, and executing each command using a CommandReader object.

     If recursion is detected, an exception is thrown.
     */
    @Override
    public void execute() {
        //Loader.setExecuteWorks(true);
        try {

                this.file = new File(link);
                //System.out.println("Имя файла " + fileName);
                //System.out.println("Путь " + link);
                stackWithFiles.push(this.file.getAbsolutePath());

                Scanner scanner = new Scanner(file);
                stackWithScanners.push(scanner);
                lineReader.setScanner(scanner);

                while (lineReader.getScanner().hasNext()) {
                    Loader.setExecuteWorks(true);
                    String command = lineReader.read();
                    if (command.trim().toLowerCase().split(" ")[0].equals("execute_script") && !checkRecursion(command)) {
                        lineReader.setScanner(new Scanner(System.in));
                        Loader.setExecuteWorks(false);
                        throw new IllegalArgumentException("\n\nОбнаружена рекурсия. Измените скрипт в файле");
                    } else if (command.trim().toLowerCase().split(" ")[0].equals("execute_script") && checkRecursion(command)) {
                        execute();
                    }
                    new CommandReader().read(command);
                }
                stackWithScanners.pop();
                try {
                    lineReader.setScanner(stackWithScanners.peek());
                    Loader.setExecuteWorks(true);
                } catch (EmptyStackException e) {
                    Loader.setExecuteWorks(false);
                    lineReader.setScanner(new Scanner(System.in));
                }
                //System.out.println("файл исполнен");

            } catch (IllegalArgumentException e) {
                stackWithScanners.clear();
                stackWithFiles.clear();
                lineReader.setScanner(new Scanner(System.in));
                System.out.println(e.getMessage());
            } catch (IOException e) {
                lineReader.setScanner(new Scanner(System.in));
                System.out.println("Файл не найден или имеет недостаточно доступа");
            }catch (RuntimeException e){
                lineReader.setScanner(new Scanner(System.in));
                System.out.println(e.getMessage());
            }
    }

    /**

     Checks for recursion by comparing the specified command with the files already being executed.

     If the file is already being executed, it returns false, indicating recursion.

     If the file is not being executed, it is added to the stack and true is returned, indicating no recursion.

     @param currentCommand the command to check for recursion

     @return true if the command does not cause recursion, false otherwise
     */
    public boolean checkRecursion(String currentCommand) {
        try {
            if (currentCommand.trim().toLowerCase().split(" ")[0].equals("execute_script") &&
                    stackWithFiles.contains(currentCommand.trim().toLowerCase().split(" ")[1])) {
                return false;

            } else if (currentCommand.trim().toLowerCase().split(" ")[0].equals("execute_script") &&
                    !stackWithFiles.contains(currentCommand.trim().toLowerCase().split(" ")[1])) {
                stackWithFiles.push(currentCommand.split(" ")[1]);
            }
        } catch (Exception e) {
            System.out.println("Ты ошибка!");
        }
        return true;
    }
    /**

     Sets the argument for executing a script.
     @param arg the argument for executing a script
     */
    @Override
    public void getArgument(String arg) {
        this.link = arg;
        //this.link = "C:\\Users\\Тасечка\\Desktop\\уник\\прога\\lb5\\src\\main\\java\\" + arg;
        this.fileName = arg;
        try {
            if (arg.isBlank()) throw new IllegalArgumentException("Имя исполняемого файла не может быть пустым");
            File file = new File(link);
            if (!file.canWrite() || !file.isFile()  || !file.canRead()) throw new IOException("Файл не имеет достаточного доступа");
            execute();
        } catch (IllegalArgumentException | IOException e) {
            System.out.println(e.getMessage());
        }
        //}catch (IllegalArgumentException e){
        //   System.out.println(e.getMessage());
        //}
    }


    /**
     Returns a String representation of the command, including its name and purpose.
     @return a String representation of the command
     */
    @Override
    public String toString(){
        return "execute_script : считать и исполнить скрипт из указанного файла";
    }

}
