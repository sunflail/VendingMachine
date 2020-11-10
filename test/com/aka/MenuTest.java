package com.aka;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MenuTest {
    private Item item1;
    private Item item2;
    private Menu menu1;
    private Menu menu2;

    @Before
    public void setUp() {
        item1 = new Item("1", "XYZ", "Drinks", 2.99, true);
        item2 = new Item("1", "Tuna", "Sandwich", 1.50, true);
        menu1 = new Menu("A", "Drinks");
    }

    @Test
    public void menu_shouldCreateAMenu() {
        assertEquals("Drinks", menu1.getCategory());
    }

//    @Test
//    public void createMenu_shouldCreateASpecificMenu_whenPassedAnInput() {
//        menu1.createItemMenu(item1);
//        assertEquals("Drinks", menu1.getCategory());
//        System.out.println("This is printing: " + menu1.createItemMenu(item2));
//        System.out.println(menu1.getCategory());
//        assertEquals("Sandwich", menu1.getCategory());
//    }
}