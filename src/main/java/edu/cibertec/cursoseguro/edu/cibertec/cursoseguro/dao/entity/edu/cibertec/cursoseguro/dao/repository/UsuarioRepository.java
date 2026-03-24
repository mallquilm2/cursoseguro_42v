package edu.cibertec.cursoseguro.edu.cibertec.cursoseguro.dao.entity.edu.cibertec.cursoseguro.dao.repository;

import edu.cibertec.cursoseguro.edu.cibertec.cursoseguro.dao.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, String> {
}
