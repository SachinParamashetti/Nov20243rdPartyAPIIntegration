package dev.sachin.ProductServiceNovember24.dtos;

import dev.sachin.ProductServiceNovember24.models.Category;
import dev.sachin.ProductServiceNovember24.models.Product;
import dev.sachin.ProductServiceNovember24.services.ProductService;
import lombok.Getter;
import lombok.Setter;

import java.security.PublicKey;

@Getter
@Setter
public class FakeStoreProductDto {
    private String title;
    private String description;
    private String image;
    private String category;
    private double price;

    public Product toProduct(){
        Product product = new Product();
        product.setName(title);
        product.setDescription(description);
        product.setPrice(price);
        Category category1 = new Category();
        category1.setTitle(category);
        product.setCategory(category1);
        product.setImageUrl(image);

        return product;

    }
}
