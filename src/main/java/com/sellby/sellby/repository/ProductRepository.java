package com.sellby.sellby.repository;

import com.sellby.sellby.model.entity.Product;
import com.sellby.sellby.model.entity.ProductPhoto;
import com.sellby.sellby.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
