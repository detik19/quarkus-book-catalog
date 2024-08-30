package com.subrutin.lingkar.catalog.util;

import java.util.List;

import org.springframework.data.domain.Sort;

import com.subrutin.lingkar.catalog.dto.ResultPageResponseDTO;

import io.quarkus.panache.common.Sort.Direction;


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
			return Sort.Direction.ASC;
		}else {
			return Sort.Direction.DESC;
		}
	}

	public static Direction getDirection(String direction){
		if(direction.equalsIgnoreCase("asc")) {
			return Direction.Ascending;
		}else {
			return Direction.Descending;
		}
	}

}
