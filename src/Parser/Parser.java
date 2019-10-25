package Parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Parser {
    private static Map<String, Integer> Commands = new HashMap<String, Integer>();

    public Parser() {
        commandsList = new ArrayList<ArrayList<String>>(0);
        Commands.put("cat",9);
        Commands.put("cd", 0);
        Commands.put("clear",0);
        Commands.put("ls",0);
        Commands.put("mkdir", 1);
        Commands.put("pwd", 0);
        Commands.put("rmdir",1);
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
