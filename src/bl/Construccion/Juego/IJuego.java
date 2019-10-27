package bl.Construccion.Juego;

public interface IJuego {
    //Metodo utilizado para configurar los parametros para iniciar el juego
    void inicializarPartida(int pCantidadJugadores);

    //Metodo utilziado para finalizar la partida y determinar el jugador ganador
    void finalizarPartida();

    //Metodo utilizado para inciar el turno del siguiente jugador en partida
    void pasarTurno();
}
