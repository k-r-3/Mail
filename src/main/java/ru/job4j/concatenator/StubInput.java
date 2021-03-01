package ru.job4j.concatenator;

public class StubInput implements Input {
    String message;

    public StubInput(String message) {
        this.message = message;
    }

    @Override
    public String askString(String question) {
        return message;
    }

    @Override
    public int askInt(String item) {
        return -1;
    }
}
