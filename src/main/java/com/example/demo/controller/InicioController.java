package com.example.demo.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Usuario;
import com.example.demo.service.UsuarioService;

@Controller
public class InicioController {

	@Autowired
	UsuarioService service;
	
	@GetMapping("/")
	public String inicioApp(Model model) {
		List<Usuario> usuarios = service.obtenerTodos();
		Usuario usuarioModel = usuarios.get(0);
		usuarioModel.setPassword("");
		
		Date date = Calendar.getInstance().getTime();
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String fechaActual = formatter.format(date);
        String fechaModificacion = formatter.format(usuarioModel.getFechamodificacion());
        
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat ("yyyy-MM-dd");
            Date date1 = dateFormat.parse(fechaActual);
            Date date2 = dateFormat.parse(fechaModificacion);
            int comparar = date2.compareTo(date1);
            if(comparar >= 0) {
            	model.addAttribute("changePass", 1);
            } else {
            	model.addAttribute("changePass", 0);
            }
        } catch (ParseException ex) {
        	model.addAttribute("changePass", 0);
        }
		
        model.addAttribute("usuarioModel", usuarioModel);
		model.addAttribute("listado", usuarios);
		return "inicio";
	}
	
	@PostMapping("/")
	public String actualizarContrasenia(@ModelAttribute(value="usuarioModel") Usuario usuarioModel) {
		service.actualizar(usuarioModel);
		return "redirect:/";
	}
}
