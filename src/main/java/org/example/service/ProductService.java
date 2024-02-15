package org.example.service;

import org.example.model.Product;

import java.util.List;

public interface ProductService {


    void create(Product product);

    void update(int id, Product product);
    void delete(int id);
    Product get(int id);
    List<Product> getAll();
}
