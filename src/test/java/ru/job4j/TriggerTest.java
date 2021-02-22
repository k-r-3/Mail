package ru.job4j;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class TriggerTest {

    @Test
    public void whenTrigger() {
        Trigger trigger = new Trigger();
        assertThat(trigger.check(), is("Trigger"));
    }

}