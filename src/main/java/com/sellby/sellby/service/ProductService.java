package com.sellby.sellby.service;

import com.sellby.sellby.mapper.ProductMapper;
import com.sellby.sellby.model.entity.Comment;
import com.sellby.sellby.model.entity.Product;
import com.sellby.sellby.model.request.ProductRequest;
import com.sellby.sellby.model.response.ProductResponse;
import com.sellby.sellby.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public List<ProductResponse> getAllProducts(){
        return((List<Product>) productRepository.findAll())
                .stream()
                .map(productMapper::toResponse)
                .toList();
    }

    public ProductResponse getProductById(int id) throws Exception{
        Optional<Product> product = productRepository.findById((long) id);
        return productMapper.toResponse(product.orElseThrow());
    }

    public Product getProductEntityById(int id){
        Optional<Product> product = productRepository.findById((long) id);
        return product.orElse(null);
    }

    public ProductResponse addProduct(ProductRequest request){
        final var product = productMapper.toEntity(request);
        final var savedProduct = productRepository.save(product);

        return productMapper.toResponse(savedProduct);
    }

    public void deleteProduct(int id){
        productRepository.deleteById((long)id);
    }
}
