package com.example.demo.config;

public class ApiResponse {

	private String titulo;
	private String mensaje;
	
	public ApiResponse(String titulo, String mensaje) {
		this.titulo = titulo;
		this.mensaje = mensaje;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
}
