package pe.edu.cibertec.appCineCibertec0805.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.cibertec.appCineCibertec0805.model.bd.Empleado;
import pe.edu.cibertec.appCineCibertec0805.repository.EmpleadoRepository;
import pe.edu.cibertec.appCineCibertec0805.repository.EstadoRepository;

@Service
public class EmpleadoService {
	@Autowired
	EmpleadoRepository empleadoRepository;
	
	public List<Empleado>listarEmpleados(){
		return empleadoRepository.findAll();
	}
	
	public void registrarEmpleado(Empleado empleado) {
		empleadoRepository.registrarEmpleado(empleado.getNombre(), empleado.getApellido());
	}
}
