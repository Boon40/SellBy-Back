package com.sellby.sellby.model.response;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductPhotoResponse {
    private final int id;
    private final String path;
    private final ProductResponse product;
}
