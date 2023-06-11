package pe.edu.cibertec.appCineCibertec0805.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.cibertec.appCineCibertec0805.model.sp.CarteleraCineSp;

@Repository
public interface CarteleraCineSpRepository extends JpaRepository<CarteleraCineSpRepository, Integer>{
	//Se podria poner el codigo de la consulta directamente pero es mas complicado de mantener
	@Query(value = "call sp_listarCartelera",nativeQuery = true)
	public List<CarteleraCineSp> listarCartelera();
	
	//
}
