package com.example.minipos.service.impl;

import com.example.minipos.entity.Brand;
import com.example.minipos.exception.ResourceNotFoundException;
import com.example.minipos.repository.BrandRepository;
import com.example.minipos.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandRepository brandRepository;

    @Override
    public Brand saveData(Brand brand) {
        return brandRepository.save(brand);
    }

    @Override
    public Brand getBrandById(Long id) {
        return brandRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Brand", id));
    }

    @Override
    public Brand update(Long id, Brand brand) {
        Brand dataUpdate = getBrandById(id);
        dataUpdate.setName(brand.getName());
        return brandRepository.save(dataUpdate);
    }

    @Override
    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        Brand brand = getBrandById(id);
        brandRepository.delete(brand);
    }
}
