package com.codecool.shop.model;



public class LineItem {
    private final Product product;
    private int quantity = 1;

    /**
     * Constructor
     * @param product object
     */
    public LineItem(Product product) {
        this.product = product;
    }

    /**
     * Get price of product
     * @return float
     */
    public float getPrice() {
        return product.getDefaultPrice() * quantity;
    }

    /**
     * Searches for a product
     * @return Product object
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Getter
     * @return int
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Setter
     * @param quantity integer
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Inrements quantity of product
     */
    public void incrementQuantity() {
        this.quantity += 1;
    }
    
}
