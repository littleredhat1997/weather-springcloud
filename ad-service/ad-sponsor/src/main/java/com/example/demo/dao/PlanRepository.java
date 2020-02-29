package com.example.demo.dao;

import com.example.demo.entity.Plan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PlanRepository extends JpaRepository<Plan, Long> {

    @Query(value = "SELECT p FROM Plan p WHERE p.name LIKE :name")
    Page<Plan> findPageByName(String name, Pageable pageable);
}
