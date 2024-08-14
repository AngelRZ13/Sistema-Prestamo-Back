package com.example.demo.entity;

import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class UsuarioHasRolPK {
	
	private static final long serialVersionUID = 1L;

	private int idUsuario;
	private int idRol;
}
