package com.aka;

class Item extends VendingMachine {
    // Instance Variables
    private String name;
    private double price;
    private boolean inStock = true;
    private boolean isRetrievable;
    private String itemId;


    protected Item(String itemId, String name, String category, double price, boolean inStock) {
        this.category = category;
        this.itemId = itemId;
        this.name = name;
        this.price = price;
        setInStock(inStock);
    }


    //ACCESSOR METHODS
    // TODO: an item's price should be retrievable
    protected double getPrice() {
    return price;
    }

    protected String getName() {
        return name;
    }

    protected String getItemId() {
        return itemId;
    }


    protected boolean isInStock() {
        return inStock;
    }

    protected void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    protected boolean isRetrievable() {
        return isRetrievable;
    }

    protected void setRetrievable(boolean retrievable) {
        isRetrievable = retrievable;
    }


}