package Parser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
public class Parser {
    private static Map<String, Integer> Commands = new HashMap<String, Integer>();
    public Parser() {
        Commands.put("cd", 0);
        Commands.put("pwd", 0);
        Commands.put("mkdir",1);
    }

    public static ArrayList<ArrayList<String>> commandsList = new ArrayList<ArrayList<String>>(0);
    String[][] retArray = new String[2][2];
    String[] myArray;
    /*
     * public boolean Constructo(String command , String[] Args,String St ) {
     * String[] tmp = St.split(" "); command = tmp[0]; for(int i = 1;i<
     * St.length();++i) { Args[i-1] = tmp[i]; } return true; }
     */

    public ArrayList<ArrayList<String>> parse(String input) {

        input = input.replaceAll("\\s+", " ").trim();
        myArray = input.split("\\| "); // Split at pipes

        for (int i = 0; i < myArray.length; ++i) {
            myArray[i] = myArray[i].replaceAll(" > ", " > >");
            // System.out.println(myArray[i]);
            myArray[i] = myArray[i].replaceAll(" < ", " < <");
        }
        for (int i = 0; i < myArray.length; ++i) {
            String[] reArray; // redirecting array
            ArrayList<String> temp = new ArrayList<>(0);
            String mystr = myArray[i];
            reArray = mystr.split(" > | < ");
            for (int j = 0; j < reArray.length; ++j) {
                reArray[j] = reArray[j].replaceAll(">", "> ");
                reArray[j] = reArray[j].replaceAll("<", "< ");
                temp.add(reArray[j]); // put the array into the array list so that we can construct the CommandsList
                                      // arraylist

            }
            commandsList.add(temp); // add the piped stmts into the array list

        }
        return commandsList;
    }

}
