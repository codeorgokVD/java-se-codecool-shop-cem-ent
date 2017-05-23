package com.codecool.shop.dao.implementation;


import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.model.ProductCategory;

import java.util.ArrayList;
import java.util.List;

public class ProductCategoryDaoMem implements ProductCategoryDao {

    private List<ProductCategory> DATA = new ArrayList<>();
    private static ProductCategoryDaoMem instance = null;

    /* A private Constructor prevents any other class from instantiating.
     */
    private ProductCategoryDaoMem() {
    }

    /**
     * Singleton.
     * @return ProductCategoryDaoMem object
     */
    public static ProductCategoryDaoMem getInstance() {
        if (instance == null) {
            instance = new ProductCategoryDaoMem();
        }
        return instance;
    }

    /**
     * Adds new product category
     * @param category category of product
     */
    @Override
    public void add(ProductCategory category) {
        category.setId(DATA.size() + 1);
        DATA.add(category);
    }

    /**
     * Find a given category
     * @param id id of given category
     * @return ProductCategory object
     */
    @Override
    public ProductCategory find(int id) {
        return DATA.stream().filter(t -> t.getId() == id).findFirst().orElse(null);
    }

    /**
     * Removes category by a given id
     * @param id id of given category
     */
    @Override
    public void remove(int id) {
        DATA.remove(find(id));
    }

    /**
     * Returns all category
     * @return ProductCategory List
     */
    @Override
    public List<ProductCategory> getAll() {
        return DATA;
    }
}
