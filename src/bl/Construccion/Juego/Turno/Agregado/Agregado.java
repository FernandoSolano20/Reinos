package bl.Construccion.Juego.Turno.Agregado;

import bl.Construccion.Juego.Juego;
import bl.Construccion.Juego.Turno.Iterador.IIterador;
import bl.Construccion.Juego.Turno.Iterador.Iterador_Jugadores;
import bl.Construccion.Jugadores.Jugador;

import java.util.ArrayList;

public class Agregado implements IAgregado {
    protected ArrayList<Jugador> jugadores;

    public Agregado(Juego juego){
        this.jugadores = juego.getJugadores();
    }

    public IIterador getIterador() {
        return new Iterador_Jugadores(this);
    }

    @Override
    public ArrayList<Jugador> getJugadores() {
        return this.jugadores;
    }
}