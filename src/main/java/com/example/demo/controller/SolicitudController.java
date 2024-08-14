package com.example.demo.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Estados;
import com.example.demo.entity.MontoPrestamo;
import com.example.demo.entity.SolicitudPrestamo;
import com.example.demo.service.MontoPrestamoService;
import com.example.demo.service.SolicitudPrestamoService;
import com.example.demo.util.AppSettings;

@RestController
@RequestMapping("/url/solicitud")
@CrossOrigin(AppSettings.URL_CROSS_ORIGIN)
public class SolicitudController {
	
	@Autowired
	private MontoPrestamoService montoService;
	
	@Autowired
	private SolicitudPrestamoService solicitudService;
	
	@GetMapping("/listaMontos")
	public ResponseEntity<List<MontoPrestamo>> lista(){
		List<MontoPrestamo> lstSalida = montoService.findAll();
		return ResponseEntity.ok(lstSalida);
	}
	
	@PostMapping("/registraSolicitud")
	@ResponseBody
	public ResponseEntity<?> insertaReserva(@RequestBody SolicitudPrestamo obj) {
		Map<String, Object> salida = new HashMap<>();
	    try {

	        // Inicializar y asignar valores a EstadoSolcitud
	        Estados estadoSolicitud = new Estados();
	        estadoSolicitud.setIdEstados(1);
	        obj.setEstadoSolicitud(estadoSolicitud);


	        // Registrar solicitud
	        SolicitudPrestamo objSalida = solicitudService.registrarSolicitud(obj);
	        if (objSalida == null) {
	            salida.put("mensaje", AppSettings.MENSAJE_REG_ERROR);
	        } else {
	            salida.put("mensaje", AppSettings.MENSAJE_REG_EXITOSO + " Ejemplo de ID ==> " + objSalida.getIdSolicitud() + ".");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        salida.put("mensaje", AppSettings.MENSAJE_REG_ERROR);
	    }
	    return ResponseEntity.ok(salida);
	}
	
	@GetMapping("/consultaCompleja")
	public ResponseEntity<List<SolicitudPrestamo>> consultaCompleja(
		    @RequestParam(required = false) String nombre,
		    @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fechaInicio,
		    @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fechaFin) {
		    List<SolicitudPrestamo> result = solicitudService.consultaCompleja(nombre, fechaInicio, fechaFin);
		    return ResponseEntity.ok(result);
		}
	
	
	@PutMapping("/{idSolicitud}/estado/{nuevoEstadoId}")
    public void actualizarEstado(@PathVariable int idSolicitud, @PathVariable int nuevoEstadoId) {
        solicitudService.actualizarEstado(idSolicitud, nuevoEstadoId);
    }
	
	
	
	
	
	
}
