package com.sellby.sellby.model.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
public class ProductPhotoResponse {
    private final int id;
    private final String path;
    private final ProductResponse product;
}
