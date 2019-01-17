package pl.zebek.kata;

import org.junit.Test;

import static org.junit.Assert.*;

public class DnaToRanTest {
    @Test
    public void testDna() throws Exception {
        DnaToRan b = new DnaToRan();
        assertEquals("UUUU", b.dnaToRna("TTTT"));
    }

    @Test
    public void testDna2() throws Exception {
        DnaToRan b = new DnaToRan();
        assertEquals("GCAU", b.dnaToRna("GCAT"));
    }
}