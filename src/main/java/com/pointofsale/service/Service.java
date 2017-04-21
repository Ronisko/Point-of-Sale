package com.pointofsale.service;

import com.pointofsale.output.LCDDisplay;
import com.pointofsale.output.Printer;
import com.pointofsale.model.Product;
import com.pointofsale.model.Receipt;

public class Service implements IService {
    private Receipt receipt;
    private Printer printer;
    private LCDDisplay lcdDisplay;

    public Service(LCDDisplay lcdDisplay, Printer printer, Receipt receipt) {
        this.lcdDisplay = lcdDisplay;
        this.printer = printer;
        this.receipt = receipt;
    }

    public void emptyBarcode() {
        lcdDisplay.display("Invalid bar-code");
    }

    public void exit() {
        receipt.calculateSum();
        printer.display(receipt);
        lcdDisplay.display(String.valueOf(receipt.getSum()));
    }

    public void productNotFound() {
        lcdDisplay.display("Product not found");
    }

    public void productFound(Product product) {
        lcdDisplay.display(product.getAll());
        receipt.addProduct(product);
    }

}
