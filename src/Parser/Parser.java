package Parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Parser {
    public static Map<String, String> Commands = new HashMap<String, String>();

    public Parser() {
        commandsList = new ArrayList<ArrayList<String>>(0);
        Commands.put("help","help : help [-dms] [pattern ...] \nDisplay information about builtin commands.\n");
        Commands.put("cat","cat: cat [FILE]... \nConcatenate FILE(s) to standard output.\n");
        Commands.put("cd", "cd : cd [dir]  \nChange the shell working directory\n");
        Commands.put("clear","clear : clear \nClear the terminal\n");
        Commands.put("date","date : date [+FORMAT] like [MMDDdhhmm[[CC]YY][.ss]] \nDisplay the current time in the given FORMAT.\n");
        Commands.put("args","args : args [Command] \nList all the command arguments.\n");
        Commands.put("ls","ls : ls [FILE]... \nList information about the FILES(The current directory by default.\n");
        Commands.put("mkdir", "mkdir : mkdir [Directory]\nCreate the DIRECTORY(ies) , if they do not already exist.\n");
        Commands.put("pwd", "pwd : pwd\nPrint the name of the current working directory.\n");
        Commands.put("rmdir","rmdir : rmdir [Directory]\nRemove the DIRECTORY(ies), if they are empty.\n");
        Commands.put("cp", "cp : cp [SOURCE] [DESTINATION]\nCopy Source to DEST\n");
        Commands.put("mv", "cp : cp [SOURCE] [DESTINATION]\nCopy Source to DEST\n");
        Commands.put(">", "");
        Commands.put(">>", "");

    }

    public static ArrayList<ArrayList<String>> commandsList;
    String[][] retArray = new String[2][2];
    String[] myArray;
    public ArrayList<ArrayList<String>> makeCmd(String input) {

        input = input.replaceAll("\\s+", " ").trim();
        myArray = input.split("\\| "); // Split at pipes

        for (int i = 0; i < myArray.length; ++i) {
            myArray[i] = myArray[i].replaceAll(" > ", " > >");
            // System.out.println(myArray[i]);
            myArray[i] = myArray[i].replaceAll(" >> ", " >> >>");
        }
        for (int i = 0; i < myArray.length; ++i) {
            String[] reArray; // redirecting array
            ArrayList<String> temp = new ArrayList<>(0);
            String mystr = myArray[i];
            reArray = mystr.split(" > | >> ");
            for (int j = 0; j < reArray.length; ++j) {
                reArray[j] = reArray[j].replaceAll(">", "> ");
                reArray[j] = reArray[j].replaceAll(">>", ">> ");
                temp.add(reArray[j]); // put the array into the array list so that we can construct the CommandsList
                                      // arraylist
            }
            commandsList.add(temp); // add the piped stmts into the array list
        }
        return commandsList;
    }

    public boolean parse(ArrayList<ArrayList<String>> arr) {
        String tmp[];
        for (List<String> l1 : arr) {
            for (String n : l1) {
                tmp = n.split(" ");
                if (!Commands.containsKey(tmp[0])) {
                    // TO DO SUGGEST THE RIGHT COMMAND
                    System.out.println("Command '" + tmp[0] + "' not found ");
                    return false;
                }
            }
        }
        return true;
    }
}
