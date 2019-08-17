package ict.computer.generator.ae_testing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static List<Integer> keys = new ArrayList<>();
    private static Button btn_run = Button.create("GO");
    private static Scanner scanner = new Scanner(System.in);


    private static int rand(int max) {
        if (keys.size() == max)
            return -1;

        int n = (int) (Math.random() * max) + 1;

        if (!keys.contains(n)) {
            keys.add(n);
            return n;
        }

        return rand(max);
    }

    public static void main(String[] args) {

        btn_run.setOnClickedListener(new Button.OnClickedListener() {
            @Override
            public int onClicked() {
                return rand(10);
            }
        });

        run();

    }

    private static void run() {
        boolean stop = false;

        console();
        while (!stop) {
            System.out.print("\nConsole [0 - 1]: ");
            int input = scanner.nextInt();
            switch (input) {
                case 0:
                    stop = true;
                    break;
                case 1:
                    int value = btn_run.onClicked();
                    if (value != -1) {
                        System.out.println(value);
                    }
                    break;
            }
        }
    }

    private static void console() {
        System.out.println("Press "
                + "\t 1 - To click."
                + "\n\t\t 0 - To stop.");
    }


}
