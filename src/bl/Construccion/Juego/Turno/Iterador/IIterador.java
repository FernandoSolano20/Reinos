package bl.Construccion.Juego.Turno.Iterador;

import bl.Construccion.Jugadores.Jugador;

public interface IIterador {
    Jugador obtenerPrimerJugador()throws Exception;
    Jugador obtenerSiguienteJugador()throws Exception;
    Jugador obtenerJugadorActual();
    boolean hayMasJugadores();

}
