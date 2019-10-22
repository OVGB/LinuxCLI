package Terminals;

import Commands.Cd;
import Commands.Command;
import Commands.Pwd;
import Parser.Parser;
import java.util.HashMap;
import java.util.Map;
public class Terminal {
    private static Map<String,Command> commandMap = new HashMap<String, Command>();

    private  static String[][] myArr;
    public Terminal() {
        commandMap.put("cd" , new Cd());
        commandMap.put("pwd" , new Pwd());
        commandMap.put("ls" , new Ls());

    }

    public static Command getCommand(String key) {

        return commandMap.get(key);
    }

    public static void Execute(String input)
    {
         Parser myParser = new Parser();
         myArr = myParser.parse(input);
         for(int i = 0 ; i<myArr.length;++i){
             Command myCommand = getCommand(myArr[i][0]);
             myCommand.run();
         }
    }

}

