package control;

import java.util.*;

public class DictionaryCommand {
    
    HashMap<String, Command> setCommand;

    public DictionaryCommand(HashMap<String, Command> setCommand) {
        this.setCommand = setCommand;
    }

    public DictionaryCommand() {
        setCommand = new HashMap<>();
    }
    
    public Command get(String key){
        return setCommand.get(key);
    }
    
    public Command put(String key, Command value){
        return setCommand.put(key, value);
    }
    
}
