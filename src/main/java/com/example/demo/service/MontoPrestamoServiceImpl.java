package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.MontoPrestamo;
import com.example.demo.repository.MontoPrestamoRepository;

@Service
public class MontoPrestamoServiceImpl implements MontoPrestamoService{
	
	@Autowired
	private MontoPrestamoRepository repo;

	@Override
	public List<MontoPrestamo> findAll() {
		return repo.findAll();
	}

}
