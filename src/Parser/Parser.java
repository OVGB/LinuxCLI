package Parser;

import java.util.Scanner;

public class Parser {

    String[] args;
    String cmd;

    public boolean parse(String input) {
        Scanner inp = new Scanner(System.in);
        String line = inp.nextLine();               //cmd line from user.
        System.out.print(line);
        return true;
    }
}
