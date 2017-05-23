package com.codecool.shop.dao.implementation;


import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductDaoMem implements ProductDao {

    private List<Product> DATA = new ArrayList<>();
    private static ProductDaoMem instance = null;

    /* A private Constructor prevents any other class from instantiating.
     */
    private ProductDaoMem() {
    }


    /**
     * Singleton.
     * @return ProductDaoMem object
     */
    public static ProductDaoMem getInstance() {
        if (instance == null) {
            instance = new ProductDaoMem();
        }
        return instance;
    }

    /**
     * Add new product
     * @param product product object
     */
    @Override
    public void add(Product product) {
        product.setId(DATA.size() + 1);
        DATA.add(product);
    }

    /**
     * Find product by id
     * @param id id of product
     * @return Product object
     */
    @Override
    public Product find(int id) {
        return DATA.stream().filter(t -> t.getId() == id).findFirst().orElse(null);
    }

    /**
     * Remove product by id
     * @param id id of product
     */
    @Override
    public void remove(int id) {
        DATA.remove(find(id));
    }

    /** Find all products
     * @return Product List
     */
    @Override
    public List<Product> getAll() {
        return DATA;
    }

    /**
     * Find all product by supplier
     * @param supplier supplier object
     * @return Product List
     */
    @Override
    public List<Product> getBy(Supplier supplier) {
        return DATA.stream().filter(t -> t.getSupplier().equals(supplier)).collect(Collectors.toList());
    }

    /**
     * Find all product by product category
     * @param productCategory productCategory object
     * @return Product List
     */
    @Override
    public List<Product> getBy(ProductCategory productCategory) {
        return DATA.stream().filter(t -> t.getProductCategory().equals(productCategory)).collect(Collectors.toList());
    }
}
