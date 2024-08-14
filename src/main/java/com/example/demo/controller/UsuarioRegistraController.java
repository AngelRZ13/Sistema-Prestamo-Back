package com.example.demo.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.UsuarioService;

import com.example.demo.util.AppSettings;
import com.example.demo.entity.Usuario;

@RestController
@RequestMapping("/url/usuario")
@CrossOrigin(AppSettings.URL_CROSS_ORIGIN)
public class UsuarioRegistraController {
	
	@Autowired
	private UsuarioService usuarioser;
	
	
	@PostMapping("/registrar")
	public  ResponseEntity<?> create(@RequestBody Usuario usuario) {
		

        HashMap<String, Object> salida = new HashMap<>();
        List<Usuario> lista = usuarioser.listaUsuarios();
        
        // Encrypting password
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String password = usuario.getContrasena();
        String encodedPassword = encoder.encode(password);
        usuario.setContrasena(encodedPassword);
        
        // Unique login and dni
        boolean usuarioExiste = false;
        boolean dniExiste = false;
        for (Usuario usuario1 : lista) {
            if (usuario.getUsuario().equals(usuario1.getUsuario())) {
                usuarioExiste = true;
                break;
            } else if (usuario.getDni().equals(usuario1.getDni())) {
                dniExiste = true;
                break;
            }
        }
        if (usuarioExiste) {
            salida.put("mensaje", "El usuario ya existe, ingrese otro");
        } else if (dniExiste) {
            salida.put("mensaje", "El DNI ya existe, ingrese otro");
        } else {
        	
            Usuario nuevo = usuarioser.registrarUsuario(usuario);
            if (nuevo == null) {
                salida.put("mensaje", "Error en el registro");
            } else {
                salida.put("mensaje", "Registro exitoso con el ID: " + nuevo.getIdUsuario());
            }
        }

        return ResponseEntity.ok(salida);
	    
	}	
	
	@PostMapping("/registrarJefe")
	public  ResponseEntity<?> createJefe(@RequestBody Usuario usuario) {
		

        HashMap<String, Object> salida = new HashMap<>();
        List<Usuario> lista = usuarioser.listaUsuarios();
        
        // Encrypting password
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String password = usuario.getContrasena();
        String encodedPassword = encoder.encode(password);
        usuario.setContrasena(encodedPassword);
        
        // Unique login and dni
        boolean usuarioExiste = false;
        boolean dniExiste = false;
        for (Usuario usuario1 : lista) {
            if (usuario.getUsuario().equals(usuario1.getUsuario())) {
                usuarioExiste = true;
                break;
            } else if (usuario.getDni().equals(usuario1.getDni())) {
                dniExiste = true;
                break;
            }
        }
        if (usuarioExiste) {
            salida.put("mensaje", "El usuario ya existe, ingrese otro");
        } else if (dniExiste) {
            salida.put("mensaje", "El DNI ya existe, ingrese otro");
        } else {
        	
            Usuario nuevo = usuarioser.registrarJefe(usuario);
            if (nuevo == null) {
                salida.put("mensaje", "Error en el registro");
            } else {
                salida.put("mensaje", "Registro exitoso con el ID: " + nuevo.getIdUsuario());
            }
        }

        return ResponseEntity.ok(salida);
	    
	}
	
	@PostMapping("/registrarPrestamista")
	public  ResponseEntity<?> createPrestamista(@RequestBody Usuario usuario) {
		

        HashMap<String, Object> salida = new HashMap<>();
        List<Usuario> lista = usuarioser.listaUsuarios();
        
        // Encrypting password
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String password = usuario.getContrasena();
        String encodedPassword = encoder.encode(password);
        usuario.setContrasena(encodedPassword);
        
        // Unique login and dni
        boolean usuarioExiste = false;
        boolean dniExiste = false;
        for (Usuario usuario1 : lista) {
            if (usuario.getUsuario().equals(usuario1.getUsuario())) {
                usuarioExiste = true;
                break;
            } else if (usuario.getDni().equals(usuario1.getDni())) {
                dniExiste = true;
                break;
            }
        }
        if (usuarioExiste) {
            salida.put("mensaje", "El usuario ya existe, ingrese otro");
        } else if (dniExiste) {
            salida.put("mensaje", "El DNI ya existe, ingrese otro");
        } else {
        	
            Usuario nuevo = usuarioser.registrarPrestamista(usuario);
            if (nuevo == null) {
                salida.put("mensaje", "Error en el registro");
            } else {
                salida.put("mensaje", "Registro exitoso con el ID: " + nuevo.getIdUsuario());
            }
        }

        return ResponseEntity.ok(salida);
	    
	}
	
	@PostMapping("/registrarPrestatario")
	public  ResponseEntity<?> createPrestatario(@RequestBody Usuario usuario) {
		

        HashMap<String, Object> salida = new HashMap<>();
        List<Usuario> lista = usuarioser.listaUsuarios();
        
        // Encrypting password
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String password = usuario.getContrasena();
        String encodedPassword = encoder.encode(password);
        usuario.setContrasena(encodedPassword);
        
        // Unique login and dni
        boolean usuarioExiste = false;
        boolean dniExiste = false;
        for (Usuario usuario1 : lista) {
            if (usuario.getUsuario().equals(usuario1.getUsuario())) {
                usuarioExiste = true;
                break;
            } else if (usuario.getDni().equals(usuario1.getDni())) {
                dniExiste = true;
                break;
            }
        }
        if (usuarioExiste) {
            salida.put("mensaje", "El usuario ya existe, ingrese otro");
        } else if (dniExiste) {
            salida.put("mensaje", "El DNI ya existe, ingrese otro");
        } else {
        	
            Usuario nuevo = usuarioser.registrarPrestatario(usuario);
            if (nuevo == null) {
                salida.put("mensaje", "Error en el registro");
            } else {
                salida.put("mensaje", "Registro exitoso con el ID: " + nuevo.getIdUsuario());
            }
        }

        return ResponseEntity.ok(salida);
	    
	}
	
	@GetMapping("/listaUsuariosDeUnUsuario/{idUsuario}")
    public ResponseEntity<List<Usuario>> obtenerUsuariosPorUsuarioSuperior(@PathVariable int idUsuario) {
        List<Usuario> usuarios = usuarioser.listaPrestamistariosDeUnPrestamista(idUsuario);
        return ResponseEntity.ok(usuarios);
    }
	
	
	@PutMapping("/actualizaUsuario")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizaEjemplo(@RequestBody Usuario obj) {
		Map<String, Object> salida = new HashMap<>();
		try {
			
			Usuario objSalida = usuarioser.registrarPrestatario(obj);
			if (objSalida == null) {
				salida.put("mensaje", AppSettings.MENSAJE_ACT_ERROR);
			} else {
				salida.put("mensaje", AppSettings.MENSAJE_ACT_EXITOSO + " Ejemplo de ID ==> " + obj.getIdUsuario() + ".");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", AppSettings.MENSAJE_ACT_ERROR);
		}
		return ResponseEntity.ok(salida);
	}
	
	
	
}
