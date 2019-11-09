package bl.Construccion.Tablero;

import bl.Construccion.Castillo.Castillo;
import bl.Construccion.IConstruccion;

public class Tablero implements ITablero{
	private Casilla[][] casillas;
    private int ancho; //width
    private int largo; //height

    public Tablero(int ancho, int largo) {
        setAncho(ancho);
        setLargo(largo);
        casillas  = new Casilla[ancho][largo];
        generarCasillas(ancho,largo);
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }
    public int getLargo() {
        return largo;
    }

    public void setLargo(int largo) {
        this.largo = largo;
    }

    public Casilla[][] getCasillas() {
        return casillas;
    }

    public void setCasillas(Casilla[][] casillas) {
        this.casillas = casillas;
    }

    public void construirEnCasilla(int pAncho, int pLargo, IConstruccion pConstruccion) {
        this.getCasillas()[pAncho][pLargo].setPieza(pConstruccion);
    }

    private void generarCasillas(int pAncho, int pLargo){
        for(int i = 0; i < pAncho; i++){
            for(int j = 0; j < pLargo; j++){
                this.casillas[i][j] = new Casilla();
            }
        }
    }

    public void generarGemas() {

    }

    public void generarPowerUps() {

    }

    public void generarCastillos() {

    }
}
