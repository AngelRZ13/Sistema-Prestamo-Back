package com.example.demo.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Estados;
import com.example.demo.entity.SolicitudPrestamo;
import com.example.demo.repository.EstadosRepository;
import com.example.demo.repository.SolicitudPrestamoRepository;

@Service
public class SolicitudPrestamoServiceImpl implements SolicitudPrestamoService{
	
	@Autowired
	private SolicitudPrestamoRepository repo;
	@Autowired
	private EstadosRepository estadosRepo;
	
	@Override
	public SolicitudPrestamo registrarSolicitud(SolicitudPrestamo s) {
		return repo.save(s);
	}

	@Override
	public List<SolicitudPrestamo> consultaCompleja(String nombre, LocalDate fechaInicioPrestamo, LocalDate fechaFinPrestamo) {
		return repo.consultaCompleja(nombre, fechaInicioPrestamo, fechaFinPrestamo);
	}

	@Override
	public void actualizarEstado(int idSolicitud, int nuevoEstadoId) {
		 SolicitudPrestamo solicitud = repo.findById(idSolicitud)
                 .orElseThrow(() -> new RuntimeException("Solicitud no encontrada"));
		  Estados estado = estadosRepo.findById(nuevoEstadoId)
                  .orElseThrow(() -> new RuntimeException("Estado no encontrado"));

	        // Actualizar el estado
	        solicitud.setEstadoSolicitud(estado);

	        // Guardar los cambios
	        repo.save(solicitud);
		
	}
	
	

}
