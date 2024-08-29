package com.subrutin.lingkar.catalog.util;

import org.eclipse.microprofile.jwt.Claim;
import org.eclipse.microprofile.jwt.Claims;


import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;


@RequestScoped
public class SecurityUtil {

    @Inject
    @Claim(standard = Claims.sub)
    String name;

    public String getCurrentUsername(){
        return name;

    }

}
