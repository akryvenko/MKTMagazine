package com.mariya.enums;

public enum UserRoles {

    Admin("ROLE_ADMIN"),
    Customer("ROLE_CUSTOMER"),
    ProductManager("ROLE_PRODUCT_MANAGER"),
    Manager("ROLE_MANAGER");

    private String role;

    UserRoles(String role) {
        this.role = role;
    }

    public String getRoleName() {
        return this.role;
    }
}
