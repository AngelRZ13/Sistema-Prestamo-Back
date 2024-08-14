package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Usuario;
import com.example.demo.entity.Opcion;
import com.example.demo.entity.Rol;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	@Query("Select r from Rol r, UsuarioHasRol u where r.idRol = u.rol.idRol and u.usuario.idUsuario = ?1 ")
	public abstract List<Rol> traerRolesDeUsuario(int idUsuario);
	
	@Query("Select p from Opcion p, RolHasOpcion pr, Rol r, UsuarioHasRol u where  p.idOpcion = pr.opcion.idOpcion and pr.rol.idRol = r.idRol and r.idRol = u.rol.idRol and u.usuario.idUsuario = ?1 ")
	public abstract List<Opcion> traerEnlacesDeUsuario(int idUsuario);
	
	public abstract Usuario findByUsuario(String usuario);
	
	@Query("Select x from Usuario x where x.usuario = :#{#usu.usuario} and x.contrasena = :#{#usu.contrasena}")
	public abstract Usuario login(@Param(value = "usu") Usuario bean);
	
	@Query("Select r from Usuario r, UsuarioHasRol u where r.idUsuario = u.usuario.idUsuario and u.rol.idRol = 4 order by r.apellido desc ")
	public abstract List<Usuario> listaUsuarios();
    
	@Query("SELECT u FROM Usuario u WHERE u.usuarioSuperior = :idUsuario")
    public abstract List<Usuario> listaPrestamistariosDeUnPrestamista(@Param("idUsuario") int idUsuario);
    
    Optional<Usuario> findById(int id);
    
    
}
