package com.example.demo.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import com.example.demo.entity.SolicitudPrestamo;

public interface SolicitudPrestamoService {

	public abstract SolicitudPrestamo registrarSolicitud(SolicitudPrestamo s);
	
	public List<SolicitudPrestamo> consultaCompleja(String nombre, LocalDate fechaInicioPrestamo, LocalDate fechaFinPrestamo );
	
    void actualizarEstado(int idSolicitud, int nuevoEstado);

}
