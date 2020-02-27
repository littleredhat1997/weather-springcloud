package com.example.demo.dao;

import com.example.demo.entity.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

public class PlanRespority  extends JpaRepository<Plan, Long> {
    Plan findByUserName(String userName);
    User findByUserNameOrEmail(String username, String email);
}
