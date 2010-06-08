package com.mariya.form;

import com.mariya.enums.OrderStatus;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.math.BigDecimal;

import com.mariya.utils.Utils;

import javax.servlet.http.HttpServletRequest;

public class OrderForm extends ValidatorForm implements Serializable {

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

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public Long getProduct() {
        return product;
    }

    public void setProduct(Long product) {
        this.product = product;
    }

    public String getProductCount() {
        return productCount;
    }

    public void setProductCount(String productCount) {
        this.productCount = productCount;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Float productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    private Long id;
    private String date;
    private Long customer;
    private String employee;
    private Long product;
    private String productCount;
    private String customerName;
    private String productName;
    private Float productPrice;
    private Integer status;


    @Override
    public void reset(ActionMapping mapping, HttpServletRequest request) {
        super.reset(mapping, request);
        id = null;
        date = "";
        customer = null;
        employee = null;
        product = null;
        productCount = "";
        customerName = "";
        productName = "";
        productPrice = null;
        status = OrderStatus.InProgress.getStatusValue();
    }
}
