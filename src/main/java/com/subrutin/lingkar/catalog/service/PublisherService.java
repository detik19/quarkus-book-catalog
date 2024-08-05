package com.subrutin.lingkar.catalog.service;

import com.subrutin.lingkar.catalog.dto.PublisherListDTO;
import com.subrutin.lingkar.catalog.dto.ResultPageResponseDTO;

public interface PublisherService {
    
	public ResultPageResponseDTO<PublisherListDTO> findPublisherList(Integer pages, Integer limit,
			String sortBy, String direction, String publisherName);

}
