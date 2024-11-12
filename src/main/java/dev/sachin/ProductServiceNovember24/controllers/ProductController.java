package dev.sachin.ProductServiceNovember24.controllers;

import dev.sachin.ProductServiceNovember24.dtos.CreateProductRequestDto;
import dev.sachin.ProductServiceNovember24.models.Product;
import dev.sachin.ProductServiceNovember24.services.FakeStoreProductService;
import dev.sachin.ProductServiceNovember24.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService){
        this.productService=productService;
    }
    /*
    *
    * */
    @GetMapping("/products/{id}")
    public Product getSingleProduct(@PathVariable("id") long id){
        return productService.getSingleProduct(id);
    }

    @GetMapping("/products")
    public List<Product> getProducts(){
        return productService.getAllProducts();
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody CreateProductRequestDto createProductRequestDto){
        return productService.createProduct(createProductRequestDto.getTitle(),createProductRequestDto.getDescription()
        ,createProductRequestDto.getPrice(), createProductRequestDto.getImage(), createProductRequestDto.getCategory());
    }

}
