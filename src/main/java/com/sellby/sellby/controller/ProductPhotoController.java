package com.sellby.sellby.controller;

import com.sellby.sellby.model.request.ProductPhotoRequest;
import com.sellby.sellby.model.request.ProductRequest;
import com.sellby.sellby.model.response.ProductPhotoResponse;
import com.sellby.sellby.model.response.ProductResponse;
import com.sellby.sellby.service.ProductPhotoService;
import com.sellby.sellby.service.ProductService;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@RestController
@RequestMapping("/api/v1/productPhotos")
@RequiredArgsConstructor
public class ProductPhotoController {
    private final ProductPhotoService productPhotoService;

    @GetMapping
    public ResponseEntity<List<ProductPhotoResponse>> getAllProductPhotos() {
        return ResponseEntity.ok(productPhotoService.getAllProductPhotos());
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<List<ProductPhotoResponse>> getProductPhotos(@PathVariable String id) {
        return ResponseEntity.ok(productPhotoService.getProductPhotos(Integer.valueOf(id)));
    }

    @PostMapping
    public ResponseEntity<ProductPhotoResponse> addProductPhotos(
            @RequestParam("image") MultipartFile photo,
            @RequestParam("id") int id
    ) {
        try {
            if (photo.isEmpty()){
                return ResponseEntity.badRequest().build();
            }
            productPhotoService.addProductPhoto(photo, id);
            return ResponseEntity.ok(productPhotoService.getProductPhotoResponseById(Integer.valueOf(id)));
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductPhoto(@PathVariable String id) {
        productPhotoService.deleteProductPhoto(Integer.valueOf(id));
        return ResponseEntity.ok().build();
    }
}
