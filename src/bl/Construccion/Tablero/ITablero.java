package bl.Construccion.Tablero;

import bl.Construccion.IConstruccion;

public interface ITablero {
    void generarGemas();
    void generarPowerUps();
    void generarCastillos();
    void construirEnCasilla(int pLargo, int pAncho, IConstruccion pConstruccion);
}
