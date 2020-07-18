/**
 * 
 */
package ar.edu.unju.fi.service.Imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.model.Rol;
import ar.edu.unju.fi.repository.IRolDAO;
import ar.edu.unju.fi.service.IRolService;

/**
 * @author daniel-gnu
 *
 */
@Service
public class RolServiceImp implements IRolService {
	@Autowired
	IRolDAO rolRepository;

	@Override
	public Iterable<Rol> getAllRoles() {
		return rolRepository.findAll();
	}

}
