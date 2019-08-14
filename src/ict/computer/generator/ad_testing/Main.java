package ict.computer.generator.ad_testing;

import java.util.Scanner;

public class Main {

    private static Button btn_run = Button.create("GO");
    private static Scanner scanner = new Scanner(System.in);


    private static Settings settings = new Settings();

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
                        settings.save(value, "C:\\ict_path\\ict_eliminated_numbers.txt");
                    }
                    break;
                case 2:
                    settings.showEliminatedNumbers("C:\\ict_path\\ict_eliminated_numbers.txt");
                    break;
                case 3:
                    settings.generate();
                    break;
                case 4:
                    settings.generatedWithoutEliminatedNumbers("C:\\ict_path\\ict_eliminated_numbers.txt");
                    break;
            }
        }
    }

    private static void console() {
        System.out.println("Press "
                + "\t 1 - To click."
                + "\n\t\t 2 - To show picked."
                + "\n\t\t 3 - To generate."
                + "\n\t\t 4 - To generate w/o eliminated numbers."
                + "\n\t\t 0 - To stop.");
    }


}
