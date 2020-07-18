/**
 * 
 */
package ar.edu.unju.fi.service;

import ar.edu.unju.fi.model.Barrio;

/**
 * @author daniel-gnu
 *
 */
public interface IBarrioService {
	public Iterable<Barrio> getAllBarrios();

	public Barrio createBarrio(Barrio barrio) throws Exception;

	public Barrio getBarrioById(Long id) throws Exception;

	public Barrio UpdateBarrio(Barrio barrio) throws Exception;

	public void deleteBarrio(Long id) throws Exception;

}
