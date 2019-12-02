package bl.Construccion.Juego.Turno.Iterador;
import bl.Construccion.Juego.Turno.Agregado.Agregado;
import bl.Construccion.Juego.Turno.Agregado.IAgregado;
import bl.Construccion.Jugadores.Jugador;

import java.util.ArrayList;

public class Iterador_Jugadores implements IIterador{
    private IAgregado jugadores;
    private int posicionActual = 0;

    public Iterador_Jugadores(Agregado informacionJugadores){
        setJugadores(informacionJugadores);
    }

    @Override
    public Jugador obtenerPrimerJugador() throws Exception{
        Jugador jugador = null;
        if( ! this.getJugadores().isEmpty()){
            setPosicionActual(0);
            jugador = this.getJugadores().get(0);
        }
        else{
            throw new Exception("No se encontraron jugadores en la lista dde jugadores");
        }
        return jugador;
    }

    @Override
    public Jugador obtenerSiguienteJugador() throws Exception{
        Jugador jugador = null;
        setPosicionActual(getPosicionActual()+1);
        if( hayMasJugadores() ){
            jugador = getJugadores().get(posicionActual);
        }
        else{
            // Si se encuentra en la ultima posicion, inicia de nuevo la lista y le da el turno al primer jugador
            jugador = obtenerPrimerJugador();
        }
        return jugador;
    }

    @Override
    public Jugador obtenerJugadorActual() {
        Jugador jugador = null;
        jugador = getJugadores().get(posicionActual);
        return jugador;
    }

    @Override
    //Metodo que determina si hay mas Jugadores dentro del arreglo, esto para verificar si hay que volver al primer jugador
    public boolean hayMasJugadores() {

        if(  getPosicionActual() < this.getJugadores().size()){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public int getPosicionActual() {
        return posicionActual;
    }

    public void setPosicionActual(int posicionActual) {
        this.posicionActual = posicionActual;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores.getJugadores();
    }

    public void setJugadores(IAgregado jugadores) {
        this.jugadores = jugadores;
    }
}
