package Commands;
import java.io.File;
import java.util.Arrays;
import LinuxCLI.*;
public class Ls extends Command {
    public Ls() { argNum = 0; }
    @Override
    public String run(String[] args, String args1){
        System.out.println("ls running");
        sortAll(Main.workingDirectory);
        return "";
    }

    private static void sortAll(String dirName) {
        File directory = new File(dirName);
        File[] filesArray = directory.listFiles();
        //sort all files
        //Arrays.sort(filesArray);
        //print the sorted values
        int cnt = 0;
        boolean change = true;
        for (File file : filesArray) {
            if (file.isDirectory()) {
                System.out.print(Main.ANSI_BLUE + file.getName() + Main.ANSI_BLUE + "    ");
                cnt++;
                change=true;
            }
            if(cnt%3==0&&change) {
                System.out.print("\n");
                change=false;
            }
        }
        System.out.print("\n");
        cnt=0;
        change =true;
        for (File file : filesArray) {
            if (file.isFile()) {
                System.out.print(Main.ANSI_WHITE + file.getName() + Main.ANSI_WHITE +  "    ");
                cnt++;
                change=true;
            }
            if(cnt%3==0&&change) {
                System.out.print("\n");
                change=false;
            }
        }
    }
}
