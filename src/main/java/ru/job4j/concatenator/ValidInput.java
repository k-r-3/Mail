package ru.job4j.concatenator;

import java.util.InputMismatchException;

public class ValidInput implements Input {
    private Input in;

    public ValidInput(Input in) {
        this.in = in;
    }

    @Override
    public String askString(String question) {
        return in.askString(question);
    }

    @Override
    public int askInt(String item) {
        boolean valid = false;
        int point = -1;
            try {
                point = in.askInt(item);
                valid = true;
            } catch (InputMismatchException e) {
                System.out.println("wrong menu item");
                System.exit(-1);
            }
        return point;
    }
}
