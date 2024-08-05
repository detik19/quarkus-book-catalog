package com.subrutin.lingkar.catalog.util;

import java.util.List;

import com.subrutin.lingkar.catalog.dto.ResultPageResponseDTO;

import io.quarkus.panache.common.Sort;

public class PaginationUtil {
    public static <T> ResultPageResponseDTO<T> createResultPageDTO(List<T> dtos, Long totalElements, Integer pages){
		ResultPageResponseDTO<T> result = new ResultPageResponseDTO<T>();
		result.setPages(pages);
		result.setElements(totalElements);
		result.setResult(dtos);
		return result;
	}
	
	public static Sort.Direction getSortBy(String sortBy){
		if(sortBy.equalsIgnoreCase("asc")) {
			return Sort.Direction.Ascending;
		}else {
			return Sort.Direction.Descending;
		}
	}

}
