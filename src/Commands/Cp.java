package Commands;

import LinuxCLI.Main;

import java.io.*;
import java.util.Vector;

public class Cp extends Command {
    @Override
    public String run(String[] args, String args1)
    {
        if(args.length >= 3) {

            String[] src = args;
            File tempFile;

            for(int i = 1; i < src.length; i++)
                if(!args[i].contains(":"))
                    src[i] = Main.workingDirectory + args[i];

            Vector<File> files = new Vector<>();
            int last = src.length - 1;
            System.out.println(last);
            for(int i = 1; i <= last; i++)
                files.add(new File(src[i]));

            if(!files.elementAt(last-1).isDirectory())
                System.out.println("invalid Arguments");
            else {
                for(int i = 1; i < last; i++)
                {
                    try {
                        tempFile = new File(src[last] + "\\" + getFileName(src[i]));
                        tempFile.createNewFile();
                        copyFileUsingStream(files.elementAt(i-1),tempFile);
                    } catch (IOException e) {
                        System.out.println("Unable to copy");
                    }
                }

                return "";
            }

        }
        else {
            System.out.println("Invalid Arguments");
        }
        return "";
    }

    private static void copyFileUsingStream(File source, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            is.close();
            os.close();
        }
    }

    private String getFileName(String arg)
    {
        if(arg.contains("\\"))
        {
            int ind = arg.lastIndexOf("\\");
            return arg.substring(ind + 1,arg.length());
        }
        return arg;
    }

}
