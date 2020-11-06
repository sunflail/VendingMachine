package com.aka;

import java.sql.SQLOutput;

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
    public String createItemMenu(Item item) {
        String itemStatement = "";
        if (item.getCategory().equals(category)) {
            itemStatement = item.getName();
        }
        return itemStatement;
    }

    public String getCategory() {
        return category;
    }
}