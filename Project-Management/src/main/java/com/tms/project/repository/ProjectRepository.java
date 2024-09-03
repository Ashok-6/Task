package com.tms.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tms.project.entity.ProjectEntity;

//Repository interface for project entity, extending JpaRepository for basic CRUD operations.
@Repository
public interface ProjectRepository extends JpaRepository<ProjectEntity, Long> 
{

}
