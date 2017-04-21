package com.pointofsale.output;

import com.pointofsale.model.Product;
import com.pointofsale.model.Receipt;

public class Printer {

    public void display(Receipt receipt) {
        System.out.println("Printer: ");
        receipt.getReceipt().stream().map(Product::getAll).forEach(System.out::println);
        System.out.println("Sum: " + receipt.getSum() + "\n");

    }

}
