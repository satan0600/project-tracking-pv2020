/**
 * 
 */
package ar.edu.unju.fi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.model.RegistroTracking;

/**
 * @author daniel-gnu
 *
 */
@Repository
public interface IRegistroDAO extends JpaRepository<RegistroTracking, Long> {

}
