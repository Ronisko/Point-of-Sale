package com.pointofsale.model;

import java.util.ArrayList;
import java.util.List;

public class Receipt {

    private List<Product> products = new ArrayList<>();
    private Double sum;

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public List<Product> getReceipt() {
         return products;
    }

    public void calculateSum() {
        sum = products.stream().map(Product::getPrice).reduce((a, b) -> a+b).orElse(0.0);
    }

    public Double getSum() {
        return sum;
    }

}
