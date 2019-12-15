package bl.Construccion.Jugadores;


import bl.Construccion.Castillo.Castillo;
import bl.Construccion.Tropa.Tropa;

import java.util.ArrayList;

public class Jugador {
    private String nombreJugador;
    private Castillo castillo;
    private ArrayList<Tropa> tropas;
    private int[] posicionCastillo;

    public Jugador(){
        setNombreJugador("");
        setCastillo(new Castillo());
        setTropas(new ArrayList<>());
        setPosicionCastillo(new int[2]);
    }

    public Jugador(String pNombreJugador){
        setNombreJugador(pNombreJugador);
        setCastillo(new Castillo());
        setTropas(new ArrayList<>());
        setPosicionCastillo(new int[2]);
    }

    public Jugador(String nombreJugador, Castillo castillo, ArrayList<Tropa> tropas) {
        setNombreJugador(nombreJugador);
        setCastillo(castillo);
        setTropas(tropas);
        setPosicionCastillo(new int[2]);
    }

    public Jugador(String nombreJugador, int posicionCastilloX, int posicionCastilloY) {
        setNombreJugador(nombreJugador);
        setCastillo(new Castillo());
        setTropas(new ArrayList<>());
        setPosicionCastillo(new int[2]);
        getPosicionCastillo()[0] = posicionCastilloX;
        getPosicionCastillo()[1] = posicionCastilloY;
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
        castillo.setJugador(this);
    }

    public ArrayList<Tropa> getTropas() {
        return tropas;
    }

    public void setTropas(ArrayList<Tropa> tropas) {
        this.tropas = tropas;
    }

    public Tropa esMiTropa(Tropa tropa){
        Tropa response = null;
        for (Tropa tropa1:tropas) {
            if (tropa == tropa1){
                response = tropa1;
            }
        }
        return response;
    }

    public int[] getPosicionCastillo() {
        return posicionCastillo;
    }

    public void setPosicionCastillo(int[] posicionCastillo) {
        this.posicionCastillo = posicionCastillo;
    }
}
