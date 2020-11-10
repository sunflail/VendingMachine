package com.aka;


import java.util.List;

class Menu extends VendingMachine {
    //private String category;
    private String categoryId;

    protected Menu(String categoryId, String category) {
        this.categoryId = categoryId;
        this.category = category;
    }

    protected Menu(String category) {
        this.category = category;
    }


    /*TODO:
     Maybe we can have category and categoryItems as Collection of String holding values like
    "Sandwiches", "Drinks", "Chocolates" etc for category and "Coke", "Red Bull", "Hersheys", "Twix" etc for
    categoryItems
     */
    /*
     * Conditional checks against the instantiated category from the constructor, and if it's not eual then it doesn't change it.
     * This means that createItemMenu cannot change the category and thereby create a sub menu - it returns the item name if
     * and only if the category already matches. That's a problem :)
     */
//    String createItemMenu(Item item) { // maybe change this to create sub menu
//        String itemStatement = "";
//        if (item.getCategory().equals(category)) {
//            System.out.println(item.getName());
//            itemStatement = item.getCategory();
//        }
//        else {
//            this.category = item.getCategory();
//            createItemMenu(item);
//        }
//        return itemStatement; // currently this returns the NAME of the passed ITEM matching the CATEGORY
//    }

    protected String showStartMenu() {
        return "Welcome to the Vending Machine.\nPlease select from the following categories:\n";
    }

    protected String showCategoryMenu(List<Menu> menuIn) {
        String msg = "";
        for (Menu menu : menuIn) {
            msg += (menu.getCategoryId() + " - " + menu.getCategory() + "\n");
        }
        return msg;
    }

    //(String input items)
    // TODO: 11/9/2020 Add logic to return 'all out of stock' if items collection is empty
    protected void showItemMenu(String input, List<Item> items) {
        int i = 0;
        System.out.println(input);
        for(Item item: items) {
            if (input.equals(item.category) & item.isInStock()) {
                i++;
                System.out.println(item.getItemId() + " - " + item.getName() + " for $" + item.getPrice());
            }
        }
        if (i == 0) {
            System.out.println("Sorry, currently out of stock");
        }
    }

    protected void showPaymentMenu(double cost) {
        System.out.println("Please deposit money." + cost);
    }

    protected String showItemRetrievable(List<Item> items) {
        String msg = "";
        for(Item item: items) {
            if (item.isRetrievable()){
                msg = (item.getName() + " is ready for pickup.");
            }
        }
        return msg;
    }

    protected void showAnythingElse() {
        System.out.println("Would you like to purchase another item?");
    }

    protected String showClosingScreen() {
        return "Thank you, have a nice day.";
        // insert code to exit
    }

    // Accessors

//    protected String getCategory() {
//        return category;
//    }

    protected String getCategoryId() {
        return categoryId;
    }
}