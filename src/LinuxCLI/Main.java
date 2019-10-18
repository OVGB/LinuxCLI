package LinuxCLI;
import Commands.Command;
import Terminals.Terminal;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Parser P = new Parser();
        //P.parse( "BLAH");
        Terminal myTerminal = new Terminal();
        Scanner inp = new Scanner(System.in);
        String key = inp.next();
        Command runningCommand = Terminal.get(key);
        runningCommand.run();

    }
}