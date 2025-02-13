package es.upgrade.modelo.entidad;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Data
@Entity
public class Libreria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	private String nombreDueno;
	private String direccion;
	
	 @ManyToMany
	 @JoinTable(
	      name = "libreria_libro",
	      joinColumns = @JoinColumn(name = "libreria_id"),
	      inverseJoinColumns = @JoinColumn(name = "libro_id")
	    )
	private List<Libro> libros;

}
