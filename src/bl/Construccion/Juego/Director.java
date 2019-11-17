package bl.Construccion.Juego;

import bl.Construccion.Juego.Constructores.ConstructorTablero;

public class Director {

    public Director(){

    }

    public void construirTablero(ConstructorTablero constructorTablero){
        constructorTablero.crearJuego();
        constructorTablero.generarJugadores();
        constructorTablero.generarCastillos();
        constructorTablero.generarIterador();
        constructorTablero.generarGemas();
        constructorTablero.generarPowerUps();
    }
}

/// Tropas y que se muevan : Luis
//  Enlazar logica tablero con ui: Jeison
//  Movimiento: Andres
//  Casillas en tablero: Fernando


