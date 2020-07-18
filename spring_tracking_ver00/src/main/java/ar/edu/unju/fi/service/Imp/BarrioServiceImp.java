/**
 * 
 */
package ar.edu.unju.fi.service.Imp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.edu.unju.fi.model.Barrio;
import ar.edu.unju.fi.repository.IBarrioDAO;
import ar.edu.unju.fi.service.IBarrioService;

/**
 * @author daniel-gnu
 *
 */
@Service
public class BarrioServiceImp implements IBarrioService {
	@Autowired
	IBarrioDAO barrioRepository;

	@Override
	public Iterable<Barrio> getAllBarrios() {
		return barrioRepository.findAll();

	}

	private boolean checkNombreBarrioAvaible(Barrio barrio) throws Exception {
		String nombre;
		List<Barrio> barrioFound = barrioRepository.findAll();
		nombre = barrio.getNombre();
		if (barrioFound.contains(nombre)) {
			throw new Exception("nombreBarrio no encontrado");
		}
		return true;
	}

	@Override
	public Barrio createBarrio(Barrio barrio) throws Exception {
		if (checkNombreBarrioAvaible(barrio)) {
			barrio = barrioRepository.save(barrio);
		}
		return barrio;
	}

	@Override
	public Barrio getBarrioById(Long id) throws Exception {
		return barrioRepository.findById(id).orElseThrow(() -> new Exception("el usuario para edicion no existe"));
	}

	private void mapBarrio(Barrio from, Barrio to) {
		to.setNombre(from.getNombre());
	}

	@Override
	public Barrio UpdateBarrio(Barrio fromBarrio) throws Exception {
		Barrio toBarrio = getBarrioById(fromBarrio.getId());
		mapBarrio(fromBarrio, toBarrio);
		return barrioRepository.save(toBarrio);
	}

	@Override
	public void deleteBarrio(Long id) throws Exception {
		Barrio barrio = getBarrioById(id);
		barrioRepository.delete(barrio);
	}

}
