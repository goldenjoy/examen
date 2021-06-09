package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Usuario;

@Repository
public interface UsuarioDao extends JpaRepository<Usuario, String> {
	public boolean existsByLogin(@Param("login") String login);
	public boolean existsByNombre(@Param("nombre") String nombre);
	Usuario findByLogin(String login);
	Usuario findByNombre(String nombre);
}
