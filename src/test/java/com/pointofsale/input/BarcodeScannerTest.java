package com.pointofsale.input;

import static org.mockito.Mockito.*;

import com.pointofsale.database.IProductRepository;
import com.pointofsale.service.IService;
import com.pointofsale.model.Product;
import org.junit.Before;
import org.junit.Test;

public class BarcodeScannerTest {

    private BarcodeScanner barcodeScanner;
    private IService service = mock(IService.class);
    private IProductRepository productRepository = mock(IProductRepository.class);

    @Before
    public void setUp() throws Exception {
        barcodeScanner = new BarcodeScanner(service, productRepository);
        when(productRepository.findByBarCode(anyString())).thenReturn(null);
        when(productRepository.findByBarCode("5901234123456"))
                .thenReturn(new Product("Cos", 20.02, "5901234123456"));
    }

    @Test
    public void testEmptyBarcodeScan() {
        barcodeScanner.scan("");
        verify(service).emptyBarcode();
    }
    @Test
    public void testExitScan() {
        barcodeScanner.scan("exit");
        verify(service).exit();
    }
    @Test
    public void testExistingBarcodeScan() {
        barcodeScanner.scan("5901234123456");
        verify(service).productFound(any(Product.class));
    }
    @Test
    public void testNotExistingBarcodeScan() {
        barcodeScanner.scan("5901234123450");
        verify(service).productNotFound();
    }

}
