package com.aka;

import java.util.ArrayList;
import java.util.List;

class VendingMachine {
    private List<Item> items;
    private List<Menu> categories;
    protected String category;
    private Item selectedItem;
    private double totalCost;

    List<Item> cart = new ArrayList<>();

    // Constructors
    protected VendingMachine() {

    }

    // Business methods
    protected String findItem(String input, List<Item> items1) {
        String msg = "";
        for(Item item: items1) {
            if(input.equalsIgnoreCase(item.getItemId().trim())||input.equalsIgnoreCase(item.getName().trim())) {
                msg = addToCart(item);
            }
        }
        return msg;
    }

    private String addToCart(Item item) {
        String msg;
        if (item.isInStock() && !cart.contains(item)){
            this.selectedItem = item;
            cart.add(selectedItem);
            item.setCurrentlySelected(true);
            msg = "You chose " + selectedItem.getItemId() + " - " + selectedItem.getName() + ".";
        }
        else {
            msg = ("This item, " + item.getName() + " is out of stock.");
        }
        return msg;
    }

    protected double calculateTotal() {
        totalCost = 0.0; // need to reinitialize totalCost on every call - will need to move during iteration
        for(Item item: cart) {
            totalCost += item.getPrice();
        }
        Payment.setTotalCost(totalCost);
        return totalCost;
    }

    protected boolean dispenseSomething(boolean payment) {
        boolean dispensed = false;
        if (totalCost != 0.0 && payment) {
            for (Item item : cart) {
                item.setRetrievable(true);
            }
            dispensed = true;
        }
        else {
            // TODO - throw exception on nothing purchased/ready to retrieve
        }
        return dispensed;
    }

    public void retrieveItem(List<Item> items) {
        for(Item item: items) {
            if(item.isRetrievable()){
                item.setInStock(false);
                item.setRetrievable(false);
            }
        }
    }

    protected void cartClear() {
        cart.clear();
    }

    public List<Item> getCart() {
        return cart;
    }

    protected List<Item> getItems() {
        return items;
    }

    public String getCategory() {
        return category;
    }

    protected List<Menu> getCategories() {
        return categories;
    }

    //TODO: Populate list with an external file
    protected void setCategories() {
        categories = new ArrayList<>();
        categories.add(new Menu("A", "Drinks"));
        categories.add(new Menu("B", "Sandwich"));
        categories.add(new Menu("C", "Snacks"));
    }

    protected void setItems() {
        items = new ArrayList<>();
        items.add(new Item("1", "Coke", "Drinks", 1.00, true));
        items.add(new Item("2", "Red Bull", "Drinks", 1.00, true));
        items.add(new Item("3", "Sprite", "Drinks", 1.00, true));
        items.add(new Item("4", "Fanta", "Drinks", 1.00, true));

        items.add(new Item("5", "Tuna", "Sandwich", 2.99, true));
        items.add(new Item("6", "Chicken", "Sandwich", 2.99, true));
        items.add(new Item("7", "Club", "Sandwich", 2.99, true));
        items.add(new Item("8", "Veggie", "Sandwich", 2.99, true));

        items.add(new Item("9", "Lays", "Snacks", 1.99, true));
        items.add(new Item("10", "Snickers", "Snacks", 1.99, true));
        items.add(new Item("11", "Sun Chips", "Snacks", 1.99, true));
        items.add(new Item("12", "Kit Kat", "Snacks", 1.99, true));
        items.add(new Item("13", "Cheetos", "Snacks", 1.99, true));
    }
}