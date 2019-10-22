package LinuxCLI;
import Commands.Command;
import Terminals.Terminal;

import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Terminal myTerminal = new Terminal();
        Scanner inp = new Scanner(System.in);
        String mystring = inp.nextLine();
        myTerminal.Execute(mystring);

    }
}