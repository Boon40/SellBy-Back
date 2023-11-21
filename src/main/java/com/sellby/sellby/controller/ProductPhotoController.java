package com.sellby.sellby.controller;

import com.sellby.sellby.model.request.ProductPhotoRequest;
import com.sellby.sellby.model.request.ProductRequest;
import com.sellby.sellby.model.response.ProductPhotoResponse;
import com.sellby.sellby.model.response.ProductResponse;
import com.sellby.sellby.service.ProductPhotoService;
import com.sellby.sellby.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public ResponseEntity<ProductPhotoResponse> addProductPhoto(
            @RequestBody @Valid ProductPhotoRequest request
    ) {
        try {
            return ResponseEntity.ok(productPhotoService.addProductPhoto(request));
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
