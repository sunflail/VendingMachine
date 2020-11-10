package com.aka;

import java.util.List;

enum Payment {
    //Advanced enum
    CASH,
    DEBIT_CARD,
    CREDIT_CARD;
    private static double inputAmount;
    private static double totalInput;
    private static double totalCost;
    private static double change;

//    public Payment(List<Item> items, List<Menu> menus) {
//        super(items, menus);
//    }


    // Add methods
    // TODO: check to see amount presented; if insufficient, prompt for additional payment
    static boolean verifyBalance() {
        // debit, credit input,
        //cash - it meets the requirement if cash inputted is more than the price of the item
        if(inputAmount>=totalCost) {
            makeChange();
            return true;
        }
        else {
            totalInput += inputAmount;
            setTotalCost(totalCost - totalInput);
            System.out.println("Insufficient funds! Please deposit " + totalCost );

            return false;
        }
    }

    public static double getChange() {
        return change;
    }

    //TODO: compare payment amount to total cost and return the difference - VENDING MACHINE CLASS?
    static double makeChange() {

        //double totalCost = 10;

        change = inputAmount - totalCost;
    //return inputAmount - totalCost;
       // System.out.println("The change dispensed is " + change);

        return change;
    }



    public static void setInputAmount(double inputAmountIn) {
        inputAmount = inputAmountIn;
    }

    public static void setTotalCost(double totalCostIn) {
        totalCost = totalCostIn;
    }

    public static double getTotalCost() {
        return totalCost;
    }
}