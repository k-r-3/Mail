package ru.job4j.concatenator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;

public class RealUser implements User{
    private HashSet<String> mails;
    String name;

    public RealUser(String name) {
        this.name = name;
    }

    public RealUser() { }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RealUser realUser = (RealUser) o;
        return Objects.equals(mails, realUser.mails) &&
                Objects.equals(name, realUser.name);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + mails.hashCode();
        return result;
    }
}
