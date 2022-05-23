package com.prueba.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.core.models.Turno;
import com.prueba.core.repository.TurnoRepository;

@Service
public class TurnoServiceImpl implements TurnoService{

@Autowired
private TurnoRepository turnorepository;

@Override
public Turno buscarPorId(Long id) {
	return null;
	
}

}
