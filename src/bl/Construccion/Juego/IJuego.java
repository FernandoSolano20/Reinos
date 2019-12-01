package bl.Construccion.Juego;

public interface IJuego {

    //Metodo utilziado para finalizar la partida y determinar el jugador ganador
    void finalizarPartida();

    //Metodo utilizado para inciar el turno del obtenerSiguienteJugador jugador en partida
    void pasarTurno();

    //Meotodo utilizado para obtener un nuevo valor del dado
    int tirarDado();
}
