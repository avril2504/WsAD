package junit5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelo.entidad.Videojuego;
import modelo.negocio.GestorVideojuego;

class GestorVideojuegoTest {
	private GestorVideojuego gf;

	@Test
	void videojuegoNoExiste() {
		gf = new GestorVideojuego();
		Videojuego v = new Videojuego();
		v.setNombre("Juego2");
		gf.validar(v);
	}

}
