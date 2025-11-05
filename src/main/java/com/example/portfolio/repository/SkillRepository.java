package com.example.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.portfolio.model.Skill;

public interface SkillRepository extends JpaRepository<Skill, Long> {}
