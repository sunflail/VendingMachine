package com.aka;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MenuTest {
    private Item item1;
    private Item item2;
    private Menu menu1;

    @Before
    public void setUp() {
        item1 = new Item("XYZ", "Drinks", 2.99, true);
        item2 = new Item("Tuna", "Sandwich", 1.50, true);
        menu1 = new Menu("Drinks");
    }

    @Test
    public void menu_shouldCreateAMenu() {
        assertEquals("Drinks", menu1.getCategory());
    }

    @Test
    public void createMenu_shouldCreateASpecificMenu_whenPassedAnInput() {
        assertEquals("XYZ", menu1.createItemMenu(item1));
        assertNotEquals("Tuna", menu1.createItemMenu(item2));
    }
}