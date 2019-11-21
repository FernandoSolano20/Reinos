package bl.Construccion.Juego.Constructores;

import bl.Construccion.Juego.Turno.Agregado.Agregado;
import bl.Construccion.Jugadores.Jugador;
import bl.Construccion.Tablero.Casilla;

public class ConstructorDosJugadores extends ConstructorTablero {
	@Override
	public void generarJugadores() {
		this.juego.agregarJugador(crearJugador("Jugador 1"));
		this.juego.agregarJugador(crearJugador("Jugador 2"));
	}

	@Override
	public void generarCastillos() {
		Jugador jugador1 = this.juego.getJugadores().get(0);
		Jugador jugador2 = this.juego.getJugadores().get(1);
		this.juego.getTablero().construirEnCasilla(0, 0, jugador1.getCastillo());
		this.juego.getTablero().construirEnCasilla(9, 9, jugador2.getCastillo());
	}

    @Override
    public void generarIterador() {
        Agregado agregado = new Agregado(this.juego);
        this.juego.setIterador(agregado.getIterador());
    }




	}
}
