package com.example.ApiRestSpringBootMysql.model;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
@Data
@Entity
@Table(name = "instrumentos")
public class InstrumentosModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_calidad")
    private CalidadModel calidad;
    @Column(name = "nombreProducto", nullable = false)
    private String nombreProducto;
    @Column(name = "descripcion", nullable = false)
    private String descripcion;
    @Column(name = "precio", nullable = false)
    private int precio;
    @Column(name = "imagen", nullable = false)
    private String imagen;
    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "foto", columnDefinition = "longblob", nullable = true)
    private byte[] foto;
    @Column(name = "nombreImagen", nullable = false)
    private String nombreImagen;
    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion = LocalDateTime.now();
    @Column(name = "fecha_modificacion")
    private LocalDateTime fechaModificacion = LocalDateTime.now();
    public InstrumentosModel() {
    }
    public InstrumentosModel(CalidadModel calidad, String nombreProducto, String descripcion, int precio) {
        this.calidad = calidad;
        this.nombreProducto = nombreProducto;
        this.descripcion = descripcion;
        this.precio = precio;
    }
    @Override
    public String toString() {
        return "Instrumento{" +
                "id=" + id +
                ", nombreProducto='" + nombreProducto + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio + '}';
    }
}
