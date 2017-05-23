package com.codecool.shop.model;

import java.util.Currency;

public class Product extends BaseModel {

    private float defaultPrice;
    private Currency defaultCurrency;
    private ProductCategory productCategory;
    private Supplier supplier;

    /**
     * Constructor
     * @param name name of product
     * @param defaultPrice price of product
     * @param currencyString currency as string of product
     * @param description description of product
     * @param productCategory category of product
     * @param supplier supplier object of product
     */
    public Product(String name, float defaultPrice, String currencyString, String description, ProductCategory productCategory, Supplier supplier) {
        super(name, description);
        this.setPrice(defaultPrice, currencyString);
        this.setSupplier(supplier);
        this.setProductCategory(productCategory);
    }

    /**
     * Constructor
     * @param id id of product
     * @param name name of product
     * @param defaultPrice price of product
     * @param currencyString currency as string of product
     * @param description description of product
     * @param productCategory category of product
     * @param supplier supplier object of product
     */
    public Product(int id, String name, float defaultPrice, String currencyString, String description, ProductCategory productCategory, Supplier supplier) {
        super(id, name, description);
        this.setPrice(defaultPrice, currencyString);
        this.setSupplier(supplier);
        this.setProductCategory(productCategory);
    }


    /**
     * Getter
     * @return float
     */
    public float getDefaultPrice() {
        return defaultPrice;
    }

    /**
     * Setter
     * @param defaultPrice float price
     */
    public void setDefaultPrice(float defaultPrice) {
        this.defaultPrice = defaultPrice;
    }

    /**
     * Getter
     * @return Currency object
     */
    public Currency getDefaultCurrency() {
        return defaultCurrency;
    }

    /**
     * Setter
     * @param defaultCurrency Currency object
     */
    public void setDefaultCurrency(Currency defaultCurrency) {
        this.defaultCurrency = defaultCurrency;
    }

    /**
     * Getter
     * @return String price
     */
    public String getPrice() {
        return String.valueOf(this.defaultPrice) + " " + this.defaultCurrency.toString();
    }

    public void setPrice(float price, String currency) {
        this.defaultPrice = price;
        this.defaultCurrency = Currency.getInstance(currency);
    }

    /**
     * Getter
     * @return ProductCategory
     */
    public ProductCategory getProductCategory() {
        return productCategory;
    }

    /**
     * Setter
     * @param productCategory productCategory object
     */
    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
        this.productCategory.addProduct(this);
    }

    /**
     * Getter
     * @return Supplier object
     */
    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
        this.supplier.addProduct(this);
    }

    /**
     * Creates string of object properties
     * @return String
     */
    @Override
    public String toString() {
        return String.format("id: %1$d, " +
                        "name: %2$s, " +
                        "defaultPrice: %3$f, " +
                        "defaultCurrency: %4$s, " +
                        "productCategory: %5$s, " +
                        "supplier: %6$s",
                this.id,
                this.name,
                this.defaultPrice,
                this.defaultCurrency.toString(),
                this.productCategory.getName(),
                this.supplier.getName());
    }
}
