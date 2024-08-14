package com.example.demo.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Opcion;
import com.example.demo.entity.Rol;
import com.example.demo.entity.Usuario;
import com.example.demo.repository.UsuarioRepository;

import lombok.extern.apachecommons.CommonsLog;

@Service
@CommonsLog
public class UsuarioSeguridadServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {
		log.info(">>>loadUserByUsername >>> " + usuario);
		UserDetails userDetails = null;
		try {
			Usuario objUsuario = usuarioRepository.findByUsuario(usuario);
			if (objUsuario != null) {
				log.info("==> Login =========== " + objUsuario);

				List<Rol> lstRol = usuarioRepository.traerRolesDeUsuario(objUsuario.getIdUsuario());
				log.info("==> Roles =========== " + lstRol);
				
				List<Opcion> lstOpciones = usuarioRepository.traerEnlacesDeUsuario(objUsuario.getIdUsuario());
				log.info("==> Opciones =========== " + lstOpciones);
				
				userDetails = UsuarioPrincipal.build(objUsuario, lstRol, lstOpciones);
			}
		} catch (IndexOutOfBoundsException e) {
			throw new UsernameNotFoundException("Wrong username");
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new UsernameNotFoundException("Database Error");
		} catch (Exception e) {
			e.printStackTrace();
			throw new UsernameNotFoundException("Unknown Error");
		}
		return userDetails;
	}

}
