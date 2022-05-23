package com.prueba.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prueba.core.models.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
	
	
}

