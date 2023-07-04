package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Persona;
import com.example.demo.repository.PersonaRepository;

/**
 * Servicio para manejar las operaciones relacionadas con las personas.
 */
@Service
public class PersonaService {

	@Autowired
	private PersonaRepository personaRepository;
	
	/**
     * Crea una nueva persona.
     * @param personaCreada El objeto persona a crear.
     * @return El objeto Persona creado.
     */
	public Persona createPersona(Persona personaCreada) {
		return personaRepository.save(personaCreada);
	}
	
	/**
     * Obtiene la lista de todas las personas.
     * @return Lista de personas.
     */
	public List<Persona> getAllPersonas() {
        return personaRepository.findAll();
    }
	
	/**
     * Obtiene una persona por su ID
     * @param id El ID de la persona a obtener.
     * @return Optional con el objeto Persona si se encuentra, o Optional.empty() si no.
     */
	public Optional<Persona> getPersonaById(Long id) {
        return personaRepository.findById(id);
    }
	
	/**
     * Actualiza una persona existente.
     * @param personaActualizada El objeto Persona con los nuevos datos.
     * @return El objeto Persona actualizado.
     */
	public Persona updatePersona(Persona personaActualizada) {
        return personaRepository.save(personaActualizada);
    }
	
	 /**
     * Elimina una persona por su ID.
     * @param id El ID de la persona a eliminar.
     */
	public void deletPersona(Long id) {
		personaRepository.deleteById(id);
    }
}
