package com.aka;

class VendingMachine {
    // Variables
    private String menu; // will probably be a collection

    // Constructors

    // Business methods
    public void takePayment() {
        // TODO: 11/5/2020 Will take payment object from customer and store in local variable for VendingMachine 
    }

    public void findItem() {
        // TODO: 11/5/2020 Checks for an item based on its category and name, and also based on the menu choice  
        //  from the Customer
    }
    public double calculateTotal() {
        // TODO: 11/5/2020 Takes number of items and their prices and finds the total 
        return 0.0;
    }
    public void dispenseSomething() {
        // TODO: 11/5/2020 Checks item availability field and delivers item to customer. 
        //  Also used to check if change is needed, in case of a cash payment, from Payment (calls makeChange())
    }
    public void showMenu() {
        // TODO: 11/5/2020 Used to show any menu needed to the customer, including items, categories, total requested  
        //  payment, balance owed/due, an item dispensed message, a thank you message, asking for anything else
        
    }
    public void requestOfCustomer() {
        // TODO: 11/5/2020 Called if VendingMachine needs to ask the customer for Money, ask for anything else 
    } // needs a name change
}