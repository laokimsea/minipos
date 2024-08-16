package com.example.minipos.mapper;

import com.example.minipos.dto.BrandDTO;
import com.example.minipos.entity.Brand;

public class BrandMapper {
    public static Brand toBrand(BrandDTO dto) {
        Brand brand = new Brand();
        brand.setName(dto.getName());
        return brand;
    }

    public static BrandDTO toBrandDTO(Brand entity) {
        BrandDTO dto = new BrandDTO();
        dto.setName(entity.getName());
        dto.setId(entity.getId());
        return dto;
    }
}
