package Labs_OOP.prometheus._week5;
import java.util.Scanner;

public class TestCommand {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String[] comm = {"help"};
        System.out.print("command help: ");
        Application.main(comm);
        String[] comm1 = {"echo", "hello world"};
        System.out.print("command echo hello world: ");
        Application.main(comm1);
        comm1[0] = "date";
        comm1[1]= "now";
        System.out.print("command date now: ");
        Application.main(comm1);
        comm[0] = "exit";
        System.out.print("command exit: ");
        Application.main(comm);
    }
}

