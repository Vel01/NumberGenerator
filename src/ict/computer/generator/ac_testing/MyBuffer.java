package ict.computer.generator.ac_testing;

import java.io.*;
import java.nio.file.NoSuchFileException;
import java.util.ArrayList;
import java.util.List;

final class MyBuffer<T extends Number> {

    private static final String PATH = "C:\\ict_path\\ict_numbers.txt";

    void write(List<T> series) {
        String line = "";
        for (T num : new ArrayList<>(series)) {
//            System.out.print(num + " ");
            line += (num + " ");
        }

        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(PATH));

            bw.write(line);
            bw.newLine();
//            System.out.println("Successfully written!");
        } catch (IOException e) {
            System.out.println("Error!");
        } finally {// object bw will still close even some block of code don't run
            try {
                assert bw != null;
                bw.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    String read() {
        BufferedReader br = null;
        String output = "";
        try {
            br = new BufferedReader(new FileReader(PATH));
            String line = "";
            while ((line = br.readLine()) != null) {
                output += (line + "\n");
            }
//            System.out.println("Successfully read...");
        } catch (NoSuchFileException e) {
            System.out.println("No such file.");
        } catch (IOException e) {
            System.out.println("Error!");
        } finally {
            try {
                assert br != null;
                br.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return output;
    }


}
