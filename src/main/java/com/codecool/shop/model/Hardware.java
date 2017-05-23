package com.codecool.shop.model;


public class Hardware extends Product implements Orderable {

    private int warranty;

    /**
     * Constructor
     * @param name name of hardware
     * @param defaultPrice defaultPrice of hardware
     * @param currencyString currency in string of hardware
     * @param description description of of hardware
     * @param productCategory category of hardware
     * @param supplier supplier object of of hardware
     * @param warranty warranty time of of hardware
     */
    public Hardware(String name, float defaultPrice, String currencyString, String description, ProductCategory productCategory, Supplier supplier, int warranty) {
        super(name, defaultPrice, currencyString, description, productCategory, supplier );
        this.warranty = warranty;
    }

    /**
     * Checks if hardware product is in stock
     * @return boolean
     */
    @Override
    public boolean inStock() {
        return true;
    }

}
