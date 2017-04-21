package com.pointofsale.database;

import com.pointofsale.model.Product;

@FunctionalInterface
public interface IProductRepository {
    Product findByBarCode(String barcode);
}