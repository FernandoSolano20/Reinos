package bl.Construccion.Juego.Turno;

import bl.Construccion.Jugadores.Jugador;
import bl.Construccion.Tablero.Tablero;

public class Turno {
    private Jugador jugador;
    private Tablero tablero;
    private int movimientosPermitidos;

    public Turno(Tablero tablero, Jugador jugador, int movimientosPermitidos) {
        setTablero(tablero);
        setJugador(jugador);
        setMovimientosPermitidos(movimientosPermitidos);
    }

    public Turno(Tablero tablero, Jugador jugador) {
        setTablero(tablero);
        setJugador(jugador);
        setMovimientosPermitidos(0);
    }

    public Turno() {
        setTablero(null);
        setJugador(null);
        setMovimientosPermitidos(0);
    }

    public Tablero getTablero() {
        return tablero;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public int getMovimientosPermitidos() {
        return movimientosPermitidos;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public void setMovimientosPermitidos(int movimientosPermitidos) {
        this.movimientosPermitidos = movimientosPermitidos;
    }


}
