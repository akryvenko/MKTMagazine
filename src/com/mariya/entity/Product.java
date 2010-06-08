package com.mariya.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {

    @Id
    private Long id;

    @Basic
    private String name;

    @Basic
    private String description;

    @Basic
    private BigDecimal price;

    @OneToMany(cascade = {CascadeType.ALL, CascadeType.MERGE})
    @JoinColumn(name = "product_id")
    private List<Order> orders;

    @Basic
    private Integer count;

    @Basic
    private String imagePath;

    @Basic
    private int active;

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }


    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public void populate(Product product) {
        name = product.getName();
        description = product.getDescription();
        price = product.getPrice();
        count = product.getCount();
        if (!product.getImagePath().equals("")) {
            imagePath = product.getImagePath();
        }
        active = product.getActive();
    }
}
