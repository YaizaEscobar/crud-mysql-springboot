package com.example.ApiRestSpringBootMysql.service;

import com.example.ApiRestSpringBootMysql.controller.InstrumentoModel;

import java.util.List;
import java.util.Optional;

public class IInstrumentosRepository {
    public List<InstrumentoModel> findByNombreProductoContainingIgnoreCase(String modelo) {
        return null;
    }

    public Optional<Object> findById(Long id) {
        return Optional.empty();
    }

    public boolean existsById(Long id) {
        return true;
    }

    public void deleteById(Long id) {
    }

    public InstrumentoModel save(InstrumentoModel instrumentoToUpdate) {
        return null;
    }

    public List<InstrumentoModel> findAll() {
        return null;
    }
}
