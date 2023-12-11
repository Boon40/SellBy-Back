package com.sellby.sellby.mapper;

import com.sellby.sellby.model.entity.Product;
import com.sellby.sellby.model.entity.ProductPhoto;
import com.sellby.sellby.model.entity.State;
import com.sellby.sellby.model.request.ProductPhotoRequest;
import com.sellby.sellby.model.request.StateRequest;
import com.sellby.sellby.model.response.ProductPhotoResponse;
import com.sellby.sellby.model.response.StateResponse;
import com.sellby.sellby.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductPhotoMapper {
    private final ProductMapper productMapper;
    public ProductPhotoResponse toResponse(ProductPhoto productPhoto){
        return new ProductPhotoResponse(
                productPhoto.getId(),
                productPhoto.getPath(),
                productMapper.toResponse(productPhoto.getProduct())
        );
    }

    public ProductPhoto toEntity(ProductPhotoRequest request, Product product) throws Exception{
        return ProductPhoto.builder()
                .path(request.getPath())
                .product(product)
                .build();
    }
}
