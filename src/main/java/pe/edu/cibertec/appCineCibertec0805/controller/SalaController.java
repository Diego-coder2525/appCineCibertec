package pe.edu.cibertec.appCineCibertec0805.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.cibertec.appCineCibertec0805.service.SalaService;

@Controller
@RequestMapping("/sala")
public class SalaController {
	@Autowired
	SalaService salaService;
	
	@GetMapping("/frmSala")
	public String frmMantSala(Model model) {
		model.addAttribute("listaSala",salaService.listarSala());
		return "sala/frmSala";
	}
}
