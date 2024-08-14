package com.example.demo.entity;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "solicitud_prestamo")
public class SolicitudPrestamo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSolicitud;
	private double capital;
	private double montoPagar;
	
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd" , timezone = "America/Lima")
	private Date fechaInicioPrestamo;
	
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd" , timezone = "America/Lima")
	private Date fechaFinPrestamo;
	
	private Integer dias; 
	private double pagoDiario;
	
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idEstadoSolcitud", nullable = true)
	private Estados estadoSolicitud;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idUsuarioPrestatario", nullable = true) // Actualiza el nombre de la columna aquí
	private Usuario usuarioPrestatario; // Relación con Usuario
	
	@Column(name = "idUsuarioRegistro" , nullable = true)
	private Integer usuarioRegistro;

	@Column(name = "idUsuarioActualizacion" , nullable = true)
	private Integer usuarioActualizacion;
	
}
