package com.subrutin.lingkar.catalog.web;

import java.net.URI;

import org.jboss.resteasy.reactive.RestResponse;

import com.subrutin.lingkar.catalog.dto.UserCreateRequestDTO;
import com.subrutin.lingkar.catalog.service.UserService;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("/v1/user")
public class UserResource {

    private final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @POST
    public RestResponse<Void> createUser(UserCreateRequestDTO dto) {
        userService.createUser(dto);
        return RestResponse.created(URI.create("/v1/user"));
    }

}
