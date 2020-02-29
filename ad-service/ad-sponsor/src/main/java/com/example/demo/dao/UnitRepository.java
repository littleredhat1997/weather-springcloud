package com.example.demo.dao;

import com.example.demo.entity.Unit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UnitRepository extends JpaRepository<Unit, Long> {

    @Query(value = "SELECT u FROM Unit u WHERE u.name LIKE :name")
    Page<Unit> findPageByName(String name, Pageable pageable);
}
