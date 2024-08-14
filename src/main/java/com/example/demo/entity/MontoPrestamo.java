package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "monto_prestamo")
public class MontoPrestamo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMonto_prestamo;
	private int capital;
	private int dias;
	private double monto;
	private int estado;
	
	@Column(name = "idUsuarioRegistro" , nullable = true)
	private Integer usuarioRegistro;
	
	@Column(name = "idUsuarioActualizacion" , nullable = true)
	private Integer usuarioActualiza;
}
