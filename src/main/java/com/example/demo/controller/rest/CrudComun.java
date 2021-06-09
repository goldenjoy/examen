package com.example.demo.controller.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.model.Usuario;
import com.example.demo.service.CrudSimple;

public class CrudComun<T, ID> {

	private CrudSimple<T, ID> crudBasico;

	@Autowired
	public CrudComun(CrudSimple<T, ID> crudBasico) {
		this.crudBasico = crudBasico;
	}
	
	@GetMapping
    public List<T> mostrarTodos() {
		return crudBasico.obtenerTodos();
	}

    @SuppressWarnings("unchecked")
	@GetMapping("/{id}")
    public ResponseEntity<T> mostrarPorId(@PathVariable ID id) {
    	Usuario entity = crudBasico.obtenerPorId(id);
        return (ResponseEntity<T>) ResponseEntity.status((entity != null) ? HttpStatus.OK : HttpStatus.NO_CONTENT).body(entity);
    }

    @PostMapping
    public ResponseEntity<T> guardar(@Valid @RequestBody T body) {
    	return ResponseEntity.status(HttpStatus.CREATED).body(this.crudBasico.guardar(body));
    }
    
	@PutMapping
    public T actualizar(@Valid @RequestBody T body) {
    	return this.crudBasico.actualizar(body);
    }

    @DeleteMapping("/{id}")
    public void eliminarPorId(@PathVariable ID id) {
    	this.crudBasico.eliminarPorId(id);
    }
	
}
