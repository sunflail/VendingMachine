package com.aka;

class Customer {
    // Variables

    private Enum funds; // may or may not be an Enum

    // Business methods
    public String makeSelection() {// might be better as makeSelection()
        //TODO: Customer calls items to see list of items to choose from - categoryOfItems
        System.out.println("Simulate user choosing drinks via console input");
        return "Drinks";
    }

    public String makeItemSelection() {
        System.out.println("User chooses XYZ");
        return "XYZ";
    }

    public boolean makeAnotherChoice() {
        System.out.println("User picks no");
        return false;
    }

    public double makePayment(double payment) {
    //TODO: Customer calls Enum Payment to select what form of payment is being used to make payment for items
        System.out.println("Console input from customer equals the amount requested of " + payment);
        Payment.setInputAmount(payment);
        return payment;
    }
    public void retrieveItem(Item item) {
    //TODO: Customer picks up item which changes availability of item
        item.setInStock(false);
    }

    public void askForResponse() {
        System.out.println("simulated user input from console");
    }

}