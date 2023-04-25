
package server.utils;
import server.commands.*;

import java.util.HashMap;
import java.util.TreeMap;

public class CommandControl {
    private HashMap<String, Command> commands;

    public CommandControl(Command show, Command clear, Command help, Command insert, Command info, Command save,
                          Command replaceIfGreater, Command replaceIfLowe, Command removeIfGreater,
                          Command printFieldDescendingEndDate, Command removeKey, Command executeScript,
                          Command update, Command filterGreaterSalary, Command removeAnyByEndDate, Loader loader){

        commands = new HashMap<>();

        commands.put("show", show);
        commands.put("clear", clear);
        commands.put("help", help);
        commands.put("insert", insert);
        commands.put("info", info);
        commands.put("save", save);
        //commands.put("exit", exit);
        commands.put("replace_if_greater", replaceIfGreater);
        commands.put("replace_if_lowe", replaceIfLowe);
        commands.put("remove_if_greater", removeIfGreater);
        commands.put("print_field_descending_end_date", printFieldDescendingEndDate);
        commands.put("remove_key", removeKey);
        commands.put("execute_script", executeScript);
        commands.put("update", update);
        commands.put("filter_greater_than_salary", filterGreaterSalary);
        commands.put("remove_any_by_end_date", removeAnyByEndDate);

    }
    public HashMap<String, Command> getMapping() {
        return commands;
    }
}
