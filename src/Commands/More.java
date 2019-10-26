package Commands;

import LinuxCLI.Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.util.Scanner;
import java.util.Vector;

public class More extends Command {

    @Override
    public String run(String[] args, String args1) {
        String output = "";

        if (args.length >= 2) {
            Vector<String> stringVector = new Vector<>();
            if (args.length > 1) {
                Vector<File> files = new Vector<File>();
                for (int i = 1; i < args.length; i++) {
                    // if (!args[i].contains(":"))
                    args[i] = Main.workingDirectory + args[i];
                    files.add(new File(args[i]));
                }
                for (int i = 0; i < files.size(); i++) {
                    try {
                        Scanner scanner = new Scanner(files.elementAt(i));
                        BufferedReader dummy = new BufferedReader(new InputStreamReader(System.in));
                        System.out.println(":::::::::::::::::::::");
                        System.out.println(files.elementAt(i).getName());
                        System.out.println(":::::::::::::::::::::");
                        for (int j = 0; j < 5 && scanner.hasNextLine(); j++) {
                            String data = scanner.nextLine();
                            System.out.println(data);
                            output += data;
                        }
                        while (scanner.hasNextLine()) {
                            try {
                                int line = dummy.read();
                            } catch (IOException e) {
                                // TODO Auto-generated catch block
                                System.out.println("Cannot read input.");
                            }
                            // System.out.println("Da5alt");
                            String data = scanner.nextLine();
                            System.out.print(data);
                            output += data;
                        }
                    } catch (FileNotFoundException e) {
                        System.out.println("File not Found");
                    }
                }

            }
        } else if (!args1.equals("")) {
            System.out.println(args1);
            Integer count = 0;
            count = countLines(args1);
            output = args1;
            if (count <= 10) {
                System.out.print(output);

            } else {
                BufferedReader dummy = new BufferedReader(new InputStreamReader(System.in));
                String[] mystr = args1.split("\r\n|\r|\n");
                for (int i = 0; i < 5; i++) {
                    System.out.println(mystr[i]);
                }
                for (int i = 5; i < mystr.length; ++i) {
                    try {
                        int line = dummy.read();
                        System.out.print(mystr[i]);
                    } catch (IOException e) {
                       System.out.println("Cannot read input.");
                    }
                }
                System.out.println();
            }
            return output;
        } else {
            System.out.println("Arguments not enough for command More");
            return "";
        }
        return output;
    }

    private static int countLines(String str) {
        String[] lines = str.split("\r\n|\r|\n");
        return lines.length;
    }

}
