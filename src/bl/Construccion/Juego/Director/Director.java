package bl.Construccion.Juego.Director;

import bl.Construccion.Juego.Constructores.ConstructorTablero;

public class Director {

	public Director() {

	}

	public void construirTablero(ConstructorTablero constructorTablero) {
		constructorTablero.crearJuego();
		constructorTablero.generarJugadores();
		constructorTablero.generarCastillos();
		constructorTablero.generarIterador();
		constructorTablero.generarPrimerTurno();
		constructorTablero.generarGemas();
		constructorTablero.generarPowerUps();
	}
}


