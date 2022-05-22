package com.prueba.core.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import net.bytebuddy.implementation.ToStringMethod;

@Entity
@Table(name = "usuario")
public class UsuarioC {
	
@Id
@Column (name = "RUT")
private String id;

@OneToOne
@JoinColumn(name="TURNO_ID")
private Turno idturno;

@OneToOne
@JoinColumn(name="ROL_ID")
private Rol rol;

@Column(name ="NOMBRE")
private String nombre;

@Column(name ="APELLIDO")
private String apellido;

@Column(name ="CORREO")
private String email;

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public Turno getIdturno() {
	return idturno;
}

public void setIdturno(Turno idturno) {
	this.idturno = idturno;
}

public Rol getRol() {
	return rol;
}

public void seteRol(Rol rol) {
	this.rol = rol;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public String getApellido() {
	return apellido;
}

public void setApellido(String apellido) {
	this.apellido = apellido;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public UsuarioC(String id, Turno idturno, Rol rol, String nombre, String apellido, String email) {
	
	this.id = id;
	this.idturno = idturno;
	this.rol = rol;
	this.nombre = nombre;
	this.apellido = apellido;
	this.email = email;
}

public UsuarioC() {

}



}
