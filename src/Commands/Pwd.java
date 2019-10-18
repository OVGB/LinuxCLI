package Commands;

public class Pwd extends Command {
    public Pwd() { argNum = 0; }
    @Override
    public void run() {
        System.out.println("pwd running");
    }
}