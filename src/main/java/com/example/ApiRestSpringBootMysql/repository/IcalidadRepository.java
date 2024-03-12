package com.example.ApiRestSpringBootMysql.repository;


import org.springframework.data.jpa.repository.JpaRepository;

public interface IcalidadRepository<CalidadModel> extends JpaRepository<CalidadModel, Long> {
}
