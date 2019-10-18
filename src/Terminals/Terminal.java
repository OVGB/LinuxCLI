package Terminals;

import Commands.Cd;
import Commands.Command;
import Commands.Pwd;

import java.util.HashMap;
import java.util.Map;

public class Terminal {

    public Terminal() {
        commandMap.put("cd" , new Cd());
        commandMap.put("pwd" , new Pwd());

    }
    private static Map<String,Command> commandMap = new HashMap<String, Command>();

    public static Command get(String key) {
        return commandMap.get(key);
    }

}

