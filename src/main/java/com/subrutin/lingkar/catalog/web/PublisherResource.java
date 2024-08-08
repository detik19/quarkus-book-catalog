package com.subrutin.lingkar.catalog.web;

import org.jboss.resteasy.reactive.RestQuery;
import com.subrutin.lingkar.catalog.dto.PublisherListDTO;
import com.subrutin.lingkar.catalog.dto.ResultPageResponseDTO;
import com.subrutin.lingkar.catalog.service.PublisherService;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/v1/publisher")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PublisherResource {

    private final PublisherService publisherService;

    public PublisherResource(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @GET
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ResultPageResponseDTO<PublisherListDTO> findPublisherList(
        @RestQuery(value = "pages") @DefaultValue(value = "0") Integer pages,
        @RestQuery(value="limit") @DefaultValue(value = "10") Integer limit,
        @RestQuery(value = "sortBy") @DefaultValue(value = "id") String sortBy,
        @RestQuery(value = "direction") @DefaultValue(value = "asc") String direction, 
        @RestQuery(value = "publisherName") String publisherName){
            ResultPageResponseDTO<PublisherListDTO> restresponse = publisherService.findPublisherList(pages, limit, sortBy, direction, publisherName);
            return restresponse;
        }

}
