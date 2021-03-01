package ru.job4j.concatenator;

import java.util.HashSet;

public interface Create {

    HashSet getUsers();

    String operation(String[] in);

    boolean checkName(String name);

    boolean checkEmail(String email);
}
