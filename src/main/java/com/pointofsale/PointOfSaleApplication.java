package com.pointofsale;

import com.pointofsale.database.IProductRepository;
import com.pointofsale.output.LCDDisplay;
import com.pointofsale.output.Printer;
import com.pointofsale.input.BarcodeScanner;
import com.pointofsale.service.Service;
import com.pointofsale.model.Product;
import com.pointofsale.model.Receipt;

import java.util.Scanner;

public class PointOfSaleApplication {
    public static void main(String[] args) {
        IProductRepository productRepository = barcode -> {
            if (barcode.equals("5901234123456")) {
                return new Product("Chocolate", 2.99, "5901234123456");
            } else if (barcode.equals("5901234123457")) {
                return new Product("Cookie", 0.50, "5901234123457");
            } else if (barcode.equals("5901234123458")) {
                return new Product("Asparagus", 6.66, "5901234123458");
            }
            return null;
        };

        Service service = new Service(new LCDDisplay(), new Printer(), new Receipt());
        BarcodeScanner barcodeScanner = new BarcodeScanner(service, productRepository);

        Scanner reader = new Scanner(System.in);

        while (true) {
            System.out.println("Scan code");
            String s = reader.nextLine();
            System.out.println();
            barcodeScanner.scan(s);
            if (s.equals("exit")) {
                break;
            }

        }
    }
}
