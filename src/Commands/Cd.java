package Commands;

import LinuxCLI.Main;

import java.io.File;

public class Cd extends Command {
    public Cd() { argNum = 1; }
    @Override
    public String run(String[] args, String args1) {
//        System.out.println("Cd running");
        if(args.length > 2)
        {
            System.out.println("Too many Arguments for Command cd");
        }
        else if(args.length == 2) {
            String temppath = args[1]; //input path
            String path = temppath;  //full path


       if (temppath.equals("..")) {
                //System.out.println(temppath);
                int stoppingIdx = -1;
                for (int i = Main.workingDirectory.length() - 2; i >= 0; i--) {
                    if (Main.workingDirectory.charAt(i) == '\\') { //last \ in the path
                        stoppingIdx = i;
                        break;
                    }
                }
                if (stoppingIdx != -1) {
                    String newPath = ""; //newPath after going back
                    for (int i = 0; i <= stoppingIdx; i++) {
                        newPath += Main.workingDirectory.charAt(i);
                    }
                    Main.workingDirectory = newPath;
                }
                //System.out.println(Main.workingDirectory);
                return "";
            }

            if (!temppath.contains(":")) {
                path = Main.workingDirectory + temppath;
            }
            path.replaceAll("/", "\\");
            if (new File(path).exists()) {
                Main.workingDirectory = path + "\\";
                System.out.println("SUCCESS");
            } else {
                System.out.println("error: No such file or directory");
            }
        }
        else {
            Main.workingDirectory="C:\\";
        }

        return "";
    }
}
