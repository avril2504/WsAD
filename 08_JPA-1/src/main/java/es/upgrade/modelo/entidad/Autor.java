package es.upgrade.modelo.entidad;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
public class Autor {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	private String apellidos;
	
	@Temporal(TemporalType.DATE)
	private String fechaNacimiento;
	
	@OneToMany(mappedBy = "autor", cascade = CascadeType.ALL)
	private List<Libro> libros;

}
