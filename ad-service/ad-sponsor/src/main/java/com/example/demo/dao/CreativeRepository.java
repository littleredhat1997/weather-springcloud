package com.example.demo.dao;

import com.example.demo.entity.Unit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UnitRepository extends JpaRepository<Unit, Long> {

    List<Unit> findByPlanId(Long planId);
}
