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
import ar.edu.unju.fi.model.Usuario;
import ar.edu.unju.fi.service.IBarrioService;

/**
 * @author daniel-gnu
 *
 */
@Controller
public class BarrioController {
	@Autowired
	IBarrioService barrioService;

	/*
	 * @GetMapping("/") public String index() { return "index"; }
	 */

	@GetMapping("/barrioForm")
	public String barriorForm(Model model) {
		model.addAttribute("barrioForm", new Barrio());
		model.addAttribute("barrioList", barrioService.getAllBarrios());
		model.addAttribute("listTab", "active");
		return "barrio-form/barrio-view";

	}

	@PostMapping("/barrioForm")
	public String createBarrio(@Valid @ModelAttribute("barrioForm") Barrio barrio, BindingResult result,
			ModelMap model) {
		if (result.hasErrors()) {
			model.addAttribute("barrioForm", barrio);
			model.addAttribute("formTab", "active");
		} else {
			try {
				barrioService.createBarrio(barrio);
				model.addAttribute("barrioForm", new Barrio());
				model.addAttribute("listTab", "active");

			} catch (Exception e) {
				model.addAttribute("formErrorMessage", e.getMessage());
				model.addAttribute("barrioForm", barrio);
				model.addAttribute("formTab", "active");
				model.addAttribute("barrioList", barrioService.getAllBarrios());

			}
		}
		model.addAttribute("barrioList", barrioService.getAllBarrios());

		return "barrio-form/barrio-view";
	}

}
