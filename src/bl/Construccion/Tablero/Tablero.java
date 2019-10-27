package bl.Construccion.Tablero;

public class Tablero implements ITablero{
    private Casilla[][] casillas;
    private int largo;
    private int ancho;

    public Tablero(int largo, int ancho) {
        setLargo(largo);
        setAncho(ancho);
        casillas  = new Casilla[largo][ancho];

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
