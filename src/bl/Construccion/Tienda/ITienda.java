package bl.Construccion.Tienda;

import bl.Construccion.Jugadores.Jugador;

public interface ITienda {
    boolean comprarTropa(Jugador pJugador, int pTipoTropa) throws Exception;
}
