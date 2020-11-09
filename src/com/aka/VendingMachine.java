package com.aka;

class VendingMachine {
    // Variables
    private double customerPayment;
    private Item selectedItem;
    private double totalCost;
    // Constructors

    // Business methods
    // maybe replace with a getter for payment?
    public double takePayment() {
        // TODO: 11/5/2020 Will take payment object from customer and store in local variable for VendingMachine
        customerPayment = 10.0; // hardcoded temporary value to be replaced by customer object
        return customerPayment;
    }

    // almost a setter
    public void findItem(Item item) {
        // TODO: 11/5/2020 Checks for an item based on its category and name, and also based on the menu choice  
        //  from the Customer - may need a comparator or an equals method defined
//        customer.input = "A1";
//        for (Item item : items) {
//            String.matches("A") then since A = Drinks, item.category = Drinks;
//            String.matches("1") then since 1 = location 1/list item 1/collection.get(0), item.name = Coke;
//        }
//        }
        if (item.isInStock()){
            this.selectedItem = item;
        }
        else {
            System.out.println("This item, " + item.getName() + " is out of stock.");
        }
    }

    public double calculateTotal() { // will need to throw a nullpointerexception if selectedItem is not set
        totalCost = 0.0; // need to reinitialize totalCost on every call - will need to move during iteration
        // TODO: 11/5/2020 Takes number of items and their prices and finds the total
        if (selectedItem.isInStock()) {
            totalCost += selectedItem.getPrice();
        }
        else {
            // TODO: 11/6/2020 Remove SOUT and replace with either exception or another method call
            System.out.println("Item is out of stock.");
        }
        return totalCost;
    }

    public boolean dispenseSomething(boolean payment) {
        // TODO: 11/5/2020 Checks item availability field and delivers item to customer.
        //  - Item availability is checked when calculating total, check for if totalCost == 0.0, then no item to dispense
        //  Also used to check if change is needed, in case of a cash payment, from Payment (calls makeChange()) - medium goal
        if (totalCost != 0.0 & payment) {
            //give the item to customer - store the item in a variable for retrieval by customer
            selectedItem.setRetrievable(true);
        }
        else {
            // TODO - throw exception on nothing purchased/ready to retrieve
        }
        return selectedItem.isRetrievable();
    }
}