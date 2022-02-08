package com.aliendro.products.product;

import javax.persistence.*;

@Entity
@Table
public class Product {

    @Id
    @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_sequence"
    )
    private Long id;
    private String name;
    private String description;
    private Integer price;
    private String thumbnail;

    public Product() {
    }

    public Product(Long id, String name, String description, Integer price, String thumbnail) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.thumbnail = thumbnail;
    }

    public Product(String name, String description, Integer price, String thumbnail) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.thumbnail = thumbnail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public void setData(Product newProduct) {
        this.name = newProduct.getName();
        this.description = newProduct.description;
        this.price = newProduct.getPrice();
        this.thumbnail = newProduct.getThumbnail();
    }
}
