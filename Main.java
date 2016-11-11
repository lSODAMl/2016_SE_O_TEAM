import CLI.*;

public class Main {
    public static void main(String[] args) {
        CLI cli = new CLI();
        if(!cli.Receive(args)){

        }

        else {
            cli.MakeHTML();
            cli.CLI_Result();
        }
    }
}
