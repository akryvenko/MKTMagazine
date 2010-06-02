package com.mariya.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "employees")
public class Employer {

    @Id
    private Long id;

    @Basic
    private String firstName;

    @Basic
    private String lastName;

    @Basic
    private String mail;

    @Basic
    private String phone;

    @Basic
    private Integer age;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "office_id")
    private Office office;

    @Basic
    private String title;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "manager_id")
    private Employer manager;

    @Basic
    private BigDecimal quota;

    @Basic
    private BigDecimal sales;

    @OneToMany(cascade = {CascadeType.ALL, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id")
    private List<Order> orders;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Employer getManager() {
        return manager;
    }

    public void setManager(Employer manager) {
        this.manager = manager;
    }

    public BigDecimal getQuota() {
        return quota;
    }

    public void setQuota(BigDecimal quota) {
        this.quota = quota;
    }

    public BigDecimal getSales() {
        return sales;
    }

    public void setSales(BigDecimal sales) {
        this.sales = sales;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void populate(Employer employer) {
        this.firstName = employer.getFirstName();
        this.lastName = employer.getLastName();
        this.mail = employer.getMail();
        this.phone = employer.getPhone();
        this.age = employer.getAge();
        this.office = employer.getOffice() ;
        this.title = employer.getTitle();
        this.manager = employer.getManager();
        this.quota = employer.getQuota();
        this.sales = employer.getSales();
    }

     public String getFullName(){
        return firstName + " : " + lastName;
    }
}