package bl.Construccion.Tablero;

import bl.Construccion.Construccion;
import bl.Construccion.IConstruccion;
import bl.Construccion.Tropa.Tropa;
import bl.Construccion.Tropa.TropaAtaque.TropaAtaque;

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
    public void construirEnCasilla(int pLargo, int pAncho, Construccion pConstruccion) {
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
    public String moverPieza(int origenX, int origenY, int destinoX, int destinoY) throws Exception{
        if(validarMovimiento(origenX,origenY,destinoX,destinoY)) {

            if(obtenerPiezaCasilla(destinoX,destinoY) != null) {
                throw new Exception("La casilla de destino se encuentra ocupada");
            }

            else if (obtenerPiezaCasilla(origenX,origenY) != null) {
                Construccion tropaAtaque = obtenerPiezaCasilla(origenX,origenY);
                colocarPiezaCasilla(destinoX,destinoY,tropaAtaque);
                removerPiezaCasilla(origenX,origenY);
                return "La pieza ha sido movida a: " + destinoX + "," + destinoY;
            }

            else {
                throw new Exception("No hay una pieza en la casilla de origen");
            }
        }
        else{
            throw new Exception("El movimiento solicitado es inválido");
        }
    }

    private boolean validarMovimiento(int origenX, int origenY, int destinoX, int destinoY){
        if(origenX != destinoX && origenY != destinoY){
            return false;
        }
        else{
            return true;
        }
    }

    private Construccion obtenerPiezaCasilla(int coordenadaX, int coordenadaY){
        try{

            return casillas[coordenadaX][coordenadaY].getPieza();

        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    private void colocarPiezaCasilla(int coordenadaX, int coordenadaY, Construccion pieza){

            casillas[coordenadaX][coordenadaY].setPieza(pieza);
    }

    private void removerPiezaCasilla(int coordenadaX, int coordenadaY){

        casillas[coordenadaX][coordenadaY].setPieza(null);
    }

    @Override
    public String recorrerTablero() {
        int largoTablero = getLargo();
        int anchoTablero = getAncho();
        String tablero = "";
        for(int i = 0; i < largoTablero; i++){
            for(int j =0; j < anchoTablero; j++){
                if(casillas[i][j].getPieza() != null){
                    tablero += "\t" + casillas[i][j].getPieza().getNombre();
                }
                else{
                    tablero += "\t vacio";
                }
            }
            tablero += "\n";
        }
        return tablero;
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
