package com.codecool.shop.dao;

import com.codecool.shop.model.Supplier;

import java.util.List;

/**
 * SupplierDao interface that must be implemented
 */
public interface SupplierDao {

    void add(Supplier supplier);
    Supplier find(int id);
    void remove(int id);

    List<Supplier> getAll();
}
