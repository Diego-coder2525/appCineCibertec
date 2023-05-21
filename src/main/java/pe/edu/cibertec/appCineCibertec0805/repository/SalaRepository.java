package pe.edu.cibertec.appCineCibertec0805.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.cibertec.appCineCibertec0805.model.bd.Sala;

@Repository
public interface SalaRepository extends JpaRepository<Sala, Integer>{

}
