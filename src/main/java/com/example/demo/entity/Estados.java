package com.example.demo.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "estados")
public class Estados {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEstados;
	
	private String descripcion;
}
