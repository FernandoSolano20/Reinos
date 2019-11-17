package bl.Construccion.Juego.Turno.Iterador;
import bl.Construccion.Juego.Turno.Agregado.Agregado;
import bl.Construccion.Juego.Turno.Agregado.IAgregado;
import bl.Construccion.Jugadores.Jugador;

import java.util.ArrayList;

public class Iterador_Jugadores implements IIterador{
    private IAgregado jugadores;
    private int posicion_actual = 0;

    public Iterador_Jugadores(Agregado informacionJugadores){
        setJugadores(informacionJugadores);
    }

    @Override
    public Jugador obtenerPrimerJugador() throws Exception{
        Jugador jugador = null;
        if( ! this.getJugadores().isEmpty()){
            setPosicion_actual(0);
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
        setPosicion_actual(getPosicion_actual()+1);
        if( hayMasJugadores() ){
            jugador = getJugadores().get(posicion_actual);
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
        jugador = getJugadores().get(posicion_actual);
        return jugador;
    }

    @Override
    //Metodo que determina si hay mas Jugadores dentro del arreglo, esto para verificar si hay que volver al primer jugador
    public boolean hayMasJugadores() {

        if(  getPosicion_actual() < this.getJugadores().size()){
            return true;
        }
        else{
            return false;
        }
    }

    public int getPosicion_actual() {
        return posicion_actual;
    }

    public void setPosicion_actual(int posicion_actual) {
        this.posicion_actual = posicion_actual;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores.getJugadores();
    }

    public void setJugadores(IAgregado jugadores) {
        this.jugadores = jugadores;
    }
}
