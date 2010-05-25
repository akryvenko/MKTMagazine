package com.mariya.form;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import javax.servlet.ServletRequest;
import java.math.BigDecimal;

public class CustomerForm extends ActionForm {

    private Long id;
    private String firstName;
    private String lastName;
    private Long employer;
    private BigDecimal credit;


    @Override
    public ActionErrors validate(ActionMapping mapping, ServletRequest request) {
        ActionErrors actionErrors = super.validate(mapping, request);
        return actionErrors;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEmployer() {
        return employer;
    }

    public void setEmployer(Long employer) {
        this.employer = employer;
    }

    public BigDecimal getCredit() {
        return credit;
    }

    public void setCredit(BigDecimal credit) {
        this.credit = credit;
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
}
