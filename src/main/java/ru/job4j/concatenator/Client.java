package ru.job4j.concatenator;
import java.util.Scanner;

public class Client {

    public void run() {
        UserStore store = new UserStore();
        Concatenator joiner = new Concatenator(store);
        Scanner sc = new Scanner(System.in);
        String action = "";
        do {
            System.out.println("Choice menu item : ");
            System.out.println("1. create user");
            System.out.println("2. concatenate user emails");
            System.out.println("0. exit");
            action = sc.nextLine();
            if (action.equals("1")) {
                store.add();
            } else if (action.equals("2")) {
                System.out.println(joiner.join());
            }

        } while (!action.equals("0"));
    }

    public static void main(String[] args) {
        new Client().run();
    }
}
