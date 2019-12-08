package bl.Construccion;

import bl.Construccion.Jugadores.Jugador;
import bl.Construccion.Tablero.Casilla;

public abstract class Construccion implements IConstruccion{
    private int vida;
    private int id;
    private String Nombre;
    private Casilla casilla;
    private Jugador jugador;

    public Construccion() {
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public Casilla getCasilla() {
        return casilla;
    }

    public void setCasilla(Casilla casilla) {
        this.casilla = casilla;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }
}
