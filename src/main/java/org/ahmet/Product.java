package org.ahmet;

public record Product(int id, String name, double price, String category) {
    public Product {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
    }
}