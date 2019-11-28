package bl.Construccion.Juego.Turno.Agregado;

import bl.Construccion.Juego.Turno.Iterador.IIterador;
import bl.Construccion.Jugadores.Jugador;

import java.util.ArrayList;

public interface IAgregado {
    IIterador getIterador();
    ArrayList<Jugador> getJugadores();
}
