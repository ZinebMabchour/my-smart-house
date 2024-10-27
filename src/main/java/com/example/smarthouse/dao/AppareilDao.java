package com.example.smarthouse.dao;

import com.example.smarthouse.bean.Appareil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppareilDao extends JpaRepository<Appareil, Long> {

}