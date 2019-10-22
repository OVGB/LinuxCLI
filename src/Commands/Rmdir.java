package Commands;

import java.io.File;

public class Rmdir extends Command {
    @Override
    public String run(String[] args, String args1)
    {
        if(new File(args[0]).exists()) {
            File directory = new File(args[0]);
            String[] list = directory.list();
            if (list.length != 0) {
                System.out.println("Directory is not empty");
            } else {
                directory.delete();
            }

        }
        else {
            System.out.println("Directory do not exist");
        }
        return "";
    }
}
