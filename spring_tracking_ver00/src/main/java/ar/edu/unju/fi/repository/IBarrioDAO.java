/**
 * 
 */
package ar.edu.unju.fi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.model.Barrio;

/**
 * @author daniel-gnu
 *
 */
@Repository
public interface IBarrioDAO extends JpaRepository<Barrio, Long> {
//public Optional<Barrio>findByNombre(String nombre);
//	public  List<Barrio> findByNombre(String nombre);
	// public Barrio findByNombre(String nombre);

}
