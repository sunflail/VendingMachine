package com.aka;


class Menu {
    private String category;

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

    public static void showMenu(Menu menuIn) {
        // TODO: 11/5/2020 Used to show any menu needed to the customer, including items, categories, total requested
        //  payment, balance owed/due, an item dispensed message, a thank you message, asking for anything else
        // Create menu and display (using prompter to console/scanner)
        System.out.println(menuIn.getCategory());

    }

    public static void showStartMenu() {
        System.out.println("Welcome to the Vending Machine.");
        System.out.println("Please select from the following categories:\n");

    }

    public static void showCategoryMenu(Menu menuIn) {
        System.out.println(menuIn.getCategory());

    }

    public static void showItemMenu(String input, Item item) {
        if (input.equals(item.getCategory())) {
            System.out.println("Available " + item.getCategory() + " are " + item.getName() + " for $" + item.getPrice());
        }
    }

    public static void showPaymentMenu(double cost) {
        System.out.println("Please deposit money." + cost);
    }

    public static void showItemRetrievable(Item item) {
        if (item.isRetrievable()){
            System.out.println(item.getName() + " is ready for pickup.");
        }
        else {
            System.out.println(item.getName() + " is not ready, there was a problem.");
        }
    }

    public static void showAnythingElse() {
        System.out.println("Would you like to purchase another item?");
    }

    public static void showClosingScreen() {
        System.out.println("Thank you, have a nice day.");
        // insert code to exit
        System.exit(0);
    }

    // Accessors

    public String getCategory() {
        return category;
    }
}