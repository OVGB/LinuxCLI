package Commands;

public class Clear extends Command {
    public Clear() { argNum = 0; }
    @Override
    public String run(String[] args, String args1){
        System.out.println("clear running");
        for(int i = 0; i < 100; i++) {
            System.out.print("\n");
        }
        return "";
    }
}
