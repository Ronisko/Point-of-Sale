package com.pointofsale.service;

import com.pointofsale.model.Product;

public interface IService {

    void emptyBarcode();

    void exit();

    void productNotFound();

    void productFound(Product product);

}
