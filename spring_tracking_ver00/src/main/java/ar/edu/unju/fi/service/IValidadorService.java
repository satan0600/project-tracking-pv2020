/**
 * 
 */
package ar.edu.unju.fi.service;

import ar.edu.unju.fi.model.ValidadorCondicionSanitaria;

/**
 * @author daniel-gnu
 *
 */
public interface IValidadorService {
	public Iterable<ValidadorCondicionSanitaria> getAllValidadores();
	public ValidadorCondicionSanitaria createValidador(ValidadorCondicionSanitaria validaddor) throws Exception;
	public ValidadorCondicionSanitaria getBarrioById(Long id) throws Exception;
	public ValidadorCondicionSanitaria Updatevalidador(ValidadorCondicionSanitaria validador) throws Exception;
	public void deletevalidador(Long id) throws Exception;

}
