package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Usuario;

public interface CrudSimple<T, ID> {
	public List<T> obtenerTodos();
	public Usuario obtenerPorId(ID login);
	public T guardar(T t);
	public T actualizar(T t);
	public void eliminarPorId(ID login);
}
