package Commands;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Mkdir extends Command {
    public Mkdir() {
        argNum = 1;
    }

    @Override
    public String run(String[] args, String args1){
        if(!(new File(args[1]).exists())) {
            try {
                Files.createDirectories(Paths.get(args[1]));

            } catch (IOException ex) {
                return "File Creation Failed";
            }
            ;

            return "";
        }
        else System.out.println("File Already Exists");

        return "";
    }
}
