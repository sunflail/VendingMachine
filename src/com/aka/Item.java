package com.aka;

class Item extends VendingMachine {
    // Instance Variables
    private String name;
    private double price;
    private boolean inStock = true;
    private boolean isRetrievable;
    private boolean currentlySelected = false;
    private String itemId;


    protected Item(String itemId, String name, String category, double price, boolean inStock) {
        this.category = category;
        this.itemId = itemId;
        this.name = name;
        this.price = price;
        setInStock(inStock);
        setCurrentlySelected(false);
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

    public boolean isCurrentlySelected() {
        return currentlySelected;
    }

    public void setCurrentlySelected(boolean currentlySelected) {
        this.currentlySelected = currentlySelected;
    }
}