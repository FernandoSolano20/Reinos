package bl.Construccion.Tablero;

import bl.Construccion.Construccion;

public interface ITablero {
    void construirEnCasilla(int pLargo, int pAncho, Construccion pConstruccion);
    int moverPieza(int origenX, int origenY, int destinoX, int destinoY, int pValorDado) throws Exception;
    String recorrerTablero();
}
