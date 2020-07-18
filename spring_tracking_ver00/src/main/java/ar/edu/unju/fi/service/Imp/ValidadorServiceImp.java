/**
 * 
 */
package ar.edu.unju.fi.service.Imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.model.ValidadorCondicionSanitaria;
import ar.edu.unju.fi.repository.IRolDAO;
import ar.edu.unju.fi.service.IValidadorService;

/**
 * @author daniel-gnu
 *
 */
@Service
public class ValidadorServiceImp implements IValidadorService {
	@Autowired
	IRolDAO rolRepository;

	@Override
	public Iterable<ValidadorCondicionSanitaria> getAllValidadores() {
		return null;
	}

	@Override
	public ValidadorCondicionSanitaria createValidador(ValidadorCondicionSanitaria validaddor) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ValidadorCondicionSanitaria getBarrioById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ValidadorCondicionSanitaria Updatevalidador(ValidadorCondicionSanitaria validador) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletevalidador(Long id) throws Exception {
		// TODO Auto-generated method stub

	}

}
