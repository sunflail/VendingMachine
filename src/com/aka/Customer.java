package com.aka;

class Customer {
    public static void main(String[] args) {
        // TODO: Instantiate Customer and call to VendingMachine from here
    }
    // Variables

    private Enum funds; // may or may not be an Enum

    // Business methods
    public void makeRequest() {// might be better as makeSelection()
        //TODO: Customer calls items to see list of items to choose from - categoryOfItems
    }
    public void makePayment() {
    //TODO: Customer calls Enum Payment to select what form of payment is being used to make payment for items
    }
    public void retrieveItem() {
    //TODO: Customer recieves the item(s) dispensed from the Vending Machine - call to dispensesSomething()
    }

}