package Parser;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Parser {

    private static Map<String,Integer> Commands = new HashMap<String, Integer>();
    public Parser() {
        Commands.put("cd", 0);
        Commands.put("pwd" , 0);
    }

    String[][] retArray = new String[2][2];
    String[] myArray;
    public String[][] parse(String input) {

        myArray = input.replaceAll("\\s+", " ").trim().split(" ");

        int args=0;
        for(int i  = 0 ; i < myArray.length;++i)
        {
            if(Commands.containsKey(myArray[i]))
            {
                retArray[i][args] = myArray[i];
                args++;
                int currenti= i;
                for(int k = 0 ; k < Commands.get(myArray[currenti]);++k)
                {
                    retArray[i][args]=myArray[i];
                    args++;
                    i++;
                }
                args=0;
            }
        }
        return retArray;
    }

}