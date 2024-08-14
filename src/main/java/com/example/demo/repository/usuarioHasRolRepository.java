package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.UsuarioHasRol;
import com.example.demo.entity.UsuarioHasRolPK;

public interface usuarioHasRolRepository extends JpaRepository<UsuarioHasRol, UsuarioHasRolPK>{

}
