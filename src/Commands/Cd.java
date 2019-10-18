package Commands;

public class Cd extends Command {
    public Cd() { argNum = 1; }
    @Override
    public void run() {
        System.out.println("Cd running");
    }
}