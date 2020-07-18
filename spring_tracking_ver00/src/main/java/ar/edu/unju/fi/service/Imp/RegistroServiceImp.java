/**
 * 
 */
package ar.edu.unju.fi.service.Imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.model.RegistroTracking;
import ar.edu.unju.fi.repository.IRegistroDAO;
import ar.edu.unju.fi.service.IRegistroService;

/**
 * @author daniel-gnu
 *
 */
@Service
public class RegistroServiceImp implements IRegistroService {
	@Autowired
	IRegistroDAO registroREpository;

	@Override
	public Iterable<RegistroTracking> getAllRegistros() {
		return registroREpository.findAll();
	}

	@Override
	public RegistroTracking createRegistro(RegistroTracking registro) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RegistroTracking getRegistroById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RegistroTracking UpdateBarrio(RegistroTracking registro) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteRegistro(Long id) throws Exception {
		// TODO Auto-generated method stub

	}

}
