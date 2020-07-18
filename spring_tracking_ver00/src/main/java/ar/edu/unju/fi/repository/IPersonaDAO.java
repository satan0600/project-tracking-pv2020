/**
 * 
 */
package ar.edu.unju.fi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.model.Persona;

/**
 * @author daniel-gnu
 *
 */
@Repository
public interface IPersonaDAO extends JpaRepository<Persona, Long> {
	
	public Optional<Persona> findByDocumento(String documento);

}
