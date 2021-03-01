package ru.job4j.concatenator;

import java.util.List;

public class Client {

    public void menu(List<Actions> act, UserInput in) {
        boolean answer = true;
        int choice = -1;
        while (answer) {
            showMenu(act);
            try {
                choice = Integer.parseInt(in.askString("choice operation : "));
                answer = act.get(choice).operation(in);
            } catch (NumberFormatException e) {
                System.out.println("wrong menu item");
            }
        }
    }

    private void showMenu(List<Actions> choice) {
        for (Actions a : choice) {
            System.out.println(a.name());
        }
    }

    public static void main(String[] args) {
        Client c = new Client();
        var user = new CreateUser();
        c.menu(List.of(user, new Concatenator(user), new Exit()), new UserInput());
    }
}
