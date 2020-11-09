package com.aka;

public class Item extends Menu {
    // Instance Variables
    private String name;
    //private String category; // probably reference an enum
    private double price;
    private boolean inStock = true;
    private boolean isRetrievable;
    private String itemId;

    public Item(String itemId, String name, String category, double price, boolean inStock) {
        super(category);
        this.itemId = itemId;
        this.name = name;
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

    public String getItemId() {
        return itemId;
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