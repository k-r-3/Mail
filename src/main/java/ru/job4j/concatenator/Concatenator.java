package ru.job4j.concatenator;
import java.util.*;

public class Concatenator {
    private Store store;

    public Concatenator(Store store) {
        this.store = store;
    }

    public Map<User, Set<String>> join() {
        Map<String, User> supplier = new HashMap<>();
        Map<User, Set<String>> intermediateResult = new HashMap<>();
        Map<User, Set<String>> finalResult = new HashMap<>();
        Set<String> duplicate = new HashSet<>();
        for (User user : store.getUsers()) {
            for (String mail : user.getMails()) {
                if (!supplier.containsKey(mail)) {
                    supplier.put(mail, user);
                } else {
                    User oldUser = supplier.get(mail);
                    oldUser.getMails().addAll(user.getMails());
                    duplicate.add(user.toString());
                    for (String newMail : oldUser.getMails()) {
                        supplier.put(newMail, oldUser);
                    }
                    break;
                }
            }
            if (!duplicate.contains(user.toString())) {
                intermediateResult.put(user, user.getMails());
            }
        }
        if (intermediateResult.size() == 1) {
            return intermediateResult;
        }
        final ArrayDeque<User> usersCopy = new ArrayDeque<>(intermediateResult.keySet());
        while (usersCopy.size() > 0) {
            User last = usersCopy.pollLast();
            for (User dub : intermediateResult.keySet()) {
                    Set<String> cons = new HashSet<>(dub.getMails());
                    if (!dub.equals(last) && cons.removeAll(last.getMails())) {
                        dub.getMails().addAll(last.getMails());
                        duplicate.add(last.toString());
                    }
                if (!duplicate.contains(dub.toString())) {
                    finalResult.put(dub, dub.getMails());
                }
            }
        }
        return finalResult;
    }
}
