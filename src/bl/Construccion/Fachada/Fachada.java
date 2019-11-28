package bl.Construccion.Fachada;

import bl.Construccion.Juego.Constructores.ConstructorCuatroJugadores;
import bl.Construccion.Juego.Constructores.ConstructorDosJugadores;
import bl.Construccion.Juego.Constructores.ConstructorTablero;
import bl.Construccion.Juego.Constructores.ConstructorTresJugadores;
import bl.Construccion.Juego.Director;
import bl.Construccion.Juego.Juego;

public class Fachada {
	private Director directorConstruccion;

	public Fachada() {
		directorConstruccion = new Director();
	}

	public Juego construirJuego(int pCantidadJugadores) {
		Juego juegoConstruido;

		switch (pCantidadJugadores) {
		case 2:
			ConstructorTablero tableroPara2 = new ConstructorDosJugadores();
			directorConstruccion.construirTablero(tableroPara2);
			juegoConstruido = tableroPara2.obtenerJuego();
			break;

		case 3:
			ConstructorTablero tableroPara3 = new ConstructorTresJugadores();
			directorConstruccion.construirTablero(tableroPara3);
			juegoConstruido = tableroPara3.obtenerJuego();
			break;

		case 4:
			ConstructorTablero tableroPara4 = new ConstructorCuatroJugadores();
			directorConstruccion.construirTablero(tableroPara4);
			juegoConstruido = tableroPara4.obtenerJuego();
			break;

		default:
			juegoConstruido = null;
		}
		return juegoConstruido;
	}
}
