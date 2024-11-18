package dev.sachin.ProductServiceNovember24.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel{
    private String name;
    private String description;
    private double price;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    private Category category;
    private String imageUrl;
}