package com.aka;

enum Payment {
    //Advanced enum
    CASH,
    DEBIT_CARD,
    CREDIT_CARD;
    private static double inputAmount;
    private static double totalCost;
    private static double change;

    // Business methods
    static boolean verifyBalance() {
        // debit, credit input,
        //cash - it meets the requirement if cash inputted is more than the price of the item
        if(inputAmount>=totalCost) {
            makeChange();
            return true;
        }
        else {
            setTotalCost(totalCost - inputAmount);
            // TODO: Remove this system out to something for controller to output to view
            System.out.println("Insufficient funds! Please deposit " + totalCost );
            return false;
        }
    }

    public static double getChange() {
        return change;
    }

    static double makeChange() {
        change = inputAmount - totalCost;
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