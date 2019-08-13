package ict.computer.generator.ab_testing;

import java.io.*;
import java.nio.file.NoSuchFileException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static List<Number> numberList = new ArrayList<>();

    public static void main(String[] args) {

        //Read data in file and store it in a list
        String text = read();
        String[] number = text.split("\\W+");
        System.out.println(number.length + " length\n");

        //process of storing data in list
        for (String num : number) {
            numberList.add(Number.create(num));
        }

        //display current objects in a list
        for (Number num : numberList) {
            System.out.print(num + " ");
        }

        //generate number and removed the object that was picked
        System.out.println("\n===================");
        while (numberList.size() != 0) {
            int rand = (int) (Math.random() * numberList.size()) + 1;
            int index = rand - 1;
            String picked = numberList.get(index).getNumber();
            System.out.println(picked);
            numberList.remove(index);
            if (find(picked) == null) {
                System.out.println(picked + " was deleted!");
                break;
            }
        }
        //update and store data in text file
        write();




    }

    private static void write() {
        List<Number> list = new ArrayList<>(numberList);
        String line = "";
        for (Number num : list) {
            System.out.print(num + " ");
            line += (num + " ");
        }

        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(
                    "C:\\Users\\Ariel Namias Austria\\Desktop\\ict_path\\ict_numbers.txt"));

            bw.write(line);
            bw.newLine();

            System.out.println("Successfully written!");
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

    private static Number find(String number) {
        System.out.println(numberList.size() + " size");
        for (Number num : numberList) {
            if (num.getNumber().equals(number)) {
                return num;
            }
        }
        return null;
    }

    private static String read() {
        BufferedReader br = null;
        String output = "";
        try {
            br = new BufferedReader(new FileReader(
                    "C:\\Users\\Ariel Namias Austria\\Desktop\\ict_path\\ict_numbers.txt"));
            String line = "";
            while ((line = br.readLine()) != null) {
                output += (line + "\n");
            }
            System.out.println("Successfully read...");
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

