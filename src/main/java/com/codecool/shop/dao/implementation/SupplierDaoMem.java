package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.model.Supplier;

import java.util.ArrayList;
import java.util.List;

public class SupplierDaoMem implements SupplierDao {

    private List<Supplier> DATA = new ArrayList<>();
    private static SupplierDaoMem instance = null;

    /* A private Constructor prevents any other class from instantiating.
     */
    private SupplierDaoMem() {
    }

    /**
     * Singleton.
     * @return Supplier object
     */
    public static SupplierDaoMem getInstance() {
        if (instance == null) {
            instance = new SupplierDaoMem();
        }
        return instance;
    }

    /**
     * Add new Supplier
     * @param supplier supplier object
     */
    @Override
    public void add(Supplier supplier) {
        supplier.setId(DATA.size() + 1);
        DATA.add(supplier);
    }

    /**
     * Find supplier by id
     * @param id id of supplier object
     * @return Supplier
     */
    @Override
    public Supplier find(int id) {
        return DATA.stream().filter(t -> t.getId() == id).findFirst().orElse(null);
    }

    /**
     * Remove supplier by id
     * @param id id of supplier to find
     */
    @Override
    public void remove(int id) {
        DATA.remove(find(id));
    }

    /**
     * Find all supplier
     * @return Supplier List
     */
    @Override
    public List<Supplier> getAll() {
        return DATA;
    }
}
