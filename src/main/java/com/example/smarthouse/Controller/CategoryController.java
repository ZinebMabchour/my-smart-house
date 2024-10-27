package com.example.smarthouse.Controller;

import com.example.smarthouse.bean.Appareil;
import com.example.smarthouse.bean.Category;
import com.example.smarthouse.service.CategoryService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping()
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        Category savedCategory = categoryService.save(category);
        return ResponseEntity.ok(savedCategory);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
        Optional<Category> category = categoryService.findById(id);
        return category.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoryById(@PathVariable Long id) {
        if (categoryService.findById(id).isPresent()) {
            categoryService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{categoryId}/appareils-on")
    public List<Appareil> getAppareilsOnByCategory(@PathVariable Long categoryId) {
        return categoryService.selectAppareilsOnByCategory(categoryId);
    }

    @GetMapping("/{categoryId}/appareils-off")
    public List<Appareil> getAppareilsOffByCategory(@PathVariable Long categoryId) {
        return categoryService.selectAppareilsOffByCategory(categoryId);
    }
}

