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
    public String createItemMenu(Item item) { // maybe change this to create sub menu
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

    public String getCategory() {
        return category;
    }
}