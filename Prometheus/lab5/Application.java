package Labs_OOP.prometheus._week5;

interface Command {
    void execute();
}

public class Application {
    public static void main(String[] args) {
            //YOUR CODE COMES HERE

        if (args == (null) || args.length == 0 || args[0] == "") {
                System.out.println("Error");
        } else {
            if (args[0].equals("help") && args.length < 2) {
                    Help help = new Help();
                    help.execute();
            } else if (args[0].equals("echo") && args.length > 0) {
                    Echo print = new Echo();
                    print.str = args[1];
                    print.execute();
            } else if (args[0].equals("date") && args[1].equals("now")) {
                    Date_now date = new Date_now();
                    date.execute();
            } else if (args[0].equals("exit")) {
                    Exit exit = new Exit();
                    exit.execute();
            }
        }
    }
}
