package kg.askaromurkanov;

import java.util.Scanner;

public class Input {
    private static Input input;
    private Scanner in;

    private Input(){
        in = new Scanner(System.in);
    }

    public static Input getInstance(){
        if (input == null){
            input = new Input();
        }
        return input;
    }

    public Scanner getIn() {
        return in;
    }

    public static String getStartStation(){
        System.out.print("Start: ");
        return Input.getInstance().getIn().nextLine();
    }

    public static String getFinishStation(){
        System.out.print("Finish: ");
        return Input.getInstance().getIn().nextLine();
    }
}
