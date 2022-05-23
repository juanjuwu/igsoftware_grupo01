package com.prueba.core.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.prueba.core.models.UsuarioC;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioC, Long> {

	
	List<UsuarioC> findByRol_id(int id_rol);
	}
//AHORA PODEMOS OBTENER LAS OPERACIONES DE LA BASE DE DATOS PARA LA ENTIDAD USUARIOC AL USAR JPA REPOSITORY
