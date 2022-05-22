package com.prueba.core.repository;

import java.util.List;

import org.hibernate.mapping.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.prueba.core.models.UsuarioC;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioC, Integer> {

	
	List<UsuarioC> findByRol_id(int id_rol);

	}
//AHORA PODEMOS OBTENER LAS OPERACIONES DE LA BASE DE DATOS PARA LA ENTIDAD USUARIOC AL USAR JPA REPOSITORY
