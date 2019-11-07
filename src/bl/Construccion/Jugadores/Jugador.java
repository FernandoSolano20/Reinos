package bl.Construccion.Jugadores;

import bl.Construccion.Castillo.Castillo;
import bl.Construccion.Tropa.ITropa;

import java.util.ArrayList;

public class Jugador {
    private String nombreJugador;
    private Castillo castillo;
    private ArrayList<ITropa> tropas;

    public Jugador(){
        setNombreJugador("");
        setCastillo(new Castillo());
        setTropas(new ArrayList<>());
    }

    public Jugador(String pNombreJugador){
        setNombreJugador(pNombreJugador);
        setCastillo(new Castillo());
        setTropas(new ArrayList<>());
    }

    public Jugador(String nombreJugador, Castillo castillo, ArrayList<ITropa> tropas) {
        setNombreJugador(nombreJugador);
        setCastillo(castillo);
        setTropas(tropas);
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public Castillo getCastillo() {
        return castillo;
    }

    public void setCastillo(Castillo castillo) {
        this.castillo = castillo;
    }

    public ArrayList<ITropa> getTropas() {
        return tropas;
    }

    public void setTropas(ArrayList<ITropa> tropas) {
        this.tropas = tropas;
    }
}
