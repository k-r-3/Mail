package ru.job4j.concatenator;

import java.util.*;

public class UserStore implements Store {
private Scanner sc = new Scanner(System.in);
private List<User> users = new ArrayList<>();

    @Override
    public void add() {
        System.out.println("Enter username");
        String name = sc.nextLine();
        while (name.matches(".*@.*")) {
            System.out.println("username can not contain '@'");
            name = sc.nextLine();
        }
        System.out.println("Enter emails with ','");
        String email = sc.nextLine();
        while (!email.matches("(\\w*@\\w*\\W\\w*.)+")) {
            System.out.println("wrong email");
            email = sc.nextLine();
        }
        Set<String> emails = new HashSet<>(Arrays.asList(email.split(",")));
        User user = new User(name, emails);
        users.add(user);
    }

    @Override
    public List<User> getUsers() {
        return users;
    }
}
