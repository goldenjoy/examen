package com.example.demo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.example.demo.model.Usuario;
import com.example.demo.service.UsuarioService;

@Component
public class CargarDatosDbArranque implements ApplicationRunner {
	
	private UsuarioService userService;

	@Autowired
	public CargarDatosDbArranque(UsuarioService userService) {
		this.userService = userService;
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Usuario user = new Usuario();
		user.setNombre("Usuario 1");
		user.setPassword("wasd");
		
		//userService.guardar(user);
	}

}
