package ru.job4j.concatenator;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class ConcatenatorTest {

    @Test
    public void whenPutSameUsers() {
        CreateStubUser cUser = new CreateStubUser();
        String[] in1 = {"user1", "xxx@ya.ru,foo@gmail.com,lol@mail.ru"};
        cUser.operation(in1);
        String[] in2 = {"user2", "foo@gmail.com,ups@pisem.net"};
        cUser.operation(in2);
        String[] in3 = {"user3", "xyz@pisem.net,vasya@pupkin.com"};
        cUser.operation(in3);
        String[] in4 = {"user4", "ups@pisem.net,aaa@bbb.ru"};
        cUser.operation(in4);
        String[] in5 = {"user5", "xyz@pisem.net"};
        cUser.operation(in5);
        UserInput input = new UserInput();
        Concatenator c = new Concatenator(cUser);
        c.operation(input);
        assertThat(c.getMap().size(), is(2));
    }
//
//    @Test
//    public void whenPutDifferentUsers() {
//        CreateStubUser cUser = new CreateStubUser();
//        String[] in1 = {"user1", "xxx@ya.ru,foo@gmail.com,lol@mail.ru"};
//        cUser.operation(in1);
//        String[] in2 = {"user2", "foo@gmail.com,ups@pisem.net"};
//        cUser.operation(in2);
//        String[] in3 = {"user3", "xyz@pisem.net,vasya@pupkin.com"};
//        cUser.operation(in3);
//        UserInput input = new UserInput();
//        Concatenator c = new Concatenator(cUser);
//        c.operation(input);
//        assertThat(c.getMap().size(), is(2));
//    }

    @Test
    public void whenPutAlongUser() {
        CreateStubUser cUser = new CreateStubUser();
        String[] in1 = {"user1", "xxx@ya.ru,foo@gmail.com,lol@mail.ru"};
        cUser.operation(in1);
        UserInput input = new UserInput();
        Concatenator c = new Concatenator(cUser);
        c.operation(input);
        String actual = c.getMap().entrySet()
                .iterator()
                .next()
                .getKey()
                .toString();
        assertThat(actual, is("user1"));
    }
}