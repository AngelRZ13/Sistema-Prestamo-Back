package com.example.demo.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUsuario;
	private String nombre;
	private String apellido;
	private Integer dni;
	private Integer telefono;
	private String usuario;
	private String contrasena;
	private String direccion;
	
	
	@Column(name = "idUsuarioSuperior", nullable = true)
	private Integer usuarioSuperior;
	
	@Column(name = "idUsuarioRegistro" , nullable = true)
	private Integer usuarioRegistro;
	
	@Column(name = "idUsuarioActualiza" , nullable = true)
	private Integer usuarioActualiza;

	@OneToMany(mappedBy = "usuarioPrestatario")
	private List<SolicitudPrestamo> solicitudes; // Relación con SolicitudPrestamo
	
	
	public String getNombreCompleto() {
		if (nombre != null && apellido != null) {
			return apellido.concat(" ").concat(nombre);	
		}else {
			return ""; 
		}
	}
}
