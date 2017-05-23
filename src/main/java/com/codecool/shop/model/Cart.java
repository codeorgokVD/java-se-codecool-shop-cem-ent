package com.codecool.shop.model;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Cart{
    Date created = new Date();
    private final List<LineItem> lineItems = new ArrayList<>();

    /**
     * Add new LineItem
     * @param lineItem object
     */
    public void add(LineItem lineItem) {
        if (hasProduct(lineItem)) {
            findLineItem(lineItem).incrementQuantity();
        }
        else {
            lineItems.add(lineItem);
        }
    }

    /**
     * Find all LineItems
     * @return LineItem List
     */
    public List<LineItem> getAll() {
        return lineItems;
    }

    /**
     * Remove a LineItem
     * @param lineItem object
     */
    public void remove(LineItem lineItem) {
        lineItems.remove(findLineItem(lineItem));
    }


    /**
     * Find a _LineItem
     * @param lineItem object
     * @return LineItem object
     */
    private LineItem findLineItem(LineItem lineItem) {
        return lineItems.stream()
                .filter(l -> l.getProduct().getId() == lineItem.getProduct().getId())
                .findFirst().orElse(null);
    }

    /**
     * Checks if given LineItem has product
     * @param lineItem object
     * @return boolean
     */
    private boolean hasProduct(LineItem lineItem) {
        return lineItems.stream()
                .anyMatch(li -> li.getProduct().getId() == lineItem.getProduct().getId());
    }

    /**
     * Counts sum of items
     * @return float
     */
    public float getSum() {
        float sum = 0;
        for (LineItem lineItem : lineItems) {
            sum += lineItem.getPrice();
        }
        return sum;
    }

    /**
     * Counts all quantity
     * @return int
     */
    public int getAllQuantity(){
        int allQuantity = 0;
        for (LineItem lineItem : lineItems) {
            allQuantity += lineItem.getQuantity();
        }
        return allQuantity;
    }
}
