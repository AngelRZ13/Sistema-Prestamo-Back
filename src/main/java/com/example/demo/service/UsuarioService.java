package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Usuario;
import com.example.demo.entity.Rol;

public interface UsuarioService {
	
	public abstract List<Rol> traerRolesDeUsuario(int idUsuario);
	
	public abstract Usuario registrarUsuario(Usuario u);
	
	public abstract List<Usuario> listaUsuarios();

	public abstract Usuario findByUsuario(String usuario);
	
	public abstract Usuario registrarJefe(Usuario u);
	
	public abstract Usuario registrarPrestamista(Usuario u);
	
	public abstract Usuario registrarPrestatario(Usuario u);
	
	public abstract List<Usuario> listaPrestamistariosDeUnPrestamista(int idUsuario);
	
	
	
	public abstract Usuario obtenerPorId(int idUsuario); // Añade esta línea

}	
