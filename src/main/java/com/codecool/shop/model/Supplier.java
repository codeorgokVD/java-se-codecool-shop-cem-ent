package com.codecool.shop.model;

import java.util.ArrayList;


public class Supplier extends BaseModel {
    private ArrayList<Product> products;

    /**
     * Constructor
     * @param name name of supplier
     * @param description description of supplier
     */
    public Supplier(String name, String description) {
        super(name, description);
        this.products = new ArrayList<>();
    }

    /**
     * Constructor
     * @param id id of supplier
     * @param name name of supplier
     * @param description description of supplier
     */
    public Supplier(int id, String name, String description) {
        super(id, name, description);
        this.products = new ArrayList<>();
    }

    /**
     * Setter
     * @param products object
     */
    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    /**
     * Getter
     * @return ArrayList of products
     */
    public ArrayList getProducts() {
        return this.products;
    }

    /**
     * Add new product
     * @param product object
     */
    public void addProduct(Product product) {
        this.products.add(product);
    }

    /**
     * Creates string of object properties
     * @return String
     */
    public String toString() {
        return String.format("id: %1$d, " +
                        "name: %2$s, " +
                        "description: %3$s",
                this.id,
                this.name,
                this.description
        );
    }
}