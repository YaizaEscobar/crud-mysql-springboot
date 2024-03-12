package com.example.ApiRestSpringBootMysql.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name = "calidad")
public class CalidadModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "calidadProducto", nullable = false, length = 50)
    private String calidadProducto;
    @OneToMany(mappedBy = "calidad", cascade = CascadeType.ALL)
    private List<InstrumentosModel> instrumentos;
    public CalidadModel() {
    }
    public CalidadModel(Long id, String calidadProducto) {
        this.id = id;
        this.calidadProducto = calidadProducto;
    }
}
