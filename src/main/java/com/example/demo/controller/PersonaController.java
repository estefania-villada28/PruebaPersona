package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Persona;
import com.example.demo.service.PersonaService;
/**
 * Controlador para manejar las operaciones relacionadas con las personas.
 */
@RequestMapping("/api/personas") 
@RestController
public class PersonaController {

	@Autowired
	private PersonaService personaService;
	
	/**
     * Crea una nueva persona.
     * @param persona El objeto persona a crear.
     * @return ResponseEntity con el objeto Persona creado en el cuerpo de la respuesta.
     *         Devuelve HttpStatus.BAD_REQUEST si ocurre una excepción durante la creación.
     */
	@PostMapping("/crearPersona")
	private ResponseEntity<Persona> guardarPersona(@RequestBody Persona persona) {
		try {
			return ResponseEntity.ok(personaService.createPersona(persona));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
	}
	
	/**
     * Obtiene la lista de todas las personas.
     * @return ResponseEntity con la lista de personas en el cuerpo de la respuesta.
     */
	@GetMapping("/listarPersonas")
	private ResponseEntity<List<Persona>> listarPersonas() {
		return ResponseEntity.ok(personaService.getAllPersonas());
	}
	
	 /**
     * Obtiene una persona por su ID.
     * @param personaId El ID de la persona a obtener.
     * @return ResponseEntity con el objeto Persona en el cuerpo de la respuesta.
     *         Devuelve HttpStatus.NOT_FOUND si no se encuentra ninguna persona con el ID proporcionado.
     */
	@GetMapping("/obtenerPersonaPorId/{id}")
    public ResponseEntity<Persona> obtenerEmpleadoPorId(@PathVariable("id") Long personaId) {
        return personaService.getPersonaById(personaId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
	
	/**
     * Actualiza una persona existente.
     * @param id      El ID de la persona a actualizar.
     * @param persona El objeto Persona con los nuevos datos.
     * @return ResponseEntity con el objeto Persona actualizado en el cuerpo de la respuesta.
     *         Devuelve HttpStatus.NOT_FOUND si no se encuentra ninguna persona con el ID proporcionado.
     */
	@PutMapping("/actualizarPersona/{id}")
    public Object actualizarPersona(@PathVariable("id") Long id, @RequestBody Persona persona) {
        return personaService.getPersonaById(id)
                .map(personaGuardado -> {
                	personaGuardado.setNombre(persona.getNombre());
                	personaGuardado.setNumero(persona.getNumero());
                	personaGuardado.setEmail(persona.getEmail());

                    Persona personaActualizada = personaService.updatePersona(personaGuardado);
                    return ResponseEntity.ok(personaActualizada);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
	
	/**
	 * Elimina una persona por su ID.
	 * @param personaId El ID de la persona a eliminar.
	 * @return ResponseEntity con un mensaje de éxito en el cuerpo de la respuesta.
	 */
	@DeleteMapping("/eliminarPersona/{id}")
    public ResponseEntity<String> eliminarPersona(@PathVariable("id") Long personaId) {
		personaService.deletPersona(personaId);
        return ResponseEntity.ok("Empleado eliminado exitosamente");
    }
}
