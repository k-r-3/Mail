package ru.job4j.concatenator;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class ConcatenatorTest {

    @Test
    public void whenTwoJoin() {
        Store store = new TestStore(Arrays.asList(new User("user1",
                        new HashSet<>(Arrays.asList("xxx@ya.ru,foo@gmail.com,lol@mail.ru"
                                .split(",")))),
                new User("user2",
                        new HashSet<>(Arrays.asList("foo@gmail.com,ups@pisem.net".split(",")))))
        );
        Concatenator concatenator = new Concatenator(store);
        Map<User, Set<String>> map = concatenator.join();
        assertEquals(1, map.size());
        assertEquals(4, map.values().stream()
                .mapToLong(Collection::size)
                .sum());
    }

    @Test
    public void whenThreeJoin() {
        Store store = new TestStore(Arrays.asList(new User("user1",
                        new HashSet<>(Arrays.asList("xxx@ya.ru,foo@gmail.com,lol@mail.ru"
                                .split(",")))),
                new User("user2",
                        new HashSet<>(Arrays.asList("foo@gmail.com,ups@pisem.net"
                                .split(",")))),
                new User("user4",
                        new HashSet<>(Arrays.asList("ups@pisem.net,aaa@bbb.ru"
                                .split(",")))))
        );
        Concatenator concatenator = new Concatenator(store);
        Map<User, Set<String>> map = concatenator.join();
        assertEquals(1, map.size());
        assertEquals(5, map.values().stream()
                .mapToLong(Collection::size)
                .sum());
    }

    @Test
    public void whenShuffle() {
        Store store = new TestStore(Arrays.asList(new User("user1",
                        new HashSet<>(Arrays.asList("xxx@ya.ru,foo@gmail.com,lol@mail.ru"
                                .split(",")))),
                new User("user4",
                        new HashSet<>(Arrays.asList("ups@pisem.net,aaa@bbb.ru"
                                .split(",")))),
                new User("user2",
                        new HashSet<>(Arrays.asList("foo@gmail.com,ups@pisem.net"
                                .split(",")))))
        );
        Concatenator concatenator = new Concatenator(store);
        Map<User, Set<String>> map = concatenator.join();
        assertEquals(1, map.size());
        assertEquals(5, map.values().stream()
                .mapToLong(Collection::size)
                .sum());
    }

    @Test
    public void whenMultiJoin() {
        Store store = new TestStore(Arrays.asList(new User("user1",
                        new HashSet<>(Arrays.asList("xxx@ya.ru,foo@gmail.com,lol@mail.ru"
                                .split(",")))),
                new User("user2",
                        new HashSet<>(Arrays.asList("foo@gmail.com,ups@pisem.net"
                                .split(",")))),
                new User("user3",
                        new HashSet<>(Arrays.asList("xyz@pisem.net,vasya@pupkin.com"
                                .split(",")))),
                new User("user4",
                        new HashSet<>(Arrays.asList("ups@pisem.net,aaa@bbb.ru"
                                .split(",")))),
                new User("user5",
                        new HashSet<>(Arrays.asList("ups@pisem.net,aaa@bbb.ru"
                                .split(",")))))
        );
        Concatenator concatenator = new Concatenator(store);
        Map<User, Set<String>> map = concatenator.join();
        assertEquals(2, map.size());
        assertEquals(7, map.values().stream()
                .mapToLong(Collection::size)
                .sum());
    }

}