package bl.Construccion.Juego;

import bl.Jugadores.Jugador;
import bl.Tablero.Tablero;

import java.util.ArrayList;

public class Juego implements IJuego{

    private int cantidadJugadores;
    private Tablero tablero;
    private ArrayList<Jugador> jugadores;

    public Juego(int cantidadJugadores, Tablero tablero) {
        this.cantidadJugadores = cantidadJugadores;
        this.tablero = tablero;
        this.jugadores = new ArrayList<>();
    }

    public int getCantidadJugadores() {
        return cantidadJugadores;
    }

    public void setCantidadJugadores(int cantidadJugadores) {
        this.cantidadJugadores = cantidadJugadores;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }

    @Override
    public void inicializarPartida(int pCantidadJugadores) {

    }

    @Override
    public void finalizarPartida() {

    }

    @Override
    public void pasarTurno() {

    }
}
