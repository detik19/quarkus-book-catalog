package com.subrutin.lingkar.catalog.web;

import java.net.URI;
import java.util.List;

import org.jboss.resteasy.reactive.RestResponse;

import com.subrutin.lingkar.catalog.dto.CategoryRequestDTO;
import com.subrutin.lingkar.catalog.dto.CategoryResponseDTO;
import com.subrutin.lingkar.catalog.service.CategoryService;

import jakarta.enterprise.inject.Default;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/v1/category")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CategoryResource {

    private final CategoryService categoryService;

    public CategoryResource(CategoryService categoryService) {
        this.categoryService = categoryService;
    }   

    @POST
    public RestResponse<Void> createAndUpdateCategory(CategoryRequestDTO dto) {
        categoryService.createAndUpdateCategory(dto);
        return RestResponse.created(URI.create("/v1/category"));
    }

    @GET
    public RestResponse<List<CategoryResponseDTO>> findAllCategory(
            @QueryParam("name") @DefaultValue("") String name) {
        List<CategoryResponseDTO> dto = categoryService.findAllCategory(name);
        return RestResponse.ok(dto);
    }

    @DELETE
    @Path("{code}")
    public RestResponse<Void> deleteCategory(@PathParam("code") String code) {
        categoryService.deleteCategory(code);
        return RestResponse.ok();
    }


}
