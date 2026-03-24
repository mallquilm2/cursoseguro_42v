package edu.cibertec.cursoseguro.edu.cibertec.cursoseguro.dao.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Table(name = "curso")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CursoEntity {

    @Id
    @Column(name = "idcurso")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCurso;

    @Column(name = "nomcurso")
    private String nomCurso;

    @Column(name = "fechainicio")
    private Date fechaInicio;

    @Column(name = "alumnosmin")
    private int alumnosMin;

    @Column(name = "alumnosact")
    private Integer alumnosAct;

    @Column(name = "estado")
    private int estado;

}
