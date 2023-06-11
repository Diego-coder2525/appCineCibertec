package pe.edu.cibertec.appCineCibertec0805.model.sp;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class CarteleraCineSp {
	@Id
	private Integer id;
	private String titulo,genero,formato,descsala;
	private Integer asientos;
	private Date fecha;
	private String horaInicio,horaFin;
}
