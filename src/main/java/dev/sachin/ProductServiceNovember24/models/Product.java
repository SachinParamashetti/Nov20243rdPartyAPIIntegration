package dev.sachin.ProductServiceNovember24.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private int id;
    private String name;
    private String description;
    private double price;
    private Category category;
    private String imageUrl;
}