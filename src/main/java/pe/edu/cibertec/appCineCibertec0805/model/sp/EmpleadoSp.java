package pe.edu.cibertec.appCineCibertec0805.model.sp;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class EmpleadoSp {
	@Id
	private Integer idempleado;
	private String nomepleado;
	private String apeempleado;
}
