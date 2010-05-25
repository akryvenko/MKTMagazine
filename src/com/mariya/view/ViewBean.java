package com.mariya.view;

import java.math.BigDecimal;

public class ViewBean {
    private String name;
    private Object value;

    public ViewBean(String name, Object value, Object value2) {
        this.name = name;
        this.value = value;
        this.value2 = value2;
    }

    public ViewBean(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public Object getValue2() {

        return value2;
    }

    public void setValue2(Object value2) {
        this.value2 = value2;
    }

    private Object value2;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
