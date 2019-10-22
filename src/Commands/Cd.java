package Commands;

public class Cd extends Command {
    public Cd() { argNum = 1; }
    @Override
   public String run(String[] args, String args1){
        System.out.println("Cd running");
        return "";
    }
}