package com.api.catalog.resources;

import com.api.catalog.domains.Category;
import com.api.catalog.dto.CategoryDTO;
import com.api.catalog.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController // Web resource that is implemented by a Rest controller
@RequestMapping(value = "/categories") // Resource name
public class CategoryResource {

    @Autowired
    private CategoryService service;

    @GetMapping // Responds to a Get resource from http
    public ResponseEntity<List<CategoryDTO>> findAll() {
        List<CategoryDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id){
        Category obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}
