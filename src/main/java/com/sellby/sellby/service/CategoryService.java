package com.sellby.sellby.service;

import com.sellby.sellby.model.entity.Category;
import com.sellby.sellby.model.entity.Comment;
import com.sellby.sellby.repository.CategoryRepository;
import com.sellby.sellby.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public Category getCategoryById(int id){
        Optional<Category> category = categoryRepository.findById((long) id);
        return category.orElse(null);
    }
}
