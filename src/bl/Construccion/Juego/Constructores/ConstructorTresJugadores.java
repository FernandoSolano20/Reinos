package bl.Construccion.Juego.Constructores;

import bl.Construccion.Juego.Turno.Agregado.Agregado;
import bl.Construccion.Jugadores.Jugador;

public class ConstructorTresJugadores extends ConstructorTablero {
	@Override
	public void generarJugadores() {
		this.juego.agregarJugador(crearJugador("Jugador 1",0,0));
		this.juego.agregarJugador(crearJugador("Jugador 2",9,0));
		this.juego.agregarJugador(crearJugador("Jugador 3",9,9));
	}

	@Override
	public void generarCastillos() {
		Jugador jugador1 = this.juego.getJugadores().get(0);
		Jugador jugador2 = this.juego.getJugadores().get(1);
		Jugador jugador3 = this.juego.getJugadores().get(2);
		jugador1.getCastillo().setCasilla(juego.getTablero().obtenerCasilla(jugador1.getPosicionCastillo()[0], jugador1.getPosicionCastillo()[1]));
		jugador2.getCastillo().setCasilla(juego.getTablero().obtenerCasilla(jugador2.getPosicionCastillo()[0], jugador2.getPosicionCastillo()[1]));
		jugador3.getCastillo().setCasilla(juego.getTablero().obtenerCasilla(jugador3.getPosicionCastillo()[0], jugador3.getPosicionCastillo()[1]));
		this.juego.getTablero().construirEnCasilla(jugador1.getPosicionCastillo()[0], jugador1.getPosicionCastillo()[1], jugador1.getCastillo());
		this.juego.getTablero().construirEnCasilla(jugador2.getPosicionCastillo()[0], jugador2.getPosicionCastillo()[1], jugador2.getCastillo());
		this.juego.getTablero().construirEnCasilla(jugador3.getPosicionCastillo()[0], jugador3.getPosicionCastillo()[1], jugador3.getCastillo());
	}

    @Override
    public void generarIterador() {
        Agregado agregado = new Agregado(this.juego);
        this.juego.setIterador(agregado.getIterador());
    }




}

