package dev.sachin.ProductServiceNovember24.services;

import dev.sachin.ProductServiceNovember24.exceptions.ProductNotFoundException;
import dev.sachin.ProductServiceNovember24.models.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    List<Product> getAllProductsPage(int pageNumber, int pageSize);

    Product getSingleProduct(Long id) throws ProductNotFoundException;

    Product createProduct(String title,String description, double price, String imageUrl, String category );
}
