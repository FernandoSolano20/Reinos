package bl.Construccion.Juego.Constructores;

import bl.Construccion.Castillo.Castillo;
import bl.Construccion.Jugadores.Jugador;

public class ConstructorCuatroJugadores extends ConstructorTablero {
    @Override
    public void generarJugadores() {
        this.juego.agregarJugador(crearJugador("Jugador 1"));
        this.juego.agregarJugador(crearJugador("Jugador 2"));
        this.juego.agregarJugador(crearJugador("Jugador 3"));
        this.juego.agregarJugador(crearJugador("Jugador 4"));
    }

    @Override
    public void generarCastillos() {
        Jugador jugador1 = this.juego.getJugadores().get(0);
        Jugador jugador2 = this.juego.getJugadores().get(1);
        Jugador jugador3 = this.juego.getJugadores().get(2);
        Jugador jugador4 = this.juego.getJugadores().get(3);
        this.juego.getTablero().construirEnCasilla(0,9,jugador1.getCastillo());
        this.juego.getTablero().construirEnCasilla(9,0,jugador2.getCastillo());
        this.juego.getTablero().construirEnCasilla(0,0,jugador3.getCastillo());
        this.juego.getTablero().construirEnCasilla(9,9,jugador4.getCastillo());
    }

    @Override
    public void generarGemas() {

    }

    @Override
    public void generarPowerUps() {

    }
}
