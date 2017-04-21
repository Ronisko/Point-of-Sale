package com.pointofsale.service;

import static org.mockito.Mockito.*;

import com.pointofsale.model.Product;
import com.pointofsale.model.Receipt;
import com.pointofsale.output.LCDDisplay;
import com.pointofsale.output.Printer;
import org.junit.Before;
import org.junit.Test;

public class ServiceTest {

    private Service service;
    private LCDDisplay lcdDisplay;
    private Printer printer;
    private Receipt receipt;

    @Before
    public void setUp() throws Exception {
        printer = mock(Printer.class);
        receipt = mock(Receipt.class);
        lcdDisplay = mock(LCDDisplay.class);
        service = new Service(lcdDisplay, printer, receipt);
    }

    @Test
    public void emptyBarcode() throws Exception {
        service.emptyBarcode();
        verify(lcdDisplay, atLeastOnce()).display("Invalid bar-code");
    }

    @Test
    public void exit() throws Exception {
        service.exit();
        verify(receipt, atLeastOnce()).calculateSum();
        verify(printer, atLeastOnce()).display(receipt);
    }

    @Test
    public void productNotFound() throws Exception {
        service.productNotFound();
        verify(lcdDisplay, atLeastOnce()).display("Product not found");
    }

    @Test
    public void productFound() throws Exception {
        service.productFound(new Product("chocolate", 2.99, "5901234123456"));
        verify(lcdDisplay, atLeastOnce()).display(anyString());
        verify(receipt, atLeastOnce()).addProduct(any(Product.class));
    }

}
