package com.codecool.shop.model;


public class Software extends Product {

    private int duration;

    /**
     * Constructor
     * @param name name of software
     * @param defaultPrice defaultPrice of software
     * @param currencyString currency as string of software
     * @param description description of software
     * @param productCategory category of software
     * @param supplier supplier object of software
     * @param duration duration time of software
     */
    public Software(String name, float defaultPrice, String currencyString, String description, ProductCategory productCategory, Supplier supplier, int duration) {
        super(name, defaultPrice, currencyString, description, productCategory, supplier );
        this.duration = duration;
    }
}
