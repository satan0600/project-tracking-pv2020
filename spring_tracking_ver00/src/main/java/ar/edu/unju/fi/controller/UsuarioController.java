/**
 * 
 */
package ar.edu.unju.fi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ar.edu.unju.fi.model.Usuario;
import ar.edu.unju.fi.repository.IRolDAO;
import ar.edu.unju.fi.repository.IUsuarioDAO;
import ar.edu.unju.fi.service.IUsuarioService;

/**
 * @author daniel-gnu
 *
 */
@Controller
public class UsuarioController {
	@Autowired
	IRolDAO rolRepository;
	@Autowired
	IUsuarioDAO usuarioRepository;
	@Autowired
	IUsuarioService usuarioService;

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/usuarioForm")
	public String getUsuarioForm(Model model) {
		/*
		 * model.addAttribute("usuarioForm", new Usuario());
		 * model.addAttribute("roles",rolRepository.findAll());
		 * model.addAttribute("usuarioList", usuarioService.getAllUsuarios());
		 * model.addAttribute("listaTab","active");
		 */
		model.addAttribute("usuarioForm", new Usuario());
		model.addAttribute("usuarioList", usuarioService.getAllUsuarios());
		model.addAttribute("roles", rolRepository.findAll());
		model.addAttribute("listTab", "active");
		return "user-form/usuario-view";
	}

	@PostMapping("/usuarioForm")
	public String createUsuario(@Valid @ModelAttribute("usuarioForm") Usuario usuario, BindingResult result,
			ModelMap model) {
		if (result.hasErrors()) {
			model.addAttribute("usuarioForm", usuario);
			model.addAttribute("formTab", "active");
		} else {
			try {
				usuarioService.createUsuario(usuario);

				model.addAttribute("usuarioForm", new Usuario());
				model.addAttribute("listTab", "active");

			} catch (Exception e) {
				model.addAttribute("formErrorMessage", e.getMessage());
				model.addAttribute("usuarioForm", usuario);
				model.addAttribute("formTab", "active");
				model.addAttribute("usuarioList", usuarioService.getAllUsuarios());
				model.addAttribute("roles", rolRepository.findAll());
			}
		}
		model.addAttribute("usuarioList", usuarioService.getAllUsuarios());
		model.addAttribute("roles", rolRepository.findAll());

		return ("user-form/usuario-view");
	}

	@GetMapping("/editUsuario/{id}")
	public String getEditUsuarioForm(Model model, @PathVariable(name = "id") Long id) throws Exception {
		Usuario usuarioToEdit = usuarioService.getUsuarioById(id);
		model.addAttribute("usuarioForm", usuarioToEdit);
		model.addAttribute("usuarioList", usuarioService.getAllUsuarios());
		model.addAttribute("roles", rolRepository.findAll());
		model.addAttribute("formTab", "active");
		model.addAttribute("editMode", "true");
		return "user-form/usuario-view";
	}

	@PostMapping("/editUsuario")
	public String postEditUsuarioForm(@Valid @ModelAttribute("usuarioForm") Usuario usuario, BindingResult result,
			ModelMap model) {
		if (result.hasErrors()) {
			model.addAttribute("usuarioForm", usuario);
			model.addAttribute("formTab", "active");
			model.addAttribute("editMode", "true");
		} else {
			try {
				usuarioService.updateUsuario(usuario);
				model.addAttribute("usuarioForm", new Usuario());
				model.addAttribute("listTab", "active");

			} catch (Exception e) {
				model.addAttribute("formErrorMessage", e.getMessage());
				model.addAttribute("usuarioForm", usuario);
				model.addAttribute("formTab", "active");
				model.addAttribute("usuarioList", usuarioService.getAllUsuarios());
				model.addAttribute("roles", rolRepository.findAll());
				model.addAttribute("editMode", "true");
			}
		}
		model.addAttribute("usuarioList", usuarioService.getAllUsuarios());
		model.addAttribute("roles", rolRepository.findAll());

		return ("user-form/usuario-view");
	}

	@GetMapping("/usuarioForm/cancel")
	public String cancelEditUser(ModelMap model) {
		return "redirect:/usuarioForm";
	}

	@GetMapping("/deleteUsuario/{id}")
	public String deleteUsuario(Model model, @PathVariable(name = "id") Long id) {
		try {
			usuarioService.deleteUsuario(id);
		} catch (Exception e) {
			model.addAttribute("listErrorMessage", e.getMessage());
			// TODO: handle exception
		}
		return getUsuarioForm(model);
	}
}