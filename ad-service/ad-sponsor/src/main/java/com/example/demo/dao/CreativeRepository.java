package com.example.demo.dao;

import com.example.demo.entity.Creative;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CreativeRepository extends JpaRepository<Creative, Long> {

    @Query(value = "SELECT c FROM Creative c WHERE c.name LIKE :name")
    Page<Creative> findPageByName(String name, Pageable pageable);
}
