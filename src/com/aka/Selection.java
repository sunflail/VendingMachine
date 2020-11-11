package com.aka;

import java.util.List;

class Selection {
    // Variables
    private String result = "Not found.";

    public String makeCategorySelection(String input, List<Menu> menus) {
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
        double payment = Double.parseDouble(input);
        Payment.setInputAmount(payment);
        return payment;
    }
}