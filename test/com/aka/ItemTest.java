package com.aka;

import org.junit.Test;

import static org.junit.Assert.*;

public class ItemTest {

    @Test
    public void testConstructor() {
        Menu menu1 = new Menu("Drinks");
        Item item1 = new Item("1", "XYZ", "Drinks", 2.99, true);

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