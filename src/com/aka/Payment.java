package com.aka;

import java.util.List;

enum Payment {
    //Advanced enum
    CASH,
    DEBIT_CARD,
    CREDIT_CARD;
    private static double inputAmount;

//    public Payment(List<Item> items, List<Menu> menus) {
//        super(items, menus);
//    }


    // Add methods
    // TODO: check to see amount presented; if insufficient, prompt for additional payment
    static boolean verifyBalance(List<Item> items) {
        // debit, credit input,
        //cash - it meets the requirement if cash inputted is more than the price of the item
        for(Item item: items) {
            if(inputAmount>= item.getPrice()) {
                //makeChange();
                return true;
            }
        }

       return false;
    }
/*
    // TODO: compare payment amount to total cost and return the difference - VENDING MACHINE CLASS?
    static double makeChange() {

        double totalCost = 10;
    return inputAmount - totalCost;
    }

 */

    public static void setInputAmount(double inputAmountIn) {
        inputAmount = inputAmountIn;
    }
}