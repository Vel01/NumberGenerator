package ict.computer.generator.ad_testing;

import java.util.ArrayList;
import java.util.List;

final class Generator {

    private List<Number> series = new ArrayList<>();
    private MyBuffer<Number> buffer = new MyBuffer<>();

    String picked() {

        retrieveData();
        String picked = null;
        while (series.size() != 0) {

            int index = randomNumber() - 1;
            picked = series.get(index).getNumber();
            series.remove(index);
            if (find(picked) == null)
                break;
        }
        buffer.write(series);
        if (picked != null) {
            System.out.println(picked + " was picked!");
            return picked;
        }

        System.out.println("\n ### LIST IS EMPTY ### ");
        return null;
    }

    private int randomNumber() {
        return (int) (Math.random() * series.size()) + 1;
    }

    private void retrieveData() {
        String data = buffer.read("C:\\ict_path\\ict_numbers.txt");
        for (String number : data.split("\\W+")) {
            series.add(Number.create(number));
        }
    }

    private Number find(String number) {
        for (Number num : series) {
            if (num.getNumber().equals(number)) {
                return num;
            }
        }
        return null;
    }

}
