package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo.dao.UsuarioDao;
import com.example.demo.model.Usuario;

@SpringBootTest
class DemoApplicationTests {
	
	@Autowired
	private UsuarioDao dao;
	
	@Autowired
	private BCryptPasswordEncoder encoder;

	@Test
	void createUserTest() {
		Usuario user = new Usuario();
		user.setLogin("user1");
		user.setPassword(encoder.encode("wasd"));
		user.setNombre("Michael Enrique");
		user.setApellido_paterno("Sanchez");
		user.setApellido_materno("Santiago");
		user.setEmail("asdfas");
		user.setFechaalta(new Date());
		user.setFechamodificacion(new Date());
		user.setCliente(1f);
		
		Usuario userResponse = dao.save(user);
		
		assertTrue(userResponse.getPassword().equalsIgnoreCase(user.getPassword()));
	}

}
