package com.prueba.core.services;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.core.models.UsuarioC;
import com.prueba.core.repository.*;

//CREAMOS UNA CLASE QUE IMPLEMENTE LA INTERFAZ
@Service
public class UsuarioServiceImpl implements UsuarioService {
	//INJECTAMOS EL REPOSITORIO DE USUARIO USANDO LA ANOTACION AUTOWIRED
    @Autowired
    private  UsuarioRepository usuarioRepository;
//	@Override
//	public List<UsuarioC> obtenerUsuarios() {
//		//aca retornamos la lista de usuarios
//		return usuarioRepository.findAll();
//		//el metodo findall basicamente retorna una lista con los usuarios al controlador
//	}
	@Override
	public List<UsuarioC> buscarporrol(int id_rol) {
		//aca retornamos la lista de usuarios
		return usuarioRepository.findByRol_id(id_rol);
		//el metodo findall basicamente retorna una lista con los usuarios al controlador
	}
@Override
public void guardarUsuario(UsuarioC usuarioC) {
	this.usuarioRepository.save(usuarioC);
	
}
@Override
public UsuarioC obtenerUsuaruioPorID(long id) {
	Optional<UsuarioC> optional = usuarioRepository.findById(id);
	UsuarioC usuarioC = null;
	if (optional.isPresent()) {
		usuarioC = optional.get();
	}else {
		throw new RuntimeException("Usuario no encontrado");
	}
	
	return usuarioC;
	
}
@Override
public void eliminarUsuariosPorId(long id) {
	this.usuarioRepository.deleteById(id);
}


	

}
