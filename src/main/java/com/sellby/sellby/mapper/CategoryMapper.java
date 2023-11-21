package com.sellby.sellby.mapper;


import com.sellby.sellby.model.entity.Category;
import com.sellby.sellby.model.entity.State;
import com.sellby.sellby.model.request.CategoryRequest;
import com.sellby.sellby.model.request.StateRequest;
import com.sellby.sellby.model.response.CategoryResponse;
import com.sellby.sellby.model.response.StateResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CategoryMapper {

    public CategoryResponse toResponse(Category category){
        return new CategoryResponse(
                category.getId(),
                category.getCategory(),
                category.ToString()
        );
    }

    public Category toEntity(CategoryRequest request){
        return Category.builder()
                .category(request.getCategory())
                .build();
    }
}
