package com.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.project.entities.SkillMatrix;

public interface SkillRepository extends JpaRepository<SkillMatrix, Integer> {
	
	

	SkillMatrix findByProject(String project);

}
