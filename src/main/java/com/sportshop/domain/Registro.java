
package com.sportshop.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;


@Data
@Entity
@Table(name= "registro")
public class Registro implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_registro")
    private Long idRegistro;

    private String nombres;
    private String apellidos;
    private String correo;
    private String contraseña;
    private String pais;
    private String fechaNacimiento;

    
    public Registro(String nombres, String apellidos, String correo, String contraseña, String pais, String fechaNacimiento) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.contraseña = contraseña;
        this.pais = pais;
        this.fechaNacimiento = fechaNacimiento;
    }

    // constructor vacío necesario para JPA
    public Registro() {
    }
}