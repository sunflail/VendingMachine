package com.aka;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class VendingMachineTest {
    private Item item1;
    private Item item2;
    private Menu menu1;
    private Menu menu2;
    private VendingMachine vm1;
    private VendingMachine vm2;

    @Before
    public void setUp() {
        item1 = new Item("XYZ", "Drinks", 2.99, true);
        item2 = new Item("Tuna", "Sandwich", 1.50, true);
        menu1 = new Menu("Drinks");

        vm1 = new VendingMachine();
        vm2 = new VendingMachine();

    }

    @Test
    public void takePayment_shouldStorePaymentMethod() {
        assertEquals(10.0, vm1.takePayment(), .01);
    }

    @Test
    public void findItem_shouldReturnCorrectItem_byNameAndCategory() {
    }

    @Test
    public void calculateTotal() {
        vm1.findItem(item1);
        vm2.findItem(item2);
        assertEquals(2.99, vm1.calculateTotal(), .01);
        assertEquals(1.50, vm2.calculateTotal(), .01);
        assertEquals(4.49, vm1.calculateTotal() + vm2.calculateTotal(), .001);
    }

    @Test(expected = NullPointerException.class)
    public void dispenseSomething_shouldThrowExceptionIfAvailableFalse() { // will need to change to catch exception once we add it
        vm1.calculateTotal();
        //assertFalse(vm1.dispenseSomething());
    }

    @Test
    public void dispenseSomething_shouldReturnItemReady() {
        vm1.findItem(item1);
        vm1.calculateTotal();
        //assertTrue(vm1.dispenseSomething());
    }

    @Test
    public void showItemMenu() {
        menu1.createItemMenu(item1);
        //vm1.showMenu(menu1);
        //menu2 = new Menu();
        menu1.createItemMenu(item2);
        System.out.println(menu1.getCategory());
        //vm1.showMenu(menu1);
    }

    @Test
    public void showCategoryMenu() {
        menu1 = new Menu("Categories");
        //vm1.showMenu(menu1);
    }

    @Test
    public void showRequestedPaymentMenu() {
    }

    @Test
    public void showSufficientPaymentMenu() {
    }

    @Test
    public void showInsufficientPaymentMenu() {
    }

    @Test
    public void showItemDispensedMenu() {
    }

    @Test
    public void showThankYouMenu() {
    }

    @Test
    public void requestOfCustomer() {
    }
}