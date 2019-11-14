package bl.Construccion.Juego;

import bl.Construccion.Juego.Constructores.ConstructorTablero;

public class Director {

    public Director(){

    }

    public void construirTablero(ConstructorTablero constructorTablero){
        constructorTablero.crearJuego();
        constructorTablero.generarJugadores();
        constructorTablero.generarCastillos();
        constructorTablero.generarGemas();
        constructorTablero.generarPowerUps();
    }
}
