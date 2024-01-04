package com.sellby.sellby.service;

import com.sellby.sellby.mapper.ProductMapper;
import com.sellby.sellby.mapper.ProductPhotoMapper;
import com.sellby.sellby.model.entity.Product;
import com.sellby.sellby.model.entity.ProductPhoto;
import com.sellby.sellby.model.request.ProductPhotoRequest;
import com.sellby.sellby.model.request.ProductRequest;
import com.sellby.sellby.model.response.ProductPhotoResponse;
import com.sellby.sellby.model.response.ProductResponse;
import com.sellby.sellby.repository.ProductPhotoRepository;
import com.sellby.sellby.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductPhotoService {
    private final ProductPhotoRepository productPhotoRepository;
    private final ProductRepository productRepository;
    private final ProductPhotoMapper productPhotoMapper;
    private final ProductService productService;

    public List<ProductPhotoResponse> getAllProductPhotos(){
        return((List<ProductPhoto>) productPhotoRepository.findAll())
                .stream()
                .map(productPhotoMapper::toResponse)
                .toList();
    }

    public List<ProductPhotoResponse> getProductPhotos(int id){
        return((List<ProductPhoto>) productPhotoRepository.getProductPhotos(productRepository.findById((long)id).orElseThrow()))
                .stream()
                .map(productPhotoMapper::toResponse)
                .toList();
    }

    public ProductPhoto getProductPhotoById(int id){
        Optional<ProductPhoto> productPhoto = productPhotoRepository.findById((long) id);
        return productPhoto.orElseThrow();
    }

    public ProductPhotoResponse getProductPhotoResponseById(int id) throws Exception{
        Optional<ProductPhoto> productPhoto = productPhotoRepository.findById((long) id);
        return productPhotoMapper.toResponse(productPhoto.orElseThrow());
    }

    public ProductPhotoResponse addProductPhoto(ProductPhotoRequest request) throws Exception{
        final var productPhoto = productPhotoMapper.toEntity(request, productService.getProductEntityById(request.getProductId()));
        final var savedProductPhoto = productPhotoRepository.save(productPhoto);

        return productPhotoMapper.toResponse(savedProductPhoto);
    }

    public void addProductPhoto(MultipartFile photo, int id) throws Exception{
        String uploadDir = "src/main/resources/static/images";
        String type = getFileType(photo.getOriginalFilename());
        String filename = generateUniqueFilename(id, type);
        Path path = Paths.get(uploadDir + "/" + filename);
        Files.copy(photo.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
        ProductPhotoRequest product = new ProductPhotoRequest(path.toString(), id);
        this.addProductPhoto(product);
    }

    private String generateUniqueFilename(int id, String type){
        String date = java.time.LocalDateTime.now().toString().replace(":", "-").replace(".", "-");
        String filename = id + "-" + date + type;
        return filename;
    }
    private String getFileType(String filename){
        int lastIndex = filename.lastIndexOf('.');
        String type = "";
        if (lastIndex >= 0 && lastIndex < filename.length() - 1){
            type = filename.substring(lastIndex);
        }
        return type;
    }

    public void deleteProductPhoto(int id){
        productPhotoRepository.deleteById((long)id);
    }
}
