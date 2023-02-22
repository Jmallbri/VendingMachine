package com.techelevator;

import java.math.BigDecimal;

public abstract class Product {
       // Purpose: Allows other classes to implement the "getResponse" method, which will be overridden to give custom messages based on the class.

    private String name;
    private BigDecimal price;
    private String type;
    private int quantity;

    public abstract String response();

    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public void setType(String type) {
        this.type = type;
    }
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public String getName() {
        return name;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public String getType() {
        return type;
    }


    // Define the basic attributes of a Product, like name and price.

    // Define what a Product does--in this case, it responds with a string!
}
