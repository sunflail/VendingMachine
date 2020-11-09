package com.aka;

import java.util.List;

class Customer {
    // Variables
    private String result = "Not found.";
    private Item foundItem;

    // Business methods
    public String makeCategorySelection(String input, List<Menu> menus) {// might be better as makeSelection()
        //TODO: Customer calls items to see list of items to choose from - categoryOfItems
        for (Menu menu : menus) {
            if(input.equalsIgnoreCase(menu.getCategoryId()) || input.equalsIgnoreCase(menu.getCategory())) {
                result = menu.getCategory();
            }
        }
        return result;
    }

    public Item makeItemSelection(String input, List<Item> items) {
        for(Item item: items) {
            if(input.equalsIgnoreCase(item.getItemId().trim())||input.equalsIgnoreCase(item.getName().trim())) {
                foundItem = item;
            }
        }
        System.out.println("You choose " + foundItem.getItemId() + " - " + foundItem.getName() + ".");
        return foundItem;
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
    public void retrieveItem(List<Item> items) {
    //DONE: Customer picks up item which changes availability of item
        for(Item item: items) {
            if(item.isRetrievable()){
                item.setInStock(false);
                item.setRetrievable(false);
            }

        }
    }
}