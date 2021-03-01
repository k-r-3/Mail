package ru.job4j.concatenator;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class CreateUserTest {

    @Test
    public void whenWrongName() {
        String[] in = {"qwerty@", "qwerty@"};
        CreateStubUser csUser = new CreateStubUser();
        String expected = "username can not contains '@'";
        assertThat(csUser.operation(in), is (expected));
    }

    @Test
    public void whenWrongEmail() {
        String[] in = {"qwerty", "qwerty.ru"};
        CreateStubUser csUser = new CreateStubUser();
        String expected = "wrong e-mail";
        assertThat(csUser.operation(in), is (expected));
    }

    @Test
    public void whenAllCorrect() {
        String[] in = {"qwerty", "qwerty@yandex.ru"};
        CreateStubUser csUser = new CreateStubUser();
        csUser.operation(in);
        assertFalse(csUser.getUsers().isEmpty());
    }

}