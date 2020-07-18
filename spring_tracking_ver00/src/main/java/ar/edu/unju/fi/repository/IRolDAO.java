/**
 * 
 */
package ar.edu.unju.fi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.model.Rol;

/**
 * @author daniel-gnu
 *
 */
@Repository
public interface IRolDAO extends JpaRepository<Rol, Long> {

}
