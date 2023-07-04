package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Clase que representa una persona.
 */
@Entity
@Table(name = "persona")
public class Persona {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "nombre", nullable = false)
	private String nombre;
	
	@Column(name = "numero", nullable = false)
	private Long numero;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	/**
     * Constructor de la clase Persona.
     * @param nombre El nombre de la persona.
     * @param numero El número de la persona.
     * @param email  El email de la persona.
     */
	public Persona(String nombre, Long numero, String email ) {
		super();
		this.nombre = nombre;
		this.numero = numero;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
     * Constructor vacío de la clase Persona.
     * Se utiliza para la creación de instancias sin parámetros.
     */
	public Persona() {
    }	
}
