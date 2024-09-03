package com.tms.user.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tms.user.entity.UserEntity;

//Repository interface for User entity, extending JpaRepository for basic CRUD operations.
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> 
{
	List<UserEntity> findAllByProjectId(Long projectId);
    Optional<UserEntity> findByEmail(String email);
}
