package edu.cibertec.cursoseguro.edu.cibertec.cursoseguro.dao.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "usuario")
@Data
public class UsuarioEntity {

    @Id
    private String usuario;
    private String clave;
    @Column(name = "nombreCompleto")
    private String nombreCompleto;


}
