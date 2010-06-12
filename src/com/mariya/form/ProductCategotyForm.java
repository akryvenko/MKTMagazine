package com.mariya.form;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

public class ProductCategotyForm extends ValidatorForm implements Serializable {

    private Long id;
    private String name;
    private boolean active;

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

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public void reset(ActionMapping mapping, HttpServletRequest request) {
        super.reset(mapping, request);
        id = null;
        name = "";
        this.active = false;
    }
}
