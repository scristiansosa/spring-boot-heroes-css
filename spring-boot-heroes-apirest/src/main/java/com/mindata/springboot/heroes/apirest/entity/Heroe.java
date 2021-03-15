package com.mindata.springboot.heroes.apirest.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "heroes")
@ApiModel(description = "Descripcion del Heroes:")
public class Heroe implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(required = false, hidden = true)
	private int id;

	@NotNull
	@ApiModelProperty(notes = "Nombre del Heroe:")
	private String nombre;

	@NotNull
	@ApiModelProperty(notes = "Habilidad del Heroe:")
	private String habilidad;

	@NotNull
	@ApiModelProperty(notes = "Edad del Heroe:")
	private int edad;

	public Heroe() {

	}

	public Heroe(int id, @NotNull String nombre, @NotNull String habilidad, @NotNull int edad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.habilidad = habilidad;
		this.edad = edad;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getHabilidad() {
		return habilidad;
	}

	public void setHabilidad(String habilidad) {
		this.habilidad = habilidad;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "Heroe [id=" + id + ", nombre=" + nombre + ", habilidad=" + habilidad + ", edad=" + edad + "]";
	}

	private static final long serialVersionUID = 1L;

}
