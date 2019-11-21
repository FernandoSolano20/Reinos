package bl.Construccion.Tablero;

import bl.Construccion.Construccion;

public interface ITablero {
    void generarGemas();
    void generarPowerUps();
    void generarCastillos();
    void construirEnCasilla(int pLargo, int pAncho, Construccion pConstruccion);
    String moverPieza(int origenX, int origenY, int destinoX, int destinoY) throws Exception;
    String recorrerTablero();
}
