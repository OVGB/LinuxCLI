package Commands;

import LinuxCLI.Main;

import java.io.File;
import java.util.Vector;

public class Rm extends Command {

    @Override
    public String run(String[] args, String args1) {
        if(args.length > 2)
        {
            Vector<File> files = new Vector<File>();
            String[] src = args;
            for(int i = 1; i < src.length; i++)
                if(!args[i].contains(":"))
                    src[i] = Main.workingDirectory + args[i];

            for(int i = 1; i < src.length; i++)
                files.add(new File(src[i]));

            for(int i = 0; i < files.size(); i++)
            {
                if(!files.elementAt(i).exists())
                {
                    System.out.println("Directories does not exist");
                    return "";
                }
            }

            for(int i = 0; i < files.size(); i++)
                files.elementAt(i).delete();

        }
        else {
            System.out.println("Invalid Arguments");
        }

        return "";
    }
}
