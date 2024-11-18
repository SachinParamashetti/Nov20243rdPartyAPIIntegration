package dev.sachin.ProductServiceNovember24.services;

import dev.sachin.ProductServiceNovember24.dtos.FakeStoreProductDto;
import dev.sachin.ProductServiceNovember24.exceptions.ProductNotFoundException;
import dev.sachin.ProductServiceNovember24.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{

    private RestTemplate restTemplate;

    public FakeStoreProductService (RestTemplate restTemplate){
        this.restTemplate=restTemplate;
    }


    @Override
    public List<Product> getAllProducts() {
        FakeStoreProductDto[] fakeStoreProductDtoList = restTemplate.getForObject("https://fakestoreapi.com/products",
                FakeStoreProductDto[].class);

        List<Product> products = new ArrayList<>();


        for(FakeStoreProductDto fakeStoreProductDto:fakeStoreProductDtoList){
            Product p = fakeStoreProductDto.toProduct();
            products.add(p);
        }
        return products;
    }

    @Override
    public Product getSingleProduct(Long id) throws ProductNotFoundException {
        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject("https://fakestoreapi.com/products/"+id,
                FakeStoreProductDto.class);
//9tj nov 2024 class eresponse entity usages
//        ResponseEntity<FakeStoreProductDto> fakeStoreProductDtoResponseEntity= restTemplate.getForEntity("https://fakestoreapi.com/products/"+id,FakeStoreProductDto.class);
//        if(fakeStoreProductDtoResponseEntity.getStatusCode() != HttpStatus.valueOf(200)){
////            handle exception
//        }
//        fakeStoreProductDtoResponseEntity.getHeaders();

        if(fakeStoreProductDto==null){
            throw new ProductNotFoundException("Product with id "+id+ ", is not found");
        }
        return fakeStoreProductDto.toProduct();
    }

    @Override
    public Product createProduct(String title,String description, double price, String imageUrl, String category ) {
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setCategory(category);
        fakeStoreProductDto.setImage(imageUrl);
        fakeStoreProductDto.setTitle(title);
        fakeStoreProductDto.setPrice(price);
        fakeStoreProductDto.setDescription(description);
        restTemplate.postForObject("https://fakestoreapi.com/products/",fakeStoreProductDto,FakeStoreProductDto.class);
        return fakeStoreProductDto.toProduct();
    }
}
