package com.sellby.sellby.mapper;

import com.sellby.sellby.model.entity.*;
import com.sellby.sellby.model.response.ProductResponse;
import com.sellby.sellby.service.CategoryService;
import com.sellby.sellby.service.StateService;
import com.sellby.sellby.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import com.sellby.sellby.model.request.ProductRequest;

import java.time.LocalDate;


@Component
@RequiredArgsConstructor
public class ProductMapper {

    private final UserMapper userMapper;
    private final StateMapper stateMapper;
    private final CategoryMapper categoryMapper;
    public ProductResponse toResponse(Product product){
        return new ProductResponse(
            product.getId(),
            product.getName(),
            product.getDescription(),
            product.getPrice(),
            userMapper.toResponse(product.getSeller()),
            stateMapper.toResponse(product.getState()),
            categoryMapper.toResponse(product.getCategory()),
            product.getIsBuyerPayingDelivery(),
            product.getCreatedDate()
        );
    }

    public Product toEntity(ProductRequest request, User seller, State state, Category category){
        return Product.builder()
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .seller(seller)
                .state(state)
                .category(category)
                .isBuyerPayingDelivery(request.GetIsBuyerPayingDelivery())
                .createdDate(LocalDate.now())
                .build();
    }
}

