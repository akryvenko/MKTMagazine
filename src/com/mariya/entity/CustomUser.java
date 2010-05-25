package com.mariya.entity;

import org.acegisecurity.GrantedAuthority;
import org.acegisecurity.userdetails.User;

public class CustomUser extends User {

    private Object userInfo;

    public CustomUser(String username, String password, boolean isEnabled, GrantedAuthority[] authorities, Object user) {
        super(username, password, isEnabled, true, true, true, authorities);
        this.setUserInfo(user);
    }

    public CustomUser(String username, String password, boolean isEnabled, GrantedAuthority[] arrayAuths) {
        super(username, password, isEnabled, true, true, true, arrayAuths);
    }

    public Object getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(Object userInfo) {
        this.userInfo = userInfo;
    }
}
