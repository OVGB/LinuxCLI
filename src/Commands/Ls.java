import java.io.File;
import java.util.Arrays;

public class Ls extends Command {
    public Ls() { argNum = 0; }
    @Override
    public void run() {
        System.out.println("ls running");
        sortAll(Main.workingDirectory);
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
                System.out.print("Dir: " + file.getName() + "    ");
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
                System.out.print("File: " + file.getName() + "    ");
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
