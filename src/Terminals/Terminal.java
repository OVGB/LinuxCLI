package Terminals;

import Commands.*;
import Parser.Parser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Terminal {
    private static Map<String, Command> commandMap = new HashMap<String, Command>();
    private static ArrayList<ArrayList<String>> Commands = new ArrayList<ArrayList<String>>(0);

    public Terminal() {
        commandMap.put("mkdir", new Mkdir());
        commandMap.put("cd", new Cd());
        commandMap.put("pwd", new Pwd());
        commandMap.put("ls", new Ls());

    }

    public static Command getCommand(String key) {

        return commandMap.get(key);
    }

    public void Execute(String input) {
        Parser myParser = new Parser();
        Commands = myParser.makeCmd(input);

        String c;
        // TO DO STRING ARGS
        // String[] Args;
        if (myParser.parse(Commands)) {
            for (List<String> l1 : Commands)
                for (String n : l1) {
                    // TO DO MAKE FUNC TO RET ARGS ARRAY AND THE COMMAND
                    String[] tmp = n.split(" ");
                    c = tmp[0];
                    /*
                     * for(int i = 1;i< n.length();++i) { Args[i-1] = tmp[i]; }
                     */
                    Command myCommand = getCommand(c);
                    myCommand.run(tmp, c);
                }
        }
    }

}
