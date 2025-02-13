package modelo.entidad;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "coches")
public class Coche {
	@Id
	private int id;
	private String marca;
	private String modelo;
	private long km;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public long getKm() {
		return km;
	}
	public void setKm(long km) {
		this.km = km;
	}
	
	
}
