package com.sportshop.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;


@Data
@Entity
@Table(name="articulo")
public class Articulo implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_articulo")
    private Long idArticulo;
    
    private String descripcion;
    private String detalle;
    private String moneda;
    private double precio;
    private int existencias;
    private String imagen;
    private boolean activo;
    @JoinColumn(name="id_categoria", referencedColumnName="id_categoria")
    @ManyToOne
    
    private Categoria categoria;
    

    public Articulo() {
    }

    public Articulo(String descripcion, String detalle, String moneda, double precio, int existencias, String imagen, boolean activo, Categoria categoria) {
        this.descripcion = descripcion;
        this.detalle = detalle;
        this.moneda = moneda;
        this.precio = precio;
        this.existencias = existencias;
        this.imagen = imagen;
        this.activo = activo;
        this.categoria = categoria;
    }
        
}
