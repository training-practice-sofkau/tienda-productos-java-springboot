package com.sofkau.qa.tiendaproductos.IntegracionSpringPostman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@SpringBootApplication
@RestController
public class ProductController {
    private List<Product> products = new ArrayList<>();
    private List<Invoice> invoices = new ArrayList<>();

    public static void main(String[] args) {
        SpringApplication.run(ProductController.class, args);
    }

    @GetMapping("/products")
    public List<Product> getProducts() {
        products.add(new Product(1, "Product 1", 10.0));
        products.add((new Product(2, "Product 2", 20.0)));
        products.add((new Product(3, "Product 3", 30.0)));
        products.add((new Product(4, "Product 4", 40.0)));
        products.add((new Product(5, "Product 5", 50.0)));
        products.add((new Product(6, "Product 6", 60.0)));
        products.add((new Product(7, "Product 7", 70.0)));
        products.add((new Product(8, "Product 8", 80.0)));
        products.add((new Product(9, "Product 9", 90.0)));
        products.add((new Product(10, "Product 10", 100.0)));
        return products;
    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product) {

        products.add(product);
        return product;
    }

    @PutMapping("/products/{id}")
    public Product updateProduct(@PathVariable int id, @RequestBody Product updatedProduct) {
        Product product = products.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
        if (product != null) {
            product.setName(updatedProduct.getName());
            product.setPrice(updatedProduct.getPrice());
        }
        return product;
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable int id) {
        products.removeIf(p -> p.getId() == id);
    }

    @PostMapping("/buy")
    public Invoice buyProduct(@RequestBody Purchase purchase) {
        Product product = products.stream()
                .filter(p -> p.getId() == purchase.getProductId())
                .findFirst()
                .orElse(null);
        if (product == null) {
            return null;
        }
        Invoice invoice = new Invoice(purchase.getUserName(), product.getName(), product.getPrice());
        invoices.add(invoice);
        return invoice;
    }

    @GetMapping("/invoices")
    public List<Invoice> getInvoices() {
        return invoices;
    }
}

class Product {
    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

class Purchase {
    private int productId;
    private String userName;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}

class Invoice {
    private String userName;
    private String productName;
    private double price;

    public Invoice(String userName, String productName, double price) {
        this.userName = userName;
        this.productName = productName;
        this.price = price;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

