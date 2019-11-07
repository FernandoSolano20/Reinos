package bl.Construccion.Juego.Constructores;

import bl.Construccion.Juego.Juego;
import bl.Construccion.Jugadores.Jugador;
import bl.Construccion.Tablero.Tablero;

public abstract class ConstructorTablero {
    protected Juego juego;

    public Juego obtenerJuego(){
        return this.juego;
    }

    public void crearJuego(){
        this.juego = new Juego();
    }

    protected Jugador crearJugador(String pNombreJugador){
        return new Jugador(pNombreJugador);
    }

    //Añade la cantidad de jugadores al ArrayList de jugadores en la clase Juego
    public abstract void generarJugadores();
    //Añade los castillos de los jugadores en el ArrayList en el tablero
    public abstract void generarCastillos();
    //Genera una cantidad determinada de gemas en el tablero
    public abstract void generarGemas();
    //Genera aleatoriamente una cantidad definida de PowerUps en el tablero
    public abstract void generarPowerUps();
}
