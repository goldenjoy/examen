package com.example.demo.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UsuarioDao;
import com.example.demo.model.Usuario;

@Service
public class UsuarioService implements CrudSimple<Usuario, String>{

	@Autowired
	UsuarioDao dao;
	
	@Autowired
	private BCryptPasswordEncoder encoder;

	@Override
	public List<Usuario> obtenerTodos() {
		return this.dao.findAll();
	}

	@Override
	public Usuario obtenerPorId(String login) {
		return this.dao.findByLogin(login);
	}

	@Override
	public Usuario guardar(Usuario t) {
		 if (!this.dao.existsByNombre(t.getNombre()))
			 return this.dao.save(t);
        else
        	 throw new DuplicateKeyException("El usuario "+t.getNombre()+" ya esta registrado y no puede ser duplicado");
	}

	@Override
	public Usuario actualizar(Usuario t) {
		if (this.dao.existsByLogin(t.getLogin())) {
			t.setPassword(encoder.encode(t.getPassword()));
			return this.dao.save(t);
		}
        else
            throw new EntityNotFoundException("El usuario "+t.getNombre()+" no puede ser actualizado por que no existe en el sistema");
	}

	@Override
	public void eliminarPorId(String login) {
		Usuario t = this.dao.findByLogin(login);
		if(t != null) {
			this.dao.deleteById(login);
		}
		else 
			throw new EntityNotFoundException("El usuario no se puede eliminar por que no se encuentra en el sistema");
	}
	
	
}
