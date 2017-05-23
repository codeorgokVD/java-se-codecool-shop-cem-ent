package com.codecool.shop.model;


public class Parts extends Product implements Orderable {
    /**
     * Constructor
     * @param name name of part
     * @param defaultPrice defaultPrice of part
     * @param currencyString currency as string of part
     * @param description description of part
     * @param productCategory category of part
     * @param supplier supplier object of part
     */
    public Parts(String name, float defaultPrice, String currencyString, String description, ProductCategory productCategory, Supplier supplier) {
        super(name, defaultPrice, currencyString, description, productCategory, supplier );
    }

    /**
     * Checks if part product is in stock
     * @return boolean
     */
    @Override
    public boolean inStock() {
        return true;
    }
}
