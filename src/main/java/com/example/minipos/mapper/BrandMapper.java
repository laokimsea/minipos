package com.example.minipos.mapper;

import com.example.minipos.entity.Brand;
import com.example.minipos.request.BrandRequest;
import com.example.minipos.response.BrandResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BrandMapper {

    Brand toEntity(BrandRequest request);

    BrandResponse toDto(Brand entity);
}
