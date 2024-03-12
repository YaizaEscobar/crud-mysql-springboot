package com.example.ApiRestSpringBootMysql.repository;
import com.example.ApiRestSpringBootMysql.model.InstrumentosModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IinstrumentosRepository extends JpaRepository<InstrumentosModel, Long> {

    List<InstrumentosModel> findByNombreProductoContainingIgnoreCase(String nombreProducto);

    List<InstrumentosModel> findByOrderById();
}

