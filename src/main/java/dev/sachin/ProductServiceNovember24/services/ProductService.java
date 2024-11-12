package dev.sachin.ProductServiceNovember24.services;

import dev.sachin.ProductServiceNovember24.dtos.CreateProductRequestDto;
import dev.sachin.ProductServiceNovember24.models.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    Product getSingleProduct(Long id);

    Product createProduct(String title,String description, double price, String imageUrl, String category );
}
