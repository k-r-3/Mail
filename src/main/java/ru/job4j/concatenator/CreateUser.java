package ru.job4j.concatenator;

import java.util.HashSet;

public class CreateUser implements Actions, Create {
    private  HashSet<RealUser> users = new HashSet<RealUser>();

    @Override
    public boolean operation(UserInput in) {
        RealUser user;
        String name = "";
        String eMail = "";
            name = in.askString("Username : ");
            if (checkName(name)) {
                user = new RealUser(name);
                eMail = in.askString("Input user e-mail(s) with ',' : ");
                if (checkEmail(eMail)) {
                    user.setMails(eMail);
                    users.add(user);
                } else {
                    System.out.println("wrong e-mail");
                    return true;
                }
            } else {
                System.out.println("username can not contains '@'");
                return true;
            }
        return true;
    }

    public HashSet<RealUser> getUsers() {
        return users;
    }

    @Override
    public String operation(String[] in) {
        throw new UnsupportedOperationException("this operation unsupported");
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
    public String name() {
        return "0. CreateUser";
    }
}
