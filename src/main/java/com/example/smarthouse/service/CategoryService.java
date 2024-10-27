package com.example.smarthouse.service;


import com.example.smarthouse.bean.Appareil;
import com.example.smarthouse.bean.Category;
import com.example.smarthouse.dao.AppareilDao;
import com.example.smarthouse.dao.CategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;
@Service
public class CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private AppareilDao appareilDao;


    public Category save(Category category) {
        return categoryDao.save(category);
    }


    public Optional<Category> findById(Long id) {
        return categoryDao.findById(id);
    }

    public void deleteById(Long id) {
        categoryDao.deleteById(id);
    }

    public List<Appareil> selectAppareilsOnByCategory(Long categoryId) {
        Optional<Category> category = categoryDao.findById(categoryId);
        if (category.isPresent()) {
            return category.get().getAppareils().stream()
                    .filter(Appareil::getState) //appareils li sha3lin
                    .toList();
        }
        return null;
    }

    public List<Appareil> selectAppareilsOffByCategory(Long categoryId) {
        Optional<Category> category = categoryDao.findById(categoryId);
        if (category.isPresent()) {
            return category.get().getAppareils().stream()
                    .filter(appareil -> !appareil.getState())
                    .toList();
        }
        return null;
    }
}
