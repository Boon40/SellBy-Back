package com.sellby.sellby.service;

import com.sellby.sellby.mapper.ProductMapper;
import com.sellby.sellby.mapper.ProductPhotoMapper;
import com.sellby.sellby.model.entity.Product;
import com.sellby.sellby.model.entity.ProductPhoto;
import com.sellby.sellby.model.request.ProductPhotoRequest;
import com.sellby.sellby.model.request.ProductRequest;
import com.sellby.sellby.model.response.ProductPhotoResponse;
import com.sellby.sellby.model.response.ProductResponse;
import com.sellby.sellby.repository.ProductPhotoRepository;
import com.sellby.sellby.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductPhotoService {
    private final ProductPhotoRepository productPhotoRepository;
    private final ProductRepository productRepository;
    private final ProductPhotoMapper productPhotoMapper;

    public List<ProductPhotoResponse> getAllProductPhotos(){
        return((List<ProductPhoto>) productPhotoRepository.findAll())
                .stream()
                .map(productPhotoMapper::toResponse)
                .toList();
    }

    public List<ProductPhotoResponse> getProductPhotos(int id){
        return((List<ProductPhoto>) productPhotoRepository.getProductPhotos(productRepository.findById((long)id).orElseThrow()))
                .stream()
                .map(productPhotoMapper::toResponse)
                .toList();
    }

    public ProductPhoto getProductPhotoById(int id){
        Optional<ProductPhoto> productPhoto = productPhotoRepository.findById((long) id);
        return productPhoto.orElse(null);
    }

    public ProductPhotoResponse addProductPhoto(ProductPhotoRequest request) throws Exception{
        final var productPhoto = productPhotoMapper.toEntity(request);
        final var savedProductPhoto = productPhotoRepository.save(productPhoto);

        return productPhotoMapper.toResponse(savedProductPhoto);
    }

    public void deleteProductPhoto(int id){
        productPhotoRepository.deleteById((long)id);
    }
}
