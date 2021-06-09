package com.example.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.ColumnDefault;

@Entity
public class Usuario {

	@Id
	@Size(min = 0, max = 20)
	@NotNull
	String login;

	@Size(min = 0, max = 300)
	@NotNull
	String password;

	@Size(min =  0, max = 50)
	@NotNull
	String nombre;

	@NotNull
	float cliente;

	@Size(min =  0, max = 50)
	String email;

	//@Column(insertable = true, updatable = false)
	@Column(columnDefinition = " TIMESTAMP default CURRENT_TIMESTAMP ")
	@NotNull
	Date fechaalta;

	Date fechabaja;

	@Column(columnDefinition = "char(1) ")
	@ColumnDefault("'A'")
	@NotNull
	char status;

	@NotNull
	@ColumnDefault("'0'")
	float intentos;

	Date fecharevocado;

	Date fecha_vigencia;

	@Column(nullable = true)
	int no_acceso;

	@Size(min = 0, max = 50)
	String apellido_paterno;

	@Size(min = 0, max = 50)
	String apellido_materno;

	@Column(columnDefinition = "NUMBER(4)")
	int area;

	//@Column(insertable = true, updatable = true)
	@Column(columnDefinition = " TIMESTAMP default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP ")
	@Temporal(TemporalType.DATE)
	@NotNull
	Date fechamodificacion;

	//Getters and Setters
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getCliente() {
		return cliente;
	}

	public void setCliente(float cliente) {
		this.cliente = cliente;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFechaalta() {
		return fechaalta;
	}

	public void setFechaalta(Date fechaalta) {
		this.fechaalta = fechaalta;
	}

	public Date getFechabaja() {
		return fechabaja;
	}

	public void setFechabaja(Date fechabaja) {
		this.fechabaja = fechabaja;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public double getIntentos() {
		return intentos;
	}

	public void setIntentos(float intentos) {
		this.intentos = intentos;
	}

	public Date getFecharevocado() {
		return fecharevocado;
	}

	public void setFecharevocado(Date fecharevocado) {
		this.fecharevocado = fecharevocado;
	}

	public Date getFecha_vigencia() {
		return fecha_vigencia;
	}

	public void setFecha_vigencia(Date fecha_vigencia) {
		this.fecha_vigencia = fecha_vigencia;
	}

	public int getNo_acceso() {
		return no_acceso;
	}

	public void setNo_acceso(int no_acceso) {
		this.no_acceso = no_acceso;
	}

	public String getApellido_paterno() {
		return apellido_paterno;
	}

	public void setApellido_paterno(String apellido_paterno) {
		this.apellido_paterno = apellido_paterno;
	}

	public String getApellido_materno() {
		return apellido_materno;
	}

	public void setApellido_materno(String apellido_materno) {
		this.apellido_materno = apellido_materno;
	}

	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
	}

	public Date getFechamodificacion() {
		return fechamodificacion;
	}

	public void setFechamodificacion(Date fechamodificacion) {
		this.fechamodificacion = fechamodificacion;
	}
	
	
}
