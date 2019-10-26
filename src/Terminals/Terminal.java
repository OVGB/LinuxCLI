package Terminals;

import Commands.Date;
import Commands.*;
import LinuxCLI.Main;
import Parser.Parser;

import java.util.*;

public class Terminal {
    private static Map<String, Command> commandMap = new HashMap<String, Command>();
    private static ArrayList<ArrayList<String>> Commands;

    public Terminal() {
        commandMap.put("args", new Args());
        commandMap.put("cat", new Cat());
        commandMap.put("cd", new Cd());
        commandMap.put("clear", new Clear());
        commandMap.put("cp", new Cp());
        commandMap.put("date", new Date());
        commandMap.put("help", new Help());
        commandMap.put("ls", new Ls());
        commandMap.put("mkdir", new Mkdir());
        commandMap.put("mv", new Mv());
        commandMap.put("pwd", new Pwd());
        commandMap.put("rmdir", new Rmdir());
        commandMap.put(">", new redir());
        commandMap.put(">>",new Dredir());
    }

    public static Command getCommand(String key) {
        return commandMap.get(key);
    }

    public boolean Execute() {
        Commands = new ArrayList<ArrayList<String>>(0);
        System.out.print(Main.ANSI_WHITE + Main.workingDirectory + " ");

        Scanner inp = new Scanner(System.in);
        String input = inp.nextLine();
        if(input.equals("exit"))
            return false;
        if(input.equals("")) return true;
        Parser myParser = new Parser();
        Commands = myParser.makeCmd(input);

        String c;
        // TO DO STRING ARGS
        // String[] Args;
        if (myParser.parse(Commands)) {
            String output="";
            for (List<String> l1 : Commands)
                for (String n : l1) {
                    // TO DO MAKE FUNC TO RET ARGS ARRAY AND THE COMMAND
                    String[] tmp = n.split(" ");
                    c = tmp[0];
                    /*
                     * for(int i = 1;i< n.length();++i) { Args[i-1] = tmp[i]; }
                     */
                    Command myCommand = getCommand(c);
                    output= myCommand.run(tmp, output);
                }
        }
        return true;
    }

}
