package com.aka;


import java.util.List;

class Menu extends VendingMachine {
    private String categoryId;

    protected Menu(String categoryId, String category) {
        this.categoryId = categoryId;
        this.category = category;
    }

    protected Menu(String category) {
        this.category = category;
    }

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
    protected String showItemMenu(String input, List<Item> items) {
        int i = 0;
        String msg = "";
        for(Item item: items) {
            if (input.equals(item.getCategory()) && item.isInStock() && !item.isCurrentlySelected()) {
                i++;
                msg += item.getItemId() + " - " + item.getName() + " for $" + item.getPrice() + "\n";
            }
        }
        if (i == 0) {
            msg = "Sorry, currently out of stock";
        }
        return msg;
    }

    // Method for future release involving multiple payment methods (Cash, CC, ETC)
    protected void showPaymentMenu(double cost) {
        System.out.println("Please deposit money." + cost);
    }

    protected String showItemRetrievable(List<Item> items) {
        String msg = "The amount dispensed is " + Payment.getChange() + "\n";
        for(Item item: items) {
            if (item.isRetrievable()){
                msg += (item.getName() + " is ready for pickup." + "\n");
            }
        }
        return msg;
    }

    protected String showClosingScreen() {
        return "Thank you, have a nice day.";
    }

    protected String getCategoryId() {
        return categoryId;
    }
}