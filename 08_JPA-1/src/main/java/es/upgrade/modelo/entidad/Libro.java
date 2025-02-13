package es.upgrade.modelo.entidad;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Libro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String titulo;
	private double precio;
	
	@ManyToOne
    @JoinColumn(name = "editorial_id")
	private Editorial editorial;
	
	 @ManyToOne
	 @JoinColumn(name = "autor_id")
	private Autor autor;
	 
	 @ManyToMany(mappedBy = "libros")
	 private List<Libreria> librerias;
}
