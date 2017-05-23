package com.codecool.shop.model;

import java.util.ArrayList;

public class ProductCategory extends BaseModel {
    private String department;
    private ArrayList<Product> products;

    /**
     * Constructor
     * @param name name of category
     * @param department department of category
     * @param description description of category
     */
    public ProductCategory(String name, String department, String description) {
        super(name, description);
        this.department = department;
        this.products = new ArrayList<>();
    }

    /**
     * Constructor
     * @param id id of category
     * @param name name of category
     * @param department department of category
     * @param description description of category
     */
    public ProductCategory(int id, String name, String department, String description ) {
        super(id, name, description);
        this.department = department;
        this.products = new ArrayList<>();
    }


    /**
     * Getter
     * @return String
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Setter
     * @param department string object
     */
    public void setDepartment(String department) {
        this.department = department;
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
        return String.format(
                "id: %1$d," +
                        "name: %2$s, " +
                        "department: %3$s, " +
                        "description: %4$s",
                this.id,
                this.name,
                this.department,
                this.description);
    }
}