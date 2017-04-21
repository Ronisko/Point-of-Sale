package com.pointofsale.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ReceiptTest {

    private Receipt receipt;

    @Before
    public void setUp(){
        receipt = new Receipt();
    }

    @Test
    public void testCalculateSumWithoutProducts(){
        receipt.calculateSum();
        assertEquals(new Double(0.0), receipt.getSum());
    }

    @Test
    public void testCalculateSum(){
        receipt.addProduct(new Product("a", 2.99, "1"));
        receipt.addProduct(new Product("a", 31.23, "1"));
        receipt.calculateSum();
        assertEquals(new Double(34.22), receipt.getSum());
    }

}
