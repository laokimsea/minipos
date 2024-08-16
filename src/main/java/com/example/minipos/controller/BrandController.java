package com.example.minipos.controller;
import com.example.minipos.entity.Brand;
import com.example.minipos.mapper.BrandMapper;
import com.example.minipos.request.BrandRequest;
import com.example.minipos.response.BrandResponse;
import com.example.minipos.service.BrandService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("brands")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @Autowired
    private BrandMapper itemBrandMapper;

    @PostMapping
    public ResponseEntity<BrandResponse> saveData(@Valid @RequestBody BrandRequest request) {
        Brand brand = itemBrandMapper.toEntity(request);
        Brand saveData = brandService.saveData(brand);

        BrandResponse response = itemBrandMapper.toDto(saveData);
        return ResponseEntity.ok(response);
    }

    @GetMapping("{id}")
    public ResponseEntity<BrandResponse> getData(@PathVariable Long id) {
        Brand getData = brandService.getBrandById(id);
        BrandResponse response = itemBrandMapper.toDto(getData);
        return ResponseEntity.ok(response);
    }

    @PutMapping("{id}")
    public ResponseEntity<BrandResponse> updateData(@PathVariable Long id, @Valid @RequestBody BrandRequest request) {
        Brand brand = itemBrandMapper.toEntity(request);
        Brand update = brandService.update(id, brand);
        BrandResponse response = itemBrandMapper.toDto(update);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<BrandResponse>> getAllData() {
       List<BrandResponse> response = brandService.getAllBrands();
       return ResponseEntity.ok(response);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<BrandResponse> deleteData(@PathVariable Long id) {
        Brand deleteById = brandService.deleteById(id);
        BrandResponse response = itemBrandMapper.toDto(deleteById);
        return ResponseEntity.ok(response);
    }
}
