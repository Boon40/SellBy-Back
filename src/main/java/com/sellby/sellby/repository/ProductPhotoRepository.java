package com.sellby.sellby.repository;

import com.sellby.sellby.model.entity.Product;
import com.sellby.sellby.model.entity.ProductPhoto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductPhotoRepository extends JpaRepository<ProductPhoto, Long> {
    @Query("SELECT pp FROM ProductPhoto pp WHERE pp.product = ?1")
    List<ProductPhoto> getProductPhotos(Product product);
}
