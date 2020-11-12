package com.aka;

enum Payment {
    //Advanced enum
    CASH,
    DEBIT_CARD,
    CREDIT_CARD;
    private static double inputAmount;
    private static double totalCost;
    private static double change;
    private static String insufficientMsg;

    // Business methods
    public static boolean verifyBalance() {
        // debit, credit input,
        //cash - it meets the requirement if cash inputted is more than the price of the item
        if(getInputAmount()>=getTotalCost()) {
            makeChange();
            return true;
        }
        else {
            setTotalCost(getTotalCost() - getInputAmount());
            // TODO: Remove this system out to something for controller to output to view
            insufficientMsg = "Insufficient funds! Please deposit " + getTotalCost();
            return false;
        }
    }

    public static String getInsufficientMsg() {
        return insufficientMsg;
    }

    public static double getChange() {
        return change;
    }

    public static double makeChange() {
        change = Math.round((getInputAmount() - getTotalCost())*100d)/100d;
        return change;
    }

    public static void setInputAmount(double inputAmountIn) {
        inputAmount = Math.round(inputAmountIn*100d)/100d;
    }

    public static double getInputAmount() { // for Unit Testing
        return inputAmount;
    }

    public static void setTotalCost(double totalCostIn) {
        totalCost = Math.round(totalCostIn*100d)/100d;
    }

    public static double getTotalCost() {
        return totalCost;
    }
}