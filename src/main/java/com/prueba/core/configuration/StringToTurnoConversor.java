package com.prueba.core.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import com.prueba.core.models.Turno;
import com.prueba.core.services.TurnoService;

public class StringToTurnoConversor implements Converter<String, Turno> {
	 @Autowired
	    private TurnoService turnoservice;

	    @Override
	    public Turno convert(String text) {
	        if (text.isEmpty()) {
	            return null;
	        }
	        Long id = Long.valueOf(text);
	        return turnoservice.buscarPorId(id);
	    }
}
