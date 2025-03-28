package com.example.smarthouse.bean;

import jakarta.persistence.*;

import java.util.Set;
import java.util.HashSet;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private Set<Appareil> appareils = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Appareil> getAppareils() {
        return appareils;
    }

    public void setAppareils(Set<Appareil> appareils) {
        this.appareils = appareils;
    }
}