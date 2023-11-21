package com.sellby.sellby.repository;

import com.sellby.sellby.model.entity.Category;
import com.sellby.sellby.model.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
