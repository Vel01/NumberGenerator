package ict.computer.generator.aa_testing;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static List<Number> series = new ArrayList<>();

    public static void main(String[] args) {

        //syntax for getting the index
//        int index = (int) (Math.random() * 5) + 1;


        series.add(Number.create("1"));
        series.add(Number.create("2"));
        series.add(Number.create("3"));
        series.add(Number.create("4"));
        series.add(Number.create("5"));

        while (series.size() != 0) {
            int index = (int) (Math.random() * series.size()) + 1;

            int temp = (index - 1);
            Number picked = series.get(temp);
            String num = picked.getNumber();
            System.out.println(picked + " " + temp);
            series.remove(temp);
            if (find(num) == null) {
                System.out.println(picked + " And was removed!");
//                break;
            }
        }
    }

    private static Number find(String number) {
        System.out.println(series.size() + " size");
        for (int i = 0; i < series.size(); i++) {
            Number num = series.get(i);
            if (num.getNumber().equals(number)) {
                return num;
            }
        }
        return null;
    }

}
