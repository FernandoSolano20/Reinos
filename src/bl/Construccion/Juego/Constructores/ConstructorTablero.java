package bl.Construccion.Juego.Constructores;

import bl.Construccion.Juego.Juego;
import bl.Construccion.Jugadores.Jugador;
import bl.Construccion.MetodoFabrica.FabricaCasillas;
import bl.Construccion.Tablero.Casilla;
import bl.Construccion.Tablero.Tablero;

import java.util.Random;

public abstract class ConstructorTablero {
    protected Juego juego;
    private FabricaCasillas fabricaCasillas = new FabricaCasillas();

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
    //Crea el iterador que permite manejar los turnos de los jugadores
    public abstract void generarIterador();
    //Genera una cantidad determinada de gemas en el tablero
    public void generarGemas(){
        int[] puntos = new int[2];
        int powerUp = 0;
        Casilla casilla = null;
        Tablero tablero = juego.getTablero();
        int ancho = tablero.getAncho() - 1;
        int largo = tablero.getLargo() - 1;
        for(int i = 0; i < 14; i++) {
            do {
                puntos = obtenerPuntosAletorios(ancho, largo);
                casilla = tablero.getCasillas()[puntos[0]][puntos[1]];
            } while (!tablero.esCasillasValida(casilla) && casilla.tieneRecurso());
            powerUp = numeroAleatorio(1, 3);
            casilla.setRecurso(fabricaCasillas.crearGemas(powerUp));
        }
    }
    //Genera aleatoriamente una cantidad definida de PowerUps en el tablero
    public void generarPowerUps(){
        int[] puntos = new int[2];
        int powerUp = 0;
        Casilla casilla = null;
        Tablero tablero = juego.getTablero();
        int ancho = tablero.getAncho() - 1;
        int largo = tablero.getLargo() - 1;
        for(int i = 0; i < 14; i++) {
            do {
                puntos = obtenerPuntosAletorios(ancho, largo);
                casilla = tablero.getCasillas()[puntos[0]][puntos[1]];
            } while (!tablero.esCasillasValida(casilla) && casilla.tieneRecurso());
            powerUp = numeroAleatorio(1, 4);
            casilla.setRecurso(fabricaCasillas.crearPowerUp(powerUp));
        }
    }

    private int numeroAleatorio(int min, int max){
        if (min >= max) {
            throw new IllegalArgumentException("Error maximo debe ser mayor a minimo");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    private int[] obtenerPuntosAletorios(int ancho, int largo){
        int[] puntos =  new int[2];
        puntos[0] = numeroAleatorio(0,ancho);
        puntos[1] = numeroAleatorio(0,largo);
        return puntos;
    }
}
