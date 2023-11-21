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
    private final UserService userService;
    private final StateService stateService;
    private final CategoryService categoryService;
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

    public Product toEntity(ProductRequest request){
        return Product.builder()
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .seller(userService.getUserById(request.getSellerId()))
                .state(stateService.getStateEntityById(request.getStateId()))
                .category(categoryService.getCategoryById(request.getCategoryId()))
                .isBuyerPayingDelivery(request.GetIsBuyerPayingDelivery())
                .createdDate(LocalDate.now())
                .build();
    }
}

