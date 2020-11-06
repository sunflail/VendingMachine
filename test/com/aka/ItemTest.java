package com.aka;

import org.junit.Test;

import static org.junit.Assert.*;

public class ItemTest {

    @Test
    public void testConstructor() {
        Item item1 = new Item("XYZ", "Drinks", 2.99, true);

        assertEquals("XYZ", item1.getName());
        assertEquals("Drinks", item1.getCategory());
        assertEquals(2.99, item1.getPrice(), 0.01);
        assertTrue(item1.isInStock());

    }

    @Test
    public void checkAvailability() {
    }

    @Test
    public void updateAvailability() {
    }
}