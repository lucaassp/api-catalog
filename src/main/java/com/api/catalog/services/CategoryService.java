package com.api.catalog.services;

import com.api.catalog.domains.Category;
import com.api.catalog.dto.CategoryDTO;
import com.api.catalog.repositories.CategoryRepository;
import com.api.catalog.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    @Transactional(readOnly = true)
    public List<CategoryDTO> findAll() {
        List<Category> listCategories = repository.findAll();
        return listCategories.stream().map(e -> new CategoryDTO(e)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public CategoryDTO findById(Long id) {
        Optional<Category> obj = repository.findById(id);
        Category entity = obj.orElseThrow(() -> new ResourceNotFoundException(id));
        return new CategoryDTO(entity);
    }
}