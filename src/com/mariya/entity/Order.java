package com.mariya.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    private Long id;

    @Basic
    private Date date;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "employee_id")
    private Employer employee;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "product_id")
    private Product product;

    @Basic
    private BigDecimal amount;

    @Basic
    private Integer productCount;

    public Long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public Employer getEmployee() {
        return employee;
    }

    public Product getProduct() {
        return product;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setEmployee(Employer employee) {
        this.employee = employee;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Integer getProductCount() {
        return productCount;
    }

    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }


    public void populate(Order order) {
        this.date = order.getDate();
        this.employee = order.getEmployee();
        this.product = order.getProduct();
        this.amount = order.getAmount();
        this.productCount = order.getProductCount();

    }
}
