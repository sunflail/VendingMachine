package com.aka;

class Item {
    // Instance Variables
    private String name;
    private String category; // probably reference an enum
    private double price;
    private boolean inStock = true;
    private boolean isRetrievable;

    public  Item(String name, String category, double price, boolean inStock) {
        this.name = name;
        this.category = category;
        this.price = price;
        setInStock(inStock);
    }


    //ACCESSOR METHODS
    // TODO: an item's price should be retrievable
    public double getPrice() {
    return price;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public boolean isRetrievable() {
        return isRetrievable;
    }

    public void setRetrievable(boolean retrievable) {
        isRetrievable = retrievable;
    }
}