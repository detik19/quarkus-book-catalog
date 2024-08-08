package com.subrutin.lingkar.catalog.web;

import java.net.URI;

import org.jboss.resteasy.reactive.RestResponse;

import com.subrutin.lingkar.catalog.dto.AuthorCreateRequestDTO;
import com.subrutin.lingkar.catalog.dto.AuthorDetailResponseDTO;
import com.subrutin.lingkar.catalog.dto.AuthorUpdateRequestDTO;
import com.subrutin.lingkar.catalog.service.AuthorService;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/v1/author")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthorResource {

    private final AuthorService authorService;

    public AuthorResource(AuthorService authorService) {
        this.authorService = authorService;
    }

    @POST
    public RestResponse<Void> createNewAuthor(AuthorCreateRequestDTO dto) {
        authorService.createAuthor(dto);
        return RestResponse.created(URI.create("/v1/author"));
    }

    @PUT
    @Path("/{id}")
    public RestResponse<Void> updateAuthor(@PathParam("id") Long id, AuthorUpdateRequestDTO dto) {
        authorService.updateAuthor(id, dto);
        return RestResponse.ok();
    }

    @GET
    @Path("/{id}")
    public RestResponse<AuthorDetailResponseDTO> findAuthorDetail(@PathParam("id") Long id) {
        AuthorDetailResponseDTO dto = authorService.findAuthorDetail(id);
        return RestResponse.ok(dto);
    }

}
