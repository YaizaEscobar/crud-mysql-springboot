package com.example.ApiRestSpringBootMysql.service;

import com.example.ApiRestSpringBootMysql.exceptions.CalidadNotFoundException;
import com.example.ApiRestSpringBootMysql.model.CalidadModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CalidadService {

    @Autowired
    private ICalidadRepository calidadRepository;

    public List<CalidadModel> getAllCalidades() {
        return calidadRepository.findAll();
    }

    public Optional<CalidadModel> getCalidadById(Long id) {
        return Optional.ofNullable((CalidadModel) calidadRepository.findById(id).orElseThrow(
                () -> new CalidadNotFoundException("No se ha encontrado la calidad con id: " + id)
        ));
    }
}
