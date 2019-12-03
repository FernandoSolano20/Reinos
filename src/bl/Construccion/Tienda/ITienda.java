package bl.Construccion.Tienda;

import bl.Construccion.Jugadores.Jugador;
import bl.Construccion.Tropa.Tropa;

public interface ITienda {
    String comprarTropa(Jugador pJugador, int pTipoTropa) throws Exception;
}
