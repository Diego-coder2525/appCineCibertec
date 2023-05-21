package pe.edu.cibertec.appCineCibertec0805.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.cibertec.appCineCibertec0805.model.bd.Estado;
import pe.edu.cibertec.appCineCibertec0805.repository.EstadoRepository;

@Service
public class EstadoService {

	@Autowired
	EstadoRepository estadoRepository;
	

	public List<Estado> listarEstados(){
		return estadoRepository.findAll();
	}
	
	public void registrarEstado(Estado estado) {
		estadoRepository.save(estado);
	}
}
