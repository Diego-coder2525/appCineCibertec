package pe.edu.cibertec.appCineCibertec0805.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.edu.cibertec.appCineCibertec0805.model.bd.Estado;
import pe.edu.cibertec.appCineCibertec0805.model.bd.Sala;
import pe.edu.cibertec.appCineCibertec0805.model.request.SalaRequest;
import pe.edu.cibertec.appCineCibertec0805.model.response.ResultadoResponse;
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
	
	@PostMapping("/registrarSala")
	@ResponseBody
	public ResultadoResponse registrarSala(@RequestBody SalaRequest salaRequest) {
		String mensaje = "Sala registrada correctamente";
		Boolean respuesta = true;
		try{
			Sala objSala = new Sala();
			if(salaRequest.getIdsala() > 0) {
				objSala.setIdsala(salaRequest.getIdsala());
			}
			objSala.setDescsala(salaRequest.getDescsala());
			objSala.setAsientos(salaRequest.getAsientos());
			Estado objEstado = new Estado();
			objEstado.setIdestado(salaRequest.getIdestado());
			objSala.setEstado(objEstado);
			salaService.registrarSala(objSala);
		}catch(Exception e) {
			mensaje = "Sala no registrada";
			respuesta = false;
		}
		return ResultadoResponse.builder()
				.mensaje(mensaje)
				.respuesta(respuesta)
				.build();
	}
	@DeleteMapping("/eliminarSala")
	@ResponseBody
	public ResultadoResponse eliminarSala(@RequestBody SalaRequest salaRequest) {
		String mensaje = "Sala eliminada correctamente";
		Boolean respuesta = true;
		try {
			salaService.eliminarSala(salaRequest.getIdsala());
		}catch(Exception e) {
			mensaje = "Sala no eliminada";
			respuesta = false;
		}
		return ResultadoResponse.builder()
				.mensaje(mensaje)
				.respuesta(respuesta)
				.build();
	}
	
	@GetMapping("/listarSalas")
	@ResponseBody
	public List<Sala> listarSala(){
		return salaService.listarSala();
	}
}
