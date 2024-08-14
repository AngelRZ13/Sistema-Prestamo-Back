package com.example.demo.repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.SolicitudPrestamo;

public interface SolicitudPrestamoRepository extends JpaRepository<SolicitudPrestamo, Integer>{
	
	@Query("select s from SolicitudPrestamo s join s.usuarioPrestatario u where u.nombre = ?1 and s.fechaInicioPrestamo >= ?2 and s.fechaFinPrestamo <= ?3")
    List<SolicitudPrestamo> consultaCompleja(String nombre, LocalDate fechaInicioPrestamo, LocalDate fechaFinPrestamo);
	
	
}
