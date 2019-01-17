package pl.zebek.kata;

import org.junit.Test;

import static org.junit.Assert.*;
import static pl.zebek.kata.CountSheep.countingSheep;

public class CountSheepTest {

    @Test
    public void shouldPrepareValidString(){
        assertEquals("1 sheep...", countingSheep(1));
        assertEquals("1 sheep...2 sheep...", countingSheep(2));
    }

}