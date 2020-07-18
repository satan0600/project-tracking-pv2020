/**
 * 
 */
package ar.edu.unju.fi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ar.edu.unju.fi.model.Barrio;
import ar.edu.unju.fi.model.Persona;
import ar.edu.unju.fi.model.RegistroTracking;
import ar.edu.unju.fi.model.Usuario;
import ar.edu.unju.fi.service.IBarrioService;
import ar.edu.unju.fi.service.IPersonaService;

/**
 * @author daniel-gnu
 *
 */
@Controller
public class PersonaController {
	@Autowired
	IPersonaService personaService;
	@Autowired
	IBarrioService barrioService;
	@Autowired
	private Persona persona;
	

	/*
	 * @Autowired private Persona personaAux;
	 */
	@GetMapping("/personaForm")
	public String getPersonaForm(Model model) {
		model.addAttribute("personaForm", new Persona());
		model.addAttribute("personaList", personaService.getAllPersonas());
		model.addAttribute("listTab", "active");
		return "persona-form/persona-view";
	}

	@PostMapping("/personaForm")
	public String createPersona(@Valid @ModelAttribute("personaForm") Persona persona, BindingResult result,ModelMap model) {
		if (result.hasErrors()) {
			model.addAttribute("personaForm", persona);
			model.addAttribute("formTab", "active");
		} else {
			try {
				personaService.createPersona(persona);

				model.addAttribute("personaForm", new Persona());
				model.addAttribute("listTab", "active");

			} catch (Exception e) {
				model.addAttribute("formErrorMessage", e.getMessage());
				model.addAttribute("personaForm", persona);
				model.addAttribute("formTab", "active");
				model.addAttribute("personaList", personaService.getAllPersonas());
				model.addAttribute("barrioList", barrioService.getAllBarrios());
			}
		}
		model.addAttribute("personaList", personaService.getAllPersonas());
		model.addAttribute("barrioList", barrioService.getAllBarrios());
		return ("persona-form/persona-view");
	}

}
