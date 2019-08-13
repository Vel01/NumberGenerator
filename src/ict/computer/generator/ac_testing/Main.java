package ict.computer.generator.ac_testing;

import java.util.*;

public class Main {

    private static Button btn_run = Button.create("GO");
    private static List<Integer> eliminated = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        btn_run.setOnClickedListener(new Button.OnClickedListener() {
            @Override
            public String onClicked() {
                Generator generate = new Generator();
                return generate.picked();
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
                    String value = btn_run.onClicked();
                    if (value != null) {
                        eliminated.add(Integer.valueOf(value));
                        Collections.sort(eliminated);
                        for (int num : eliminated) {
                            System.out.print(num + " ");
                        }
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
