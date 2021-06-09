package com.example.demo.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Usuario;
import com.example.demo.service.UsuarioService;

@RestController
@RequestMapping("/service/user")
public class RestUsuarioController extends CrudComun<Usuario, String> {

	@Autowired
	public RestUsuarioController(UsuarioService service) {
		super(service);
	}
}
