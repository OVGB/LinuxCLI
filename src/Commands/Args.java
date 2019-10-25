package Commands;

import Parser.Parser;

public class Args extends Command {

    @Override
    public String run(String[] args, String args1) {
        String output = "";
        if (args.length > 1) {
            for (int i = 1; i < args.length; ++i) {
                if (!Parser.Commands.containsKey(args[i])) {
                    System.out.println("Command " + args[i] + " Not Found");
                    return "";
                }
            }
            for (int i = 1; i < args.length; ++i) {
                System.out.print(Parser.Commands.get(args[i]));
                output += Parser.Commands.get(args[i]);
            }
        } else {
            System.out.println("Not enough arguments for command args");
        }

        return output;
    }
}
