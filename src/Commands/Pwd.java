package Commands;

import LinuxCLI.Main;

public class Pwd extends Command {
    public Pwd() {
        argNum = 0;
    }

    @Override
    public String run(String[] args, String args1) {
        System.out.println("pwd running");
        System.out.println(Main.workingDirectory);
        return "";

    }
}
