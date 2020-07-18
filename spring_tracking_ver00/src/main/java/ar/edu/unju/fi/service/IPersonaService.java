/**
 * 
 */
package ar.edu.unju.fi.service;


import ar.edu.unju.fi.model.Persona;

/**
 * @author daniel-gnu
 *
 */
public interface IPersonaService {
	public Iterable<Persona> getAllPersonas();

	public Persona createPersona(Persona persona) throws Exception;

	public Persona getPersonaById(Long id) throws Exception;

	public Persona UpdatePersona(Persona persona) throws Exception;

	public void deletePersona(Long id) throws Exception;

}
