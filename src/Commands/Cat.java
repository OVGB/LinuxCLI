package Commands;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

public class Cat extends Command {

    @Override
    public String run(String[] args, String args1) {
        String output = "";
        if(args.length > 1) {
            Vector<File> files = new Vector<File>();
            for (int i = 1; i < args.length; i++)
                files.add(new File(args[i]));

            for(int i = 0; i < files.size(); i++)
            {
                try {
                    Scanner scanner = new Scanner(files.elementAt(i));

                    while(scanner.hasNextLine())
                    {
                        String data = scanner.nextLine();
                        System.out.println(data);
                        output += data;
                    }

                }  catch (FileNotFoundException e) {
                    System.out.println("File not Found");
                }

            }

        }
        else{
//            File oneFile  = new File(args[0]);
//            try {
//                Scanner scanner = new Scanner(oneFile);
//
//                while(scanner.hasNextLine())
//                {
//                    System.out.println(scanner.nextLine());
//                }
//            } catch (FileNotFoundException e) {
//                System.out.println("File not Found");
//            }
            System.out.println("Arguments not enough for command Cat");
        }

        return output;
    }
}
