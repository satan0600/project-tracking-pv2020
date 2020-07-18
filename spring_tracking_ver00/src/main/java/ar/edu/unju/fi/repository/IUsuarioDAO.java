/**
 * 
 */
package ar.edu.unju.fi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.model.Usuario;

/**
 * @author daniel-gnu
 *
 */
@Repository
public interface IUsuarioDAO extends JpaRepository<Usuario, Long> {
	public Optional<Usuario> findByNombreU(String nombreU);

}
