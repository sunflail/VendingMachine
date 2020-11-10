package com.aka;

import java.util.List;

class Selection {
    // Variables
    private String result = "Not found.";

    public String makeCategorySelection(String input, List<Menu> menus) {// might be better as makeSelection()
        //TODO: Customer calls items to see list of items to choose from - categoryOfItems
        for (Menu menu : menus) {
            if(input.equalsIgnoreCase(menu.getCategoryId()) || input.equalsIgnoreCase(menu.getCategory())) {
                result = menu.getCategory();
            }
        }
        return result;
    }

    public boolean makeAnotherChoice(String input) {
        if (input.equalsIgnoreCase("No") || input.equalsIgnoreCase("n")){
            return false;
        }
        else if (input.equalsIgnoreCase("Yes") || input.equalsIgnoreCase("y")){
            return true;
        }
        return true;
    }

    public double makePayment(String input) {
    //TODO: Customer calls Enum Payment to select what form of payment is being used to make payment for items
        double payment = Double.parseDouble(input);
        Payment.setInputAmount(payment);
        return payment;
    }

}