package dev.sachin.ProductServiceNovember24.controllers;

import dev.sachin.ProductServiceNovember24.dtos.CreateProductRequestDto;
import dev.sachin.ProductServiceNovember24.dtos.ErrorDTO;
import dev.sachin.ProductServiceNovember24.exceptions.ProductNotFoundException;
import dev.sachin.ProductServiceNovember24.models.Product;
import dev.sachin.ProductServiceNovember24.services.ProductService;
import dev.sachin.ProductServiceNovember24.services.SelfProductService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    private ProductService productService;

    public ProductController(@Qualifier("selfProductService") ProductService productService){
        this.productService=productService;
    }
    /*
    *
    * */
    @GetMapping("/products/{id}")
    public Product getSingleProduct(@PathVariable("id") long id) throws ProductNotFoundException {
        return productService.
                getSingleProduct(id);
    }

    @GetMapping("/products/page/")
    public List<Product> getProductsByPage(@PathParam("pageNumber") int pageNumber, @PathParam("pageSize") int pageSize){
        return productService.getAllProductsPage(pageNumber, pageSize);
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

    // local exception handler same copied in control advice
//    @ExceptionHandler(ProductNotFoundException.class)
//    public ResponseEntity<ErrorDTO> handleProductNtFoundException(ProductNotFoundException productNotFoundException){
//        ErrorDTO errorDTO = new ErrorDTO();
//        errorDTO.setMessage(productNotFoundException.getMessage());
//
//        ResponseEntity<ErrorDTO> responseEntity = new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
//        return  responseEntity;
//    }
}
