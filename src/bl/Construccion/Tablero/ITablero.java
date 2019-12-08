package bl.Construccion.Tablero;

import bl.Construccion.Construccion;
import bl.Construccion.Juego.Turno.Turno;

public interface ITablero {
    void construirEnCasilla(int pLargo, int pAncho, Construccion pConstruccion);
    int moverPieza(int origenX, int origenY, int destinoX, int destinoY, Turno pTurno) throws Exception;
    String recorrerTablero();
}
