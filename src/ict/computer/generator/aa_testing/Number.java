package ict.computer.generator.aa_testing;

final class Number {

    private final String number;

    private Number(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return number + " was picked!";
    }

    public static Number create(String number) {
        return new Number(number);
    }
}
