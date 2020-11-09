package com.aka;

import java.util.List;

class Customer {
    // Variables
    private String result = "Not found.";
    private Item foundItem;
    private Enum funds; // may or may not be an Enum

    // Business methods
    public String makeCategorySelection(String input, List<Menu> menus) {// might be better as makeSelection()
        //TODO: Customer calls items to see list of items to choose from - categoryOfItems
        for (Menu menu : menus) {
            if(input.equalsIgnoreCase(menu.getCategoryId()) || input.equalsIgnoreCase(menu.getCategory())) {
            //if (input.equals(menu.getCategoryId())) {
                result = menu.getCategory();
            }
        }
        return result;
    }

    public Item makeItemSelection(String input, List<Item> items) {
        for(Item item: items) {
            if(input.equalsIgnoreCase(item.getItemId().trim())||input.equalsIgnoreCase(item.getName().trim())) {
            // if (input.equals(item.getItemId())){
                foundItem = item;
            }
        }
        System.out.println("You choose " + foundItem.getItemId() + " - " + foundItem.getName() + ".");
        return foundItem;
    }

    public boolean makeAnotherChoice(String input) {
        if (input.equalsIgnoreCase("No")){
            return false;
        }
        return true;
    }

    public double makePayment(String input) {
    //TODO: Customer calls Enum Payment to select what form of payment is being used to make payment for items
        double payment = Double.parseDouble(input);
        //System.out.println("Console input from customer equals the amount requested of " + payment);
        Payment.setInputAmount(payment);
        return payment;
    }
    public void retrieveItem(List<Item> items) {
    //TODO: Customer picks up item which changes availability of item
        for(Item item: items) {
            if(item.isRetrievable()){
                item.setInStock(false);
                item.setRetrievable(false);
            }

        }
    }

    public String consoleInput(String input) {
        System.out.println("simulated user input of " + input + " from console");
        // this needs to take the users input and pass as the String input to the menu display based on the current category
        // if current menu is category -> user response calls showItemMenu (user input, result from makeCategorySelection)
        // if current menu is available items -> user response calls showPaymentMenu( user input, result from makeItemSelection)
        return input;
    }

}