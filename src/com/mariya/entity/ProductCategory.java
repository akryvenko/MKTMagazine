package com.mariya.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class ProductCategory {

    @Id
    private Long id;

    @Basic
    private String name;

    @Basic
    private int active;


    @OneToMany(cascade = {CascadeType.ALL, CascadeType.MERGE})
    @JoinColumn(name = "category_id")
    private Set<Product> products;

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

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public void populate(ProductCategory productCategory) {
        this.id = productCategory.getId();
        this.name = productCategory.getName();
        this.active = productCategory.getActive();
    }
}
