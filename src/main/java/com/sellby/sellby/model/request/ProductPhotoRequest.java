package com.sellby.sellby.model.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductPhotoRequest {
    @NotBlank(message = "Path is required")
    private String path;

    @NotNull(message = "Product is required")
    private int productId;
}
