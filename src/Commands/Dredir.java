package Commands;

import LinuxCLI.Main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Dredir extends Command {
    String output = "";

    @Override
    public String run(String[] args, String args1) {
        if (args1.equals(""))
            return output;
        if (args.length == 2) {
            if(!args[1].contains(":"))
                args[1] = Main.workingDirectory + args[1];
            File tmp = new File(args[1]);
            if (!tmp.exists()) {
                try {
                    tmp.createNewFile();
                } catch (IOException e) {
                    System.out.println("Cannot create the file.");
                }
            }
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(tmp));
                writer.write(args1);
                writer.close();
            } catch (IOException e) {
                System.out.println("Cannot write to file.");
            }
            return args1;

        } else {
            System.out.println("Not enough Arguments for > ");
        }
        return "";
    }
}
