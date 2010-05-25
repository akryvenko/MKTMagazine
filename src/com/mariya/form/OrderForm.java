package com.mariya.form;

import org.apache.struts.action.ActionForm;
import org.springframework.util.StringUtils;

import java.util.Calendar;
import java.util.Date;
import java.math.BigDecimal;

import com.mariya.utils.Utils;

public class OrderForm extends ActionForm{

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date =  date;
    }

    public Long getCustomer() {
        return customer;
    }

    public void setCustomer(Long customer) {
        this.customer = customer;
    }

    public Long getEmployee() {
        return employee;
    }

    public void setEmployee(Long employee) {
        this.employee = employee;
    }

    public Long getProduct() {
        return product;
    }

    public void setProduct(Long product) {
        this.product = product;
    }

    public BigDecimal getAmount() {
        return amount;
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

    private Long id;
    private String date;
    private Long customer;
    private Long employee;
    private Long product;
    private BigDecimal amount;
    private Integer productCount;

}
