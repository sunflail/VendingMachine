package com.aka;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PaymentTest {
    private Item item1;
    private Item item2;


    @Before
    public void setUp() {
        item1 = new Item("1", "XYZ", "Drinks", 2.99, true);
        item2 = new Item("1", "Tuna", "Sandwich", 1.50, true);
    }

    @Test
    public void verifyifBalanceisEqual() {
        Payment.setInputAmount(item1.getPrice());
        assertEquals(true, Payment.verifyBalance(item1));
    }

    @Test
    public void verifyifBalanceisLessthanPriceOfItem() {
        Payment.setInputAmount(1.00);
        assertFalse(Payment.verifyBalance(item2));


    }
    @Test
    public void verifyifBalanceisGreaterthanPriceOfItem() {
        Payment.setInputAmount(3.50);
        assertTrue(Payment.verifyBalance(item1));

    }
/*
    @Test
    public void testMakeChange() {
        Payment.setInputAmount(4.00);
        assertEquals(-6.00,Payment.makeChange(),0.001);
        assertEquals(-7.01,Payment.verifyBalance(item1));
    }

 */
}