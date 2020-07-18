package ar.edu.unju.fi.service.Imp;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.edu.unju.fi.model.Usuario;
import ar.edu.unju.fi.repository.IUsuarioDAO;
import ar.edu.unju.fi.service.IUsuarioService;

@Service
public class UsuarioServiceImp implements IUsuarioService {
	@Autowired
	IUsuarioDAO usuarioRepository;

	@Override
	public Iterable<Usuario> getAllUsuarios() {
		return usuarioRepository.findAll();
	}

	private boolean checkNombreUsuarioAvailable(Usuario usuario) throws Exception {
		Optional<Usuario> usuarioFound = usuarioRepository.findByNombreU(usuario.getNombreU());
		if (usuarioFound.isPresent()) {
			throw new Exception("nombreUsuario no disponible");

		}
		return true;
	}

	@Override
	public Usuario createUsuario(Usuario usuario) throws Exception {
		if (checkNombreUsuarioAvailable(usuario)) {
			usuario = usuarioRepository.save(usuario);
		}
		return usuario;
	}

	@Override
	public Usuario getUsuarioById(Long id) throws Exception {
		return usuarioRepository.findById(id).orElseThrow(() -> new Exception("el usuario para edicion no existe"));
	}

	@Override
	public Usuario updateUsuario(Usuario fromUsuario) throws Exception {
		Usuario toUsuario = getUsuarioById(fromUsuario.getId());
		mapUsuario(fromUsuario, toUsuario);
		return usuarioRepository.save(toUsuario);

	}

	private void mapUsuario(Usuario from, Usuario to) {
		to.setNombreU(from.getNombreU());
		to.setNombreR(from.getNombreR());
		to.setApellidoR(from.getApellidoR());
		to.setRoles(from.getRoles());

	}

	@Override
	public void deleteUsuario(Long id) throws Exception {
		Usuario usuario = getUsuarioById(id);
		usuarioRepository.delete(usuario);
	}

}
