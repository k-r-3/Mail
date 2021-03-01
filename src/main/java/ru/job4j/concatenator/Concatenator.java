package ru.job4j.concatenator;

import java.util.*;

public class Concatenator implements Actions {
    private Create users;
    private HashSet<User> userSet;
    private Map<User, Set<String>> forTest = new HashMap<>();

    public Concatenator(Create users) {
        this.users = users;
    }

    @Override
    public boolean operation(UserInput in) {
        Map<User, Set<String>> intermediateResult = new HashMap<>();
        Map<User, Set<String>> finalResult = new HashMap<>();
        Map<String, User> supplier = new HashMap<>();
        ArrayDeque<User> stack = new ArrayDeque<>();
        userSet = users.getUsers();
        var iter = userSet.iterator();
        if (userSet.isEmpty()) {
            System.out.println("Create user before");
            return true;
        }
        while (iter.hasNext()) {
            User user = iter.next();
            Iterator<String> mailIter = user.getMails().iterator();
            while (mailIter.hasNext()) {
                String mail = mailIter.next();
                if (!supplier.containsKey(mail)) {
                    supplier.put(mail, user);
                } else {
                    supplier.get(mail).getMails().addAll(user.getMails());
                    break;
                }
                intermediateResult.put(supplier.get(mail), supplier.get(mail).getMails());
                if (!stack.contains(supplier.get(mail))) {
                    stack.add(supplier.get(mail));
                }
            }
        }
        var resultIter = intermediateResult.entrySet().iterator();
        User user = stack.removeLast();
        while (resultIter.hasNext()) {
            Map.Entry<User, Set<String>> entry = resultIter.next();
            for (String mail : entry.getValue()) {
                if (user.getMails().contains(mail)) {
                    entry.getValue().addAll(user.getMails());
                    finalResult.put(entry.getKey(), entry.getValue());
                    if (stack.size() > 1) {
                        user = stack.removeLast();
                    }
                    break;
                }
            }
            if (!finalResult.containsValue(user.getMails())) {
                finalResult.put(entry.getKey(), entry.getValue());
            }
        }
        System.out.println(finalResult);
        forTest = finalResult;
        return true;
    }

    public Map<User, Set<String>> getMap() {
        return forTest;
    }

    @Override
    public String name() {
        return "1. Join users";
    }
}
