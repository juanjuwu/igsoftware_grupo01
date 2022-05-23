package com.prueba.core.services;

import org.springframework.stereotype.Service;

import com.prueba.core.models.Turno;


public interface TurnoService {
Turno buscarPorId(Long id);
}
