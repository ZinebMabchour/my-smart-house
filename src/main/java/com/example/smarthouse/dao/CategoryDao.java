package com.example.smarthouse.dao;

import com.example.smarthouse.bean.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryDao extends JpaRepository<Category, Long> {
    Optional<Category> findByName(String name);
}
