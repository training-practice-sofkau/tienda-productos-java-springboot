package com.sofkau.qa.tiendaproductos.VersionSinSpring;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    static Scanner scan = new Scanner(System.in);
    static ArrayList<Product> products = new ArrayList<Product>();
    static ArrayList<Invoice> invoices = new ArrayList<Invoice>();
    static String name = "";

    public static void main(String[] args) {
        products.add(new Product("Product 1", 10.0));
        products.add(new Product("Product 2", 20.0));
        products.add(new Product("Product 3", 30.0));
        products.add(new Product("Product 4", 40.0));
        products.add(new Product("Product 5", 50.0));
        products.add(new Product("Product 6", 60.0));
        products.add(new Product("Product 7", 70.0));
        products.add(new Product("Product 8", 80.0));
        products.add(new Product("Product 9", 90.0));
        products.add(new Product("Product 10", 100.0));

        boolean running = true;
        while (running) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. View products");
            System.out.println("2. Buy products");
            System.out.println("3. View invoices");
            System.out.println("4. Change name");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scan.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("\n--- Products ---");
                    for (int i = 0; i < products.size(); i++) {
                        System.out.println(i + 1 + ". " + products.get(i).toString());
                    }
                    break;
                case 2:
                    System.out.println("\n--- Buy Products ---");
                    ArrayList<Product> cart = new ArrayList<Product>();
                    double total = 0;
                    boolean buying = true;
                    while (buying) {
                        System.out.println("Enter product number (0 to finish): ");
                        int productNum = scan.nextInt();
                        if (productNum == 0) {
                            buying = false;
                        } else {
                            Product product = products.get(productNum - 1);
                            System.out.println("Enter quantity: ");
                            int quantity = scan.nextInt();
                            total += product.getPrice() * quantity;
                            cart.add(new Product(product.getName(), product.getPrice(), quantity));
                        }
                    }
                    Invoice invoice = new Invoice(name, total, cart);
                    invoices.add(invoice);
                    System.out.println("\n--- Invoice ---");
                    System.out.println(invoice.toString());
                    break;
                case 3:
                    System.out.println("\n--- Invoices ---");
                    for (int i = 0; i < invoices.size(); i++) {
                        System.out.println(i + 1 + ". " + invoices.get(i).toString());
                    }
                    break;
                case 4:
                    System.out.print("Enter new name: ");
                    scan.nextLine();
                    name = scan.nextLine();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
        System.out.println("Bye!");
    }
}

class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantity = 1;
    }

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public String toString() {
        return this.name + " - $" + this.price + " x " + this.quantity;
    }
}

class Invoice {
    private String name;
    private double total;
    private ArrayList<Product> products;

    public Invoice(String name, double total, ArrayList<Product> products) {
        this.name = name;
        this.total = total;
        this.products = products;
    }

    public String getName() {
        return this.name;
    }

    public double getTotal() {
        return this.total;
    }

    public ArrayList<Product> getProducts() {
        return this.products;
    }

    public String toString() {
        String result = "Name: " + this.name + "\n";
        result += "Total: $" + this.total + "\n";
        result += "Products:\n";
        for (int i = 0; i < this.products.size(); i++) {
            result += "  " + this.products.get(i).toString() + "\n";
        }
        return result;
    }
}
