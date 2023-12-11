package com.sellby.sellby.model.response;

import com.sellby.sellby.model.enums.CategoryEnum;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class CategoryResponse {
    private final int id;
    private final CategoryEnum category;
    private final String categoryString;
}
