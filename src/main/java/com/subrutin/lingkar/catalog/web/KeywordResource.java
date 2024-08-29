package com.subrutin.lingkar.catalog.web;

import java.net.URI;

import org.jboss.resteasy.reactive.RestResponse;

import com.subrutin.lingkar.catalog.dto.KeywordListResponseDTO;
import com.subrutin.lingkar.catalog.dto.KeywordRequestDTO;
import com.subrutin.lingkar.catalog.dto.ResultPageResponseDTO;
import com.subrutin.lingkar.catalog.service.KeywordService;

import jakarta.annotation.security.RolesAllowed;
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

@Path("/v1/keyword")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class KeywordResource {

    private final KeywordService keywordService;

    public KeywordResource(KeywordService keywordService) {
        this.keywordService = keywordService;
    }

    @RolesAllowed("USER")
    @POST
    public RestResponse<Void> createNewKeyword(KeywordRequestDTO dto) {
        this.keywordService.createKeywords(dto);
        return RestResponse.created(URI.create("/v1/keyword"));
    }


    @GET
    public RestResponse<ResultPageResponseDTO<KeywordListResponseDTO>> findKeywordList(
            @QueryParam("pages") @DefaultValue("0") Integer pages, 
            @QueryParam("limit") @DefaultValue("10") Integer limit, 
            @QueryParam("sortBy") @DefaultValue("code") String sortBy, 
            @QueryParam("direction") @DefaultValue("asc") String direction, 
            @QueryParam("code") String code) {

        ResultPageResponseDTO<KeywordListResponseDTO> dtos = this.keywordService
                .findKeywordsList(pages, limit, sortBy, direction, code);

        return RestResponse.ok(dtos);
    }


    @RolesAllowed("USER")
    @DELETE
    @Path("{code}")
    public RestResponse<Void> deleteKeyword(@PathParam("code") String code) {
        this.keywordService.deleteKeyword(code);
        return RestResponse.ok();
    }

}
