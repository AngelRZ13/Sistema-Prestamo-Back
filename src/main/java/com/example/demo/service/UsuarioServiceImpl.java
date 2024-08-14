package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Rol;
import com.example.demo.entity.Usuario;
import com.example.demo.entity.UsuarioHasRol;
import com.example.demo.entity.UsuarioHasRolPK;
import com.example.demo.repository.RolRepository;
import com.example.demo.repository.UsuarioRepository;
import com.example.demo.repository.usuarioHasRolRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	private UsuarioRepository repo;
	
	@Autowired
	private RolRepository repoRol;
	
	@Autowired
	private usuarioHasRolRepository repoHas;

	@Override
	public Usuario registrarUsuario(Usuario u) {
		
		if (u.getUsuarioSuperior() == null) {
            u.setUsuarioSuperior(null);
        }
        if (u.getUsuarioRegistro() == null) {
            u.setUsuarioRegistro(null);
        }
        if (u.getUsuarioActualiza() == null) {
            u.setUsuarioActualiza(null);
        }
		Usuario usuarioSave = repo.save(u);
		Rol rol = repoRol.findById(4).orElse(null);
		if(rol != null) {
			 UsuarioHasRolPK usuarioHasRolPK = new UsuarioHasRolPK();
	         usuarioHasRolPK.setIdUsuario(usuarioSave.getIdUsuario());
	         usuarioHasRolPK.setIdRol(rol.getIdRol());

	         UsuarioHasRol usuarioHasRol = new UsuarioHasRol();
	         usuarioHasRol.setUsuarioHasRolPk(usuarioHasRolPK);
	         usuarioHasRol.setUsuario(usuarioSave);
	         usuarioHasRol.setRol(rol);

	            repoHas.save(usuarioHasRol);
	        } else {
	        	throw new RuntimeException("El rol con ID 4 no existe.");
		}
		
		
		return usuarioSave;
	}

	@Override
	public List<Usuario> listaUsuarios() {
		return repo.listaUsuarios();
	}

	@Override
	public List<Rol> traerRolesDeUsuario(int idUsuario) {
		return repo.traerRolesDeUsuario(idUsuario);
	}

	@Override
	public Usuario findByUsuario(String usuario) {
		return repo.findByUsuario(usuario);
	}

	@Override
	public Usuario registrarJefe(Usuario u) {
		Usuario usuarioSave = repo.save(u);
		Rol rol = repoRol.findById(2).orElse(null);
		if(rol != null) {
			 UsuarioHasRolPK usuarioHasRolPK = new UsuarioHasRolPK();
	         usuarioHasRolPK.setIdUsuario(usuarioSave.getIdUsuario());
	         usuarioHasRolPK.setIdRol(rol.getIdRol());

	         UsuarioHasRol usuarioHasRol = new UsuarioHasRol();
	         usuarioHasRol.setUsuarioHasRolPk(usuarioHasRolPK);
	         usuarioHasRol.setUsuario(usuarioSave);
	         usuarioHasRol.setRol(rol);

	            repoHas.save(usuarioHasRol);
	        } else {
	        	throw new RuntimeException("El rol con ID 4 no existe.");
		}
		
		
		return usuarioSave;	
		}

	@Override
	public Usuario registrarPrestamista(Usuario u) {
		Usuario usuarioSave = repo.save(u);
		Rol rol = repoRol.findById(3).orElse(null);
		if(rol != null) {
			 UsuarioHasRolPK usuarioHasRolPK = new UsuarioHasRolPK();
	         usuarioHasRolPK.setIdUsuario(usuarioSave.getIdUsuario());
	         usuarioHasRolPK.setIdRol(rol.getIdRol());

	         UsuarioHasRol usuarioHasRol = new UsuarioHasRol();
	         usuarioHasRol.setUsuarioHasRolPk(usuarioHasRolPK);
	         usuarioHasRol.setUsuario(usuarioSave);
	         usuarioHasRol.setRol(rol);

	            repoHas.save(usuarioHasRol);
	        } else {
	        	throw new RuntimeException("El rol con ID 4 no existe.");
		}
		
		
		return usuarioSave;
	}

	@Override
	public Usuario registrarPrestatario(Usuario u) {
		Usuario usuarioSave = repo.save(u);
		Rol rol = repoRol.findById(4).orElse(null);
		if(rol != null) {
			 UsuarioHasRolPK usuarioHasRolPK = new UsuarioHasRolPK();
	         usuarioHasRolPK.setIdUsuario(usuarioSave.getIdUsuario());
	         usuarioHasRolPK.setIdRol(rol.getIdRol());

	         UsuarioHasRol usuarioHasRol = new UsuarioHasRol();
	         usuarioHasRol.setUsuarioHasRolPk(usuarioHasRolPK);
	         usuarioHasRol.setUsuario(usuarioSave);
	         usuarioHasRol.setRol(rol);

	            repoHas.save(usuarioHasRol);
	        } else {
	        	throw new RuntimeException("El rol con ID 4 no existe.");
		}
		
		
		return usuarioSave;
	}

	@Override
	public List<Usuario> listaPrestamistariosDeUnPrestamista(int idUsuario) {
		return repo.listaPrestamistariosDeUnPrestamista(idUsuario);
	}

	@Override
    public Usuario obtenerPorId(int idUsuario) {
        return repo.findById(idUsuario).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }
}
