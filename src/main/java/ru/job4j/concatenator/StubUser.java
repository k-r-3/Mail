package ru.job4j.concatenator;

import java.util.Arrays;
import java.util.HashSet;

public class StubUser implements User{
    private HashSet<String> mails;
    String name;

    public StubUser(String name) {
        this.name = name;
    }

    public StubUser() { }

    public HashSet<String> getMails() {
        return mails;
    }

    public void setMails(String eMail) {
        mails = new HashSet<>(Arrays.asList(eMail.split(",")));
    }

    @Override
    public String toString() {
        return name;
    }

}
