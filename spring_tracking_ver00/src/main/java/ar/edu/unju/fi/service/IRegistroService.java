/**
 * 
 */
package ar.edu.unju.fi.service;

import ar.edu.unju.fi.model.RegistroTracking;

/**
 * @author daniel-gnu
 *
 */
public interface IRegistroService {
	public Iterable<RegistroTracking> getAllRegistros();

	public RegistroTracking createRegistro(RegistroTracking registro) throws Exception;

	public RegistroTracking getRegistroById(Long id) throws Exception;

	public RegistroTracking UpdateBarrio(RegistroTracking registro) throws Exception;

	public void deleteRegistro(Long id) throws Exception;

}
