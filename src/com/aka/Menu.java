package com.aka;


import java.util.List;

class Menu {
    private String category;
    private String categoryId;

    public Menu(String categoryId, String category) {
        this.categoryId = categoryId;
        this.category = category;
    }

    public Menu(String category) {
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
    String createItemMenu(Item item) { // maybe change this to create sub menu
        String itemStatement = "";
        if (item.getCategory().equals(category)) {
            System.out.println(item.getName());
            itemStatement = item.getCategory();
        }
        else {
            this.category = item.getCategory();
            createItemMenu(item);
        }
        return itemStatement; // currently this returns the NAME of the passed ITEM matching the CATEGORY
    }

    public static String showStartMenu() {
        return "Welcome to the Vending Machine.\nPlease select from the following categories:\n";
    }

    public static void showCategoryMenu(List<Menu> menuIn) {
        for (Menu menu : menuIn) {
            System.out.println(menu.getCategoryId() + " - " + menu.getCategory());
        }
    }

    //(String input items)
    // TODO: 11/9/2020 Add logic to return 'all out of stock' if items collection is empty
    public static void showItemMenu(String input, List<Item> items) {
        int i = 0;
        System.out.println(input);
        for(Item item: items) {
            if (input.equals(item.getCategory()) & item.isInStock()) {
                i++;
                System.out.println(item.getItemId() + " - " + item.getName() + " for $" + item.getPrice());
            }
        }
        if (i == 0) {
            System.out.println("Sorry, currently out of stock");
        }
    }

    public static void showPaymentMenu(double cost) {
        System.out.println("Please deposit money." + cost);
    }

    public static void showItemRetrievable(List<Item> items) {
        for(Item item: items) {
            if (item.isRetrievable()){
                System.out.println(item.getName() + " is ready for pickup.");
            }
//            else {
//                System.out.println(item.getName() + " is not ready, there was a problem.");
//            }
        }
    }

    public static void showAnythingElse() {
        System.out.println("Would you like to purchase another item?");
    }

    public static void showClosingScreen() {
        System.out.println("Thank you, have a nice day.");
        // insert code to exit
    }

    // Accessors

    public String getCategory() {
        return category;
    }

    public String getCategoryId() {
        return categoryId;
    }
}