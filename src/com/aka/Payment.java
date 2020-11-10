package com.aka;

import java.util.List;

enum Payment {
    //Advanced enum
    CASH,
    DEBIT_CARD,
    CREDIT_CARD;
    private static double inputAmount;
    private static double totalCost;


    // Add methods
    // TODO: check to see amount presented; if insufficient, prompt for additional payment
    static boolean verifyBalance(List<Item> items) {
        // debit, credit input,
        //cash - it meets the requirement if cash inputted is more than the price of the item
        double amount=0.0;
        for(Item item: items) {

            amount+=item.getPrice();
//            if(inputAmount>= item.getPrice()) {
//                //makeChange();
//             return true;
//            }
//            else {
//              item.setRetrievable(false);
//                System.out.println("itemRetrievable" + item.isRetrievable());
//            }
        }
        if(inputAmount>=amount) {
            makeChange();
            return true;
        }
        else {
            System.out.println("Insufficient funds! Please deposit " + (totalCost - inputAmount) );

            return false;
        }
    }

    //TODO: compare payment amount to total cost and return the difference - VENDING MACHINE CLASS?
    static double makeChange() {

        //double totalCost = 10;

        double change = inputAmount - totalCost;
    //return inputAmount - totalCost;
        System.out.println("The change dispensed is " + change);

        return change;
    }



    public static void setInputAmount(double inputAmountIn) {
        inputAmount = inputAmountIn;
    }

    public static void setTotalCost(double totalCostIn) {
        totalCost = totalCostIn;
    }
}