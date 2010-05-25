package com.mariya.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="office")
public class Office {

    @Id
    private Long id;

    @Basic
    private String city;

    @Basic
    private String region;

    @OneToMany(cascade = {CascadeType.ALL, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinColumn(name="office_id")
    private Set<Employer> employees;

    @Basic
    private BigDecimal target;

    @Basic
    private BigDecimal sales;

    @ManyToOne( cascade = CascadeType.ALL)
    @JoinColumn(name="customer_id")
    private Customer customer;

    public Long getId() {
        return id;
    }

    public String getCity() {
        return city;
    }


    public String getRegion() {
        return region;
    }

    public BigDecimal getTarget() {
        return target;
    }

    public BigDecimal getSales() {
        return sales;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setTarget(BigDecimal target) {
        this.target = target;
    }

    public void setSales(BigDecimal sales) {
        this.sales = sales;
    }

    public Set<Employer> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employer> employees) {
        this.employees = employees;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void populate(Office office) {
            this.city = office.getCity();
            this.region = office.getRegion();
            this.target = office.getTarget();
            this.sales = office.getSales();
    }
}
