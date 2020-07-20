/**
 * 
 */
package ar.edu.unju.fi.service.Imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.model.Barrio;
import ar.edu.unju.fi.model.Persona;
import ar.edu.unju.fi.model.Usuario;
import ar.edu.unju.fi.repository.IPersonaDAO;
import ar.edu.unju.fi.service.IPersonaService;

/**
 * @author daniel-gnu
 *
 */
@Service
public class PersonaServiceImp implements IPersonaService {
	@Autowired
	IPersonaDAO personaRepository;

	@Override
	public Iterable<Persona> getAllPersonas() {
		return personaRepository.findAll();
	}

	private boolean checkNombrePersonaAvailable(Persona persona) throws Exception {
		Optional<Persona> usuarioFound = personaRepository.findByDocumento(persona.getDocumento());
		if (usuarioFound.isPresent()) {
			throw new Exception("nombreUsuario no disponible");

		}
		return true;
	}

	@Override
	public Persona createPersona(Persona persona) throws Exception {
		if (checkNombrePersonaAvailable(persona)) {
			persona = personaRepository.save(persona);
		}
		return persona;
	}

	@Override
	public Persona getPersonaById(Long id) throws Exception {
		return personaRepository.findById(id).orElseThrow(() -> new Exception("el usuario para edicion no existe"));
	}

	private void mapPersona(Persona from, Persona to) {
		to.setNombres(from.getNombres());
	}

	@Override
	public Persona UpdatePersona(Persona fromPersona) throws Exception {
		Persona toPersona = getPersonaById(fromPersona.getId());
		mapPersona(fromPersona, toPersona);
		return personaRepository.save(toPersona);
	}

	@Override
	public void deletePersona(Long id) throws Exception {
		Persona persona = getPersonaById(id);
		personaRepository.delete(persona);
	}

}
