package com.pointofsale.input;

import com.pointofsale.service.IService;
import com.pointofsale.model.Product;
import com.pointofsale.database.IProductRepository;

public class BarcodeScanner {

    private IProductRepository productRepository;
    private IService service;

    public BarcodeScanner(IService service, IProductRepository productRepository) {
        this.service = service;
        this.productRepository = productRepository;
    }

    public void scan(String barcode) {
        if (barcode.isEmpty()) {
            service.emptyBarcode();
        } else if (barcode.equals("exit")) {
            service.exit();
        } else {
            Product product = productRepository.findByBarCode(barcode);
            if (product == null) {
                service.productNotFound();
            } else {
                service.productFound(product);
            }
        }
    }

}
