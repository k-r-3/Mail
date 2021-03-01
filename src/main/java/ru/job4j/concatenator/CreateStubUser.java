package ru.job4j.concatenator;

import java.util.HashSet;
import java.util.Set;

public class CreateStubUser implements Create {
    private HashSet<StubUser> stubUsers = new HashSet<StubUser>();

    public String operation(String[] in) {
        String name = in[0];
        String eMail = in[1];
        StubUser user;
        if (checkName(name)) {
            user = new StubUser(name);
            if (checkEmail(eMail)) {
                user.setMails(eMail);
                stubUsers.add(user);
            } else {
                return "wrong e-mail";
            }
        } else {
            return "username can not contains '@'";
        }
        return "";
    }

    public void setStubUsers(HashSet<StubUser> set) {
        stubUsers = set;
    }

    @Override
    public boolean checkName(String name) {
        return !name.matches(".*@.*");
    }

    @Override
    public boolean checkEmail(String email) {
        return email.matches("(\\w*@\\w*\\W\\w*.?)*");
    }

    @Override
    public HashSet<StubUser> getUsers() {
        return stubUsers;
    }

}
