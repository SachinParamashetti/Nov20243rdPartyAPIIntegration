package dev.sachin.ProductServiceNovember24.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel{
    private String name;
    private String description;
    private double price;
//    private Category category;
    private String imageUrl;
}