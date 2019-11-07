package bl.Construccion.Tablero;

import bl.Construccion.Castillo.Castillo;
import bl.Construccion.IConstruccion;

public class Tablero implements ITablero{
    private Casilla[][] casillas;
    private int largo;
    private int ancho;

    public Tablero(int largo, int ancho) {
        setLargo(largo);
        setAncho(ancho);
        casillas  = new Casilla[largo][ancho];
        generarCasillas(largo,ancho);
    }

    public int getLargo() {
        return largo;
    }

    public void setLargo(int largo) {
        this.largo = largo;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public Casilla[][] getCasillas() {
        return casillas;
    }

    public void setCasillas(Casilla[][] casillas) {
        this.casillas = casillas;
    }

    @Override
    public void construirEnCasilla(int pLargo, int pAncho, IConstruccion pConstruccion) {
        this.getCasillas()[pLargo][pAncho].setPieza(pConstruccion);
    }

    private void generarCasillas(int pLargo, int pAncho){
        for(int i = 0; i < pLargo; i++){
            for(int j = 0; j < pAncho; j++){
                this.casillas[i][j] = new Casilla();
            }
        }
    }

    @Override
    public void generarGemas() {

    }

    @Override
    public void generarPowerUps() {

    }

    @Override
    public void generarCastillos() {

    }
}
