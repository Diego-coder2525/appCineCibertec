package pe.edu.cibertec.appCineCibertec0805.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.edu.cibertec.appCineCibertec0805.model.bd.Empleado;
import pe.edu.cibertec.appCineCibertec0805.model.bd.Estado;
import pe.edu.cibertec.appCineCibertec0805.model.bd.Sala;
import pe.edu.cibertec.appCineCibertec0805.model.request.SalaRequest;
import pe.edu.cibertec.appCineCibertec0805.model.response.ResultadoResponse;
import pe.edu.cibertec.appCineCibertec0805.service.EmpleadoService;

@Controller
@RequestMapping("/empleado")
public class EmpleadoController {
	@Autowired
	private EmpleadoService empleadoService;

	@GetMapping("frmempleado")
	public String frmempleado(Model model) {
		model.addAttribute("listaEmpleados", empleadoService.listarEmpleados());
		return "empleado/frmempleado";
	}

	@GetMapping("/listarEmpleados")
	@ResponseBody
	public List<Empleado> listarEmpleados() {
		return empleadoService.listarEmpleados();
	}
	
	@PostMapping("/registrarEmpleado")
	@ResponseBody
	public ResultadoResponse registrarEmpleado(@RequestBody Empleado empleado) {
		String mensaje = "Empleado registrada correctamente";
		Boolean respuesta = true;
		try{
			empleadoService.registrarEmpleado(empleado);
		}catch(Exception e) {
			mensaje = "Empleado no registrado";
			respuesta = false;
		}
		return ResultadoResponse.builder()
				.mensaje(mensaje)
				.respuesta(respuesta)
				.build();
	}
}
