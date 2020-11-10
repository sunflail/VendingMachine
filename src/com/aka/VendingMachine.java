package com.aka;

import java.util.ArrayList;
import java.util.List;

class VendingMachine {
    private List<Item> items;
    private List<Menu> categories;
    protected String category;
    private double customerPayment;
    private Item selectedItem;
    private double totalCost;

    public List<Item> getCart() {
        return cart;
    }

    List<Item> cart = new ArrayList<>();

    // Constructors
    protected VendingMachine() {

    }

    protected void setCategories() {
        categories = new ArrayList<>();
        categories.add(new Menu("A", "Drinks"));
        categories.add(new Menu("B", "Sandwich"));
        categories.add(new Menu("C", "Snacks"));
    }

    protected void setItems() {
        items = new ArrayList<>();
        //TODO: Need to come back to this and make a Collection of each Category or make method return Sub-collection
        items.add(new Item("1", "Coke", "Drinks", 1.00, false));
        items.add(new Item("2", "Red Bull", "Drinks", 1.00, true));
        items.add(new Item("3", "Sprite", "Drinks", 1.00, true));
        items.add(new Item("4", "Fanta", "Drinks", 1.00, true));

        items.add(new Item("5", "Tuna", "Sandwich", 2.99, true));
        items.add(new Item("6", "Chicken", "Sandwich", 2.99, true));
        items.add(new Item("7", "Club ", "Sandwich", 2.99, true));
        items.add(new Item("8", "Veggie", "Sandwich", 2.99, true));

        items.add(new Item("9", "Lays", "Snacks", 1.99, true));
        items.add(new Item("10", "Snickers", "Snacks", 1.99, true));
        items.add(new Item("11", "Sun Chips", "Snacks", 1.99, false));
        items.add(new Item("12", "Kit Kat", "Snacks", 1.99, true));
        items.add(new Item("13", "Sun Chips", "Snacks", 1.99, false));
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

    // Business methods
    // maybe replace with a getter for payment?
    protected double takePayment() {
        // TODO: 11/5/2020 Will take payment object from customer and store in local variable for VendingMachine
        customerPayment = 10.0; // hardcoded temporary value to be replaced by customer object
        return customerPayment;
    }

    // almost a setter
    protected String findItem(Item item) {
        // TODO: 11/5/2020 Checks for an item based on its category and name, and also based on the menu choice  
        //  from the Customer - may need a comparator or an equals method defined
//
        String msg = "";
        if (item.isInStock()){
            this.selectedItem = item;
            cart.add(selectedItem);
        }
        else {
            msg = ("This item, " + item.getName() + " is out of stock.");
        }
        return msg;
    }
//   THIS METHOD IS FROM CUSTOMER AND SHOULD BE ABLE TO BE COLLAPSED INTO findItem()i
//    public Item makeItemSelection(String input, List<Item> items) {
//        for(Item item: items) {
//            if(input.equalsIgnoreCase(item.getItemId().trim())||input.equalsIgnoreCase(item.getName().trim())) {
//                foundItem = item;
//            }
//        }
//        System.out.println("You choose " + foundItem.getItemId() + " - " + foundItem.getName() + ".");
//        return foundItem;
//    }

    protected double calculateTotal() { // will need to throw a nullpointerexception if selectedItem is not set
        totalCost = 0.0; // need to reinitialize totalCost on every call - will need to move during iteration
        // TODO: 11/5/2020 Takes number of items and their prices and finds the total
        for(Item item: cart) {
            totalCost += item.getPrice();
        }
        Payment.setTotalCost(totalCost);
        return totalCost;
    }

    protected boolean dispenseSomething(boolean payment) {
        // TODO: 11/5/2020 Checks item availability field and delivers item to customer.
        //  - Item availability is checked when calculating total, check for if totalCost == 0.0, then no item to dispense
        //  Also used to check if change is needed, in case of a cash payment, from Payment (calls makeChange()) - medium goal
        boolean dispensed = false;
        if (totalCost != 0.0 & payment) {
            for (Item item : cart) {
                //give the item to customer - store the item in a variable for retrieval by customer
                selectedItem.setRetrievable(true);
            }
            dispensed = true;
        }
        else {
            // TODO - throw exception on nothing purchased/ready to retrieve
        }
        return dispensed;
    }

    public Item getSelectedItem() {
        return selectedItem;
    }

    protected void cartClear() {
        cart.clear();
    }
}