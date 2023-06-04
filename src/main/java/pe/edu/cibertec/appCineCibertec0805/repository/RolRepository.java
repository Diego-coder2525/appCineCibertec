package pe.edu.cibertec.appCineCibertec0805.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.cibertec.appCineCibertec0805.model.bd.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer>{
	Rol findByNomrol(String rolname);
	
}
