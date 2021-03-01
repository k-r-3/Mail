package ru.job4j.concatenator;

import java.util.Scanner;

public class UserInput{
    Scanner sc = new Scanner(System.in);

    public String askString(String select) {
        System.out.println(select);
        return sc.nextLine();
    }

    public int askInt(String item) {
        return sc.nextInt();
    }
}
