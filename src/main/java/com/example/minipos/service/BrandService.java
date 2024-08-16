package com.example.minipos.service;

import com.example.minipos.entity.Brand;
import java.util.List;

public interface BrandService {

    Brand saveData(Brand brand);

    Brand getBrandById(Long id);

    Brand update(Long id, Brand brand);

    List<Brand> getAllBrands();

    void deleteById(Long id);
}
