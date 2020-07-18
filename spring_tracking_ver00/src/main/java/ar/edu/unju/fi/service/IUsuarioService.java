/**
 * 
 */
package ar.edu.unju.fi.service;

import ar.edu.unju.fi.model.Usuario;

/**
 * @author daniel-gnu
 *
 */
public interface IUsuarioService {
	public Iterable<Usuario> getAllUsuarios();

	public Usuario createUsuario(Usuario usuario) throws Exception;

	public Usuario getUsuarioById(Long id) throws Exception;

	public Usuario updateUsuario(Usuario usuario) throws Exception;

	public void deleteUsuario(Long id) throws Exception;

}
