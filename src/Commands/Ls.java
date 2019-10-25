package Commands;
import LinuxCLI.Main;

import java.io.File;
public class Ls extends Command {
    public Ls() { argNum = 0; }
    @Override
    public String run(String[] args, String args1){
        //System.out.println("ls running");
        return sortAll(Main.workingDirectory);
    }

    private static String sortAll(String dirName) {
        String output = "";
        File directory = new File(dirName);
        File[] filesArray = directory.listFiles();
        //sort all files
        //Arrays.sort(filesArray);
        //print the sorted values
        int cnt = 0;
        boolean change = true;
        for (File file : filesArray) {
            if (file.isDirectory()) {
                output += file.getName();
                System.out.print(Main.ANSI_BLUE + file.getName() + Main.ANSI_BLUE + "    ");
                cnt++;
                change=true;
            }
            if(cnt%3==0&&change) {
                output += "\n";
                System.out.print("\n");
                change=false;
            }
        }
        output = "\n";
        System.out.print("\n");
        cnt=0;
        change =true;
        for (File file : filesArray) {
            if (file.isFile()) {
                output += file.getName();
                System.out.print(Main.ANSI_WHITE + file.getName() + Main.ANSI_WHITE +  "    ");
                cnt++;
                change=true;
            }
            if(cnt%3==0&&change) {
                output += "\n";
                System.out.print("\n");
                change=false;
            }
        }
        System.out.println();
        return output;
    }
}
