package com.example.minipos.controller;

import com.example.minipos.dto.BrandDTO;
import com.example.minipos.entity.Brand;
import com.example.minipos.mapper.BrandMapper;
import com.example.minipos.response.ResponseHandler;
import com.example.minipos.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("brands")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @PostMapping
    public ResponseEntity<?> saveData(@RequestBody BrandDTO dto) {
        Brand brand = BrandMapper.toBrand(dto);
        Brand saveData = brandService.saveData(brand);

        BrandDTO brandDTO = BrandMapper.toBrandDTO(saveData);
        return ResponseEntity.ok(brandDTO);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getData(@PathVariable Long id) {
        Brand getData = brandService.getBrandById(id);
        BrandDTO brandDTO = BrandMapper.toBrandDTO(getData);
        return ResponseEntity.ok(brandDTO);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateData(@PathVariable Long id, @RequestBody BrandDTO dto) {
        Brand brand = BrandMapper.toBrand(dto);
        Brand update = brandService.update(id, brand);
        BrandDTO brandDTO = BrandMapper.toBrandDTO(update);
        return ResponseEntity.ok(brandDTO);
    }

    @GetMapping
    public ResponseEntity<?> getAllData() {
       List<Brand> listAll = brandService.getAllBrands();
       return ResponseEntity.ok(listAll);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteData(@PathVariable Long id) {
        brandService.deleteById(id);
        ResponseHandler res = new ResponseHandler();
        res.setStatus(true);
        res.setMessage("Delete complete");
        return ResponseEntity.ok(res);
    }
}
