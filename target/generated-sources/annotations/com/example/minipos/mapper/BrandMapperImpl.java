package com.example.minipos.mapper;

import com.example.minipos.entity.Brand;
import com.example.minipos.request.BrandRequest;
import com.example.minipos.response.BrandResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-16T11:06:14+0700",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class BrandMapperImpl implements BrandMapper {

    @Override
    public Brand toEntity(BrandRequest request) {
        if ( request == null ) {
            return null;
        }

        Brand brand = new Brand();

        brand.setName( request.getName() );

        return brand;
    }

    @Override
    public BrandResponse toDto(Brand entity) {
        if ( entity == null ) {
            return null;
        }

        BrandResponse brandResponse = new BrandResponse();

        brandResponse.setId( entity.getId() );
        brandResponse.setName( entity.getName() );

        return brandResponse;
    }
}
