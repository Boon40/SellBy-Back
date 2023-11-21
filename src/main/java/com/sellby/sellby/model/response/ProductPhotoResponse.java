package com.sellby.sellby.model.response;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductPhotoResponse {
    private int id;
    private String path;
    private ProductResponse product;
}
