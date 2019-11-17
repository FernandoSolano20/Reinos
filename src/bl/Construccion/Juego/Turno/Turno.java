package bl.Construccion.Juego.Turno;

import bl.Construccion.Jugadores.Jugador;
import bl.Construccion.Tablero.Tablero;

public class Turno {
    private Jugador jugador;
    private Tablero tablero;

    public Turno(Tablero tablero, Jugador jugador) {
        setTablero(tablero);
        setJugador(jugador);
    }

    public Turno() {
        setTablero(null);
        setJugador(null);
    }

    public Tablero getTablero() {
        return tablero;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }


}
