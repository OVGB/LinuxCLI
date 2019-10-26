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
       // commandMap.put(">",new Redirect());
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
            for (List<String> l1 : Commands)
                for (String n : l1) {
                    // TO DO MAKE FUNC TO RET ARGS ARRAY AND THE COMMAND
                    int BeginInd = 0, EndInd = 0;
                    boolean flag = true;
                    BeginInd = n.indexOf("\"",EndInd+1);
                    EndInd = n.indexOf("\"",BeginInd+1);
                    if(EndInd == -1)
                        flag = false;
                    while(BeginInd != -1 && EndInd != -1 && flag)
                    {
                        System.out.println(BeginInd+ " " +EndInd);
                        String subString = n.substring(BeginInd,EndInd);
                        while(subString.contains(" "))
                            subString = subString.replace(' ','?');
                        n = n.replace(n.substring(BeginInd,EndInd),subString);
                        BeginInd = n.indexOf("\"",EndInd+1);
                        EndInd = n.indexOf("\"",BeginInd+1);
                        if(EndInd == -1)
                            flag = false;
                    }
                    if(flag)
                    {
                        String[] tmp = n.split(" ");
                        for (int i = 0; i < tmp.length; i++) {
                            while (tmp[i].contains("?"))
                                tmp[i] = tmp[i].replace('?', ' ');
                            while (tmp[i].contains("\""))
                                tmp[i] = tmp[i].replaceAll("\"", "");
                        }
                        c = tmp[0];
                        /*
                         * for(int i = 1;i< n.length();++i) { Args[i-1] = tmp[i]; }
                         */
                        Command myCommand = getCommand(c);
                        myCommand.run(tmp, c);
                    }
                    else {
                        System.out.println("Invalid Input");
                    }
                }
        }
        return true;
    }

}
