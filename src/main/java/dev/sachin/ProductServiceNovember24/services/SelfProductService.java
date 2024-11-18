package dev.sachin.ProductServiceNovember24.services;

import dev.sachin.ProductServiceNovember24.exceptions.ProductNotFoundException;
import dev.sachin.ProductServiceNovember24.models.Category;
import dev.sachin.ProductServiceNovember24.models.Product;
import dev.sachin.ProductServiceNovember24.repositories.CategoryRepository;
import dev.sachin.ProductServiceNovember24.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("selfProductService")
public class SelfProductService implements ProductService{

    private CategoryRepository categoryRepository;
    private ProductRepository productRepository;

    @Autowired
    public void setCategoryRepository(CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product getSingleProduct(Long id) throws ProductNotFoundException {
        return null;
    }

    @Override
    public Product createProduct(String title,
                                 String description,
                                 double price,
                                 String imageUrl,
                                 String category) {
        Product product = new Product();
        product.setName(title);
        product.setDescription(description);
        product.setPrice(price);
        product.setImageUrl(imageUrl);

        Category categoryfromDB = categoryRepository.findByTitle(category);

        if(categoryfromDB == null){
            Category newcategory = new Category();
            newcategory.setTitle(category);
            categoryfromDB=newcategory;
        }

        product.setCategory(categoryfromDB);

        Product createdProduct = productRepository.save(product);

        return createdProduct;
    }
}
