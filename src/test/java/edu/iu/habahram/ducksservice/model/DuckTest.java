package edu.iu.habahram.ducksservice.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DuckTest {

    @Test
    void toLine() {
        DuckData duck = new DuckData(1, DuckType.MALLARD.toString());
        String line = duck.toLine();
        String expected = "1,Mallard";
        assertEquals(expected, line);
    }

    @Test
    void fromLine() {
        String line = "1,Mallard";
        DuckData expected = new DuckData(1, DuckType.MALLARD.toString());
        DuckData duck = DuckData.fromLine(line);
        assertEquals(expected.id(), duck.id());
        assertEquals(expected.type(), duck.type());
    }
}