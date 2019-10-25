package Commands;

import LinuxCLI.Main;

import java.io.File;

public class Rmdir extends Command {
    @Override
    public String run(String[] args, String args1)
    {
        if(args.length > 1) {
            if(!args[1].contains(":"))
                args[1] = Main.workingDirectory + args[1];
            if (new File(args[1]).exists()) {
                File directory = new File(args[1]);
                if(!directory.isDirectory())
                {
                    System.out.println("Failed! Must be a Directory");
                    return "";
                }
                String[] list = directory.list();
                if (list.length != 0) {
                    System.out.println("Directory is not empty");
                    return "";
                } else {
                    directory.delete();
                    return "";
                }

            } else {
                System.out.println("Directory do not exist");
                return  "";
            }
        }
        return "";
    }
}
