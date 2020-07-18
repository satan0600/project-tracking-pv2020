/**
 * 
 */
package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import ar.edu.unju.fi.model.Barrio;
import ar.edu.unju.fi.model.RegistroTracking;
import ar.edu.unju.fi.service.IBarrioService;
import ar.edu.unju.fi.service.IPersonaService;
import ar.edu.unju.fi.service.IRegistroService;
import ar.edu.unju.fi.service.IValidadorService;

/**
 * @author daniel-gnu
 *
 */
@Controller
public class TrackingController {
	/*
	 * @GetMapping("/") public String index() { return "index"; }
	 */
	@Autowired
	IPersonaService personaService;
	@Autowired
	IValidadorService validacionService;
	@Autowired
	IRegistroService registroService;
	@Autowired 
	IBarrioService barrioService;

	@GetMapping("/trackingForm")
	public String trackingForm(Model model) {
		model.addAttribute("trackingForm", new RegistroTracking());
		//model.addAttribute("personaList", personaService.getAllPersonas());
		model.addAttribute("validadorList", validacionService.getAllValidadores());
		model.addAttribute("registroList", registroService.getAllRegistros());
		model.addAttribute("barrioList", barrioService.getAllBarrios());
		model.addAttribute("listTab", "active");
		return "tracking-form/tracking-view";
	}
	
}
