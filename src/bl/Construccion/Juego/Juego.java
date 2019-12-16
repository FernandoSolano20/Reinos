package bl.Construccion.Juego;

import bl.Construccion.Juego.Dado.*;
import bl.Construccion.Juego.Turno.Iterador.IIterador;
import bl.Construccion.Juego.Turno.Turno;
import bl.Construccion.Juego.VisitanteTropas.IVisitante;
import bl.Construccion.Juego.VisitanteTropas.RegeneradorTropas;
import bl.Construccion.Jugadores.Jugador;
import bl.Construccion.Tablero.Tablero;
import bl.Construccion.Tienda.ITienda;
import bl.Construccion.Tienda.Tienda;
import bl.Construccion.Tropa.Tropa;

import java.util.ArrayList;

public class Juego implements IJuego {
	public static Juego juegoActual;
	private int cantidadJugadores;
	private Tablero tablero;
	private ArrayList<Jugador> jugadores;
    private IIterador iterador;
    private Turno turnoActual;
    private IDado dado;
    private IVisitante visitanteTropas;
    private ITienda tienda;

    public Juego(int cantidadJugadores, Tablero tablero, IIterador iterador) {
    	setCantidadJugadores(cantidadJugadores);
    	setTablero(tablero);
    	setJugadores(new ArrayList<>());
    	setIterador(iterador);
    	setTurnoActual(new Turno());
    	setDado(new Dado());
    	setVisitanteTropas(new RegeneradorTropas());
    	setTienda(new Tienda());
	}

	public Juego() {
		setCantidadJugadores(0);
		setTablero(new Tablero(10, 10));
		setJugadores(new ArrayList<>());
		setTurnoActual(new Turno());
		setDado(new Dado());
		setVisitanteTropas(new RegeneradorTropas());
		setTienda(new Tienda());
	}

	public Juego(int cantidadJugadores) {
		setCantidadJugadores(cantidadJugadores);
		setTablero(new Tablero(10, 10));
		setJugadores(new ArrayList<>());
		setTurnoActual(new Turno());
		setDado(new Dado());
		setVisitanteTropas(new RegeneradorTropas());
		setTienda(new Tienda());
	}

	public int getCantidadJugadores() {
		return cantidadJugadores;
	}

	public void setCantidadJugadores(int cantidadJugadores) {
		this.cantidadJugadores = cantidadJugadores;
	}

	public Tablero getTablero() {
		return tablero;
	}

	public void setTablero(Tablero tablero) {
		this.tablero = tablero;
	}

	public ArrayList<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(ArrayList<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	public void agregarJugador(Jugador pJugador) {
		this.jugadores.add(pJugador);
    }

    public IIterador getIterador() {
        return iterador;
    }

    public void setIterador(IIterador iterador) {
        this.iterador = iterador;
	}

	public Turno getTurnoActual() {
		return turnoActual;
	}

	public void setTurnoActual(Turno turnoActual) {
		this.turnoActual = turnoActual;
	}

	public IDado getDado() {
		return dado;
	}

	public void setDado(IDado dado) {
		this.dado = dado;
	}

	public IVisitante getVisitanteTropas() {
		return visitanteTropas;
	}

	public void setVisitanteTropas(IVisitante visitanteTropas) {
		this.visitanteTropas = visitanteTropas;
	}

	public ITienda getTienda() {
		return tienda;
	}

	public void setTienda(ITienda tienda) {
		this.tienda = tienda;
	}

	public void moverPieza(int origenX, int origenY, int destinoX, int destinoY){
    	int valorFinalDado = 0;

    	try {
			valorFinalDado =  getTablero().moverPieza(origenX,origenY,destinoX,destinoY, getTurnoActual());
			getTurnoActual().setMovimientosPermitidos(valorFinalDado);

		}catch (Exception e){
			System.out.println("Error al mover la pieza: " + e);
		}

		restablecerAcciones();
	}

	public void ponerPiezaEnJuego(int origenX, int origenY, int destinoX, int destinoY, Tropa pTropa){
		int valorFinalDado = 0;

		try {
			valorFinalDado =  getTablero().ponerPiezaEnJuego(origenX,origenY,destinoX,destinoY, getTurnoActual(),pTropa);
			getTurnoActual().setMovimientosPermitidos(valorFinalDado);

		}catch (Exception e){
			System.out.println("Error al poner la pieza en juego: " + e);
		}

		restablecerAcciones();
	}

	@Override
	public void finalizarPartida() {
    	if(jugadores.size() == 1) {
			System.out.println("Gano " + jugadores.get(0).getNombreJugador());
		}
	}

	@Override
	public void pasarTurno(){
    	try{

			setTurnoActual(new Turno(getTablero(), iterador.obtenerSiguienteJugador(), tirarDado()));
			restablecerAcciones();

			System.out.println("\n");
			if(iterador.getPosicionActual() == 0){
				for(Jugador jugador : getJugadores()){
					visitanteTropas.visitarGrupoTropas(jugador.getTropas());
				}
			}

		}catch (Exception e){
			System.out.println(e);
		}
	}

	@Override
	public int tirarDado() {
		return getDado().tirarDado();
	}

	private void restablecerAcciones(){
		getTablero().setModoMovimiento(false);
		getTablero().setModoAtaque(false);
		getTablero().setModoColocarPieza(false);
	}
}
