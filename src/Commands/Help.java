package Commands;

import java.util.Map;
import Parser.Parser;;

public class Help extends Command {
    String output = "";

    @Override
    public String run(String[] args, String args1) {
        for (Map.Entry<String, String> entry : Parser.Commands.entrySet()) {
            System.out.println(entry.getValue());
            output += entry.getValue();
        }
        return output;
    }
}
