package com.mariya.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name="customers")
public class Customer implements Serializable {

    @Id
    private Long id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Basic
    private String mail;

    @Basic
    private String phone;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="customer_id")
    private List<Office> offices;

    @Column(name="cust_credit")
    private BigDecimal credit;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id")
    private User user;

    public Long getId() {
        return id;
    }

    public BigDecimal getCredit() {
        return credit;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCredit(BigDecimal credit) {
        this.credit = credit;
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

    public List<Office> getOffices() {
        return offices;
    }

    public void setOffices(List<Office> offices) {
        this.offices = offices;
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

    public String getFullName(){
        return firstName + " : " + lastName;
    }
}
