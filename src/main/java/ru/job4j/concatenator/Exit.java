package ru.job4j.concatenator;

public class Exit implements Actions {

    @Override
    public boolean operation(UserInput in) {
        System.out.println("Exit...");
        return false;
    }

    @Override
    public String name() {
        return "2. Exit";
    }
}
