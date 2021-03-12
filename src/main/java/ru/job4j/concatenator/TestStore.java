package ru.job4j.concatenator;

import java.util.*;

public class TestStore implements Store {
    private List<User> users = new ArrayList<>();

    public TestStore(List<User> users) {
        this.users = users;
    }

    @Override
    public void add() {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<User> getUsers() {
        return users;
    }
}
