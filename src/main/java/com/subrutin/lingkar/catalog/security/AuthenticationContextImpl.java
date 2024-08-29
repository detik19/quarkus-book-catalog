package com.subrutin.lingkar.catalog.security;

import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class AuthenticationContextImpl implements AuthenticationContext {

    private UserContext userContext;

    @Override
    public UserContext getCurrentUser() {
        System.out.println("get current user");
        return userContext;
    }

    public void setCurrentUser(UserContext userContext) {
        this.userContext = userContext;
    }

}
