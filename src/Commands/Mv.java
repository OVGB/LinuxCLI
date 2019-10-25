package Commands;

import LinuxCLI.Main;

import java.io.*;

public class Mv extends Command {

    @Override
    public String run(String[] args, String args1)
    {
        String src1 = args[1];
        String src2 = args[2];
        if(args.length == 3)
        {
            if(!args[1].contains(":"))
                src1 = Main.workingDirectory + args[1];
            if(!args[2].contains(":"))
                src2 = Main.workingDirectory + args[2];

            File fileOne = new File(src1);
            File fileTwo = new File(src2);


            if(fileOne.isFile() && fileTwo.isDirectory())
            {
                try {
                    fileTwo = new File(src2 + "\\" + getFileName(args[1]));
                    fileTwo.createNewFile();
                    copyFileUsingStream(fileOne,fileTwo);
                    fileOne.delete();
                    //System.out.println("Worked");
                } catch (IOException e)
                {
                    System.out.println("unable to copy");
                }

                return "";
            }
            if(fileOne.isFile() && !fileTwo.isDirectory() && !args[1].contains("\\") && !args[2].contains("\\"))
            {
                if(!fileTwo.exists())
                {
                    fileOne.renameTo(fileTwo);
                    return "";
                }
            }
            else {
                System.out.println("Invalid Arguments");
            }

        }
        else {
            System.out.println("invalid Arguments");
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
