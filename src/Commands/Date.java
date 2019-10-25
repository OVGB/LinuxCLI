package Commands;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Date extends Command  {
    public Date (){ argNum = 2; }
    @Override
    public String run(String[] args, String args1){
        String output;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        output = dtf.format(now);
        System.out.println(output);
        return output;
    }
}