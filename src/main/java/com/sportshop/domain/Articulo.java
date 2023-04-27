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
    
    private boolean ninos;
    private String marca;
    private String descripcion;
    private String detalle;
    private String moneda;
    private int precio;
    private int existencias;
    private String imagen;
    private boolean activo;
    
    @ManyToOne
    @JoinColumn(name="id_categoria", referencedColumnName="id_categoria")
    private Categoria categoria;
    
    @ManyToOne
    @JoinColumn(name="id_generales", referencedColumnName="id_generales")
    private General generales;
    
    @ManyToOne
    @JoinColumn(name="id_sexo", referencedColumnName="id_sexo")
    private Sexo sexo;
    

    public Articulo() {
    }

    public Articulo(String marca,boolean ninos,String descripcion, String detalle, String moneda, int precio, int existencias, String imagen, boolean activo, Categoria categoria, General generales, Sexo sexo) {
        this.ninos = ninos;
        this.marca = marca;
        this.descripcion = descripcion;
        this.detalle = detalle;
        this.moneda = moneda;
        this.precio = precio;
        this.existencias = existencias;
        this.imagen = imagen;
        this.activo = activo;
        this.categoria = categoria;
        this.generales = generales;
        this.sexo = sexo;
    }
        
}
