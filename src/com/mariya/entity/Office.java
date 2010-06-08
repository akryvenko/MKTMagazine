package com.mariya.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "office")
public class Office {

    @Id
    private Long id;

    @Basic
    private String name;

    @Basic
    private String city;

    @Basic
    private String address;

    @Basic
    private String phone;

    @Basic
    private String mail;

    @Basic
    private String region;

    @OneToMany(cascade = {CascadeType.ALL, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinColumn(name = "office_id")
    private Set<Employer> employees;

    @Basic
    private BigDecimal target;

    @Basic
    private int active;

    @Basic
    private BigDecimal sales;

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

    public void populate(Office office) {
        this.name = office.getName();
        this.address = office.getAddress();
        this.phone = office.getPhone();
        this.mail = office.getMail();
        this.city = office.getCity();
        this.region = office.getRegion();
        this.target = office.getTarget();
        this.sales = office.getSales();
        this.active = office.getActive();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }
}
