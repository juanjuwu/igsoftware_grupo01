package com.prueba.core.services;

import java.util.List;



import com.prueba.core.models.UsuarioC;

public interface UsuarioService {
	
//List<UsuarioC> obtenerUsuarios();
 List<UsuarioC> buscarporrol(int id_rol);
 
void guardarUsuario(UsuarioC usuarioC);
UsuarioC obtenerUsuaruioPorID(long id);
void eliminarUsuariosPorId(long id);
}
