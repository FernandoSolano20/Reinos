package bl.Construccion.Tablero;

import bl.Construccion.Construccion;
import bl.Construccion.Excepciones.ExcepcionJuego;
import bl.Construccion.Juego.Turno.Turno;
import bl.Construccion.Jugadores.Jugador;
import bl.Construccion.Tropa.Tropa;
import bl.Construccion.Tropa.TropaAtaque.TropaAtaque;

public class Tablero implements ITablero {
    private Casilla[][] casillas;
    private int ancho; //width
    private int largo; //height

    public Tablero(int ancho, int largo) {
        setAncho(ancho);
		setLargo(largo);
        setLargo(largo);
        casillas  = new Casilla[ancho][largo];
        generarCasillas(ancho,largo);
    }

	public int getAncho() {
		return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

	public int getLargo() {
		return largo;
	}

	public void setLargo(int largo) {
		this.largo = largo;
	}

	public Casilla[][] getCasillas() {
		return casillas;
	}

	public void setCasillas(Casilla[][] casillas) {
		this.casillas = casillas;
	}

    public void construirEnCasilla(int pAncho, int pLargo, Construccion pConstruccion) {
        this.getCasillas()[pAncho][pLargo].setPieza(pConstruccion);
	}

    private void generarCasillas(int pAncho, int pLargo){
        for(int i = 0; i < pAncho; i++){
            for(int j = 0; j < pLargo; j++){
                this.casillas[i][j] = new Casilla(i,j);
			}
		}
	}

    public boolean esCasillasValida(Casilla casilla){
        if(casilla.getX() == 0 && (casilla.getY() == 0 || casilla.getY() == getAncho() - 1)){
            return false;
        }
        else if(casilla.getX() == 9 && (casilla.getY() == 0 || casilla.getY() == getLargo() - 1)){
			return false;
		}
        else{
        return true;
        }
    }

    public Construccion obtenerPiezaCasilla(int coordenadaX, int coordenadaY){
    	Casilla casilla = casillas[coordenadaX][coordenadaY];
    	if(casilla != null)
            return casilla.getPieza();
        return null;
    }

	public boolean casillaTienePowerUp(int coordenadaX, int coordenadaY){
		Casilla casilla = casillas[coordenadaX][coordenadaY];
		if(casilla != null)
			return true;
		return false;
	}

    public void colocarPiezaCasilla(int coordenadaX, int coordenadaY, Construccion pieza){
    	if(obtenerPiezaCasilla(coordenadaX,coordenadaY) == null){
    		Casilla casilla = casillas[coordenadaX][coordenadaY];
			casilla.setPieza(pieza);
			pieza.setCasilla(casilla);
		}

    }

    private void removerPiezaCasilla(int coordenadaX, int coordenadaY){
        casillas[coordenadaX][coordenadaY].setPieza(null);
    }

	public int moverPieza(int origenX, int origenY, int destinoX, int destinoY, Turno pTurno) throws Exception {

    	//Se obtienen las piezas en las casillas de origen y destino
    	Construccion piezaOrigen = obtenerPiezaCasilla(origenX, origenY);
    	Construccion piezaDestino = obtenerPiezaCasilla(destinoX, destinoY);

    	//Se calcula la distancia total del movimiento solicitado por el jugador
    	int distanciaMovimiento = obtenerDistanciaEntreCasillas(origenX, origenY, destinoX, destinoY);
		//Validamos que las dos coordenadas ingresadas sean correctas

		if (! validarCasillas(origenX, origenY, destinoX, destinoY)) {
			throw new ExcepcionJuego("El movimiento solicitado es invalido");
		}

		else if(piezaDestino != null){
			throw new ExcepcionJuego("La casilla de destino se encuentra ocupada");
		}

		else if(piezaOrigen == null){
			throw new ExcepcionJuego("La casilla de origen se encuentra vacia");
		}

		else if(! validarTropaAtaque(piezaOrigen)){
			throw new ExcepcionJuego("La tropa no es capaz de moverse");
		}

		else if(! validarTropaJugador((TropaAtaque) piezaOrigen, pTurno.getJugador())){
			throw new ExcepcionJuego("Esta tropa pertenece a otro jugador");
		}

		else if(! validarMovimientoDado(distanciaMovimiento, pTurno.getMovimientosPermitidos())) {
			throw new ExcepcionJuego("La cantidad de movimientos es mayor al valor restante del dado");
		}

		else if(! validarMovimientoTropa((TropaAtaque) piezaOrigen, distanciaMovimiento)) {
			throw new ExcepcionJuego("La tropa no tiene suficientes moviemientos");
		}
		else{
			colocarPiezaCasilla(destinoX, destinoY, piezaOrigen);
			removerPiezaCasilla(origenX, origenY);
			descontarMovimientosTropa((TropaAtaque) piezaOrigen, distanciaMovimiento);

			//Retorna el valor restante del dado
			return pTurno.getMovimientosPermitidos() - distanciaMovimiento;
		}

    }

	//Metodo que obtiene la ubicacion de  la casilla de origen y de la casilla destino
	// Lo que busca es obtener la distancia que hay en X y la distancia en Y
	// Posteriormente lo suma para obtener la distancia total en ambos ejes

	private int obtenerDistanciaEntreCasillas(int origenX, int origenY, int destinoX, int destinoY){
		int distanciaX = Math.abs(origenX - destinoX);
		int distanciaY = Math.abs(origenY - destinoY);
		return distanciaX + distanciaY;
	}

	//Metodo que valida que las casillas ingresadas se encuentren entre los parametros permitidos
	private boolean validarCasillas(int origenX, int origenY, int destinoX, int destinoY) {

		//Valida si la casilla de origen es la misma que la casilla destino
		if (origenX == destinoX && origenY == destinoY) {
			return false;
		}
		//Valida que las casillas de origen sean mayores a 0 y menores que 10
		else if(origenX > 9 || origenY > 9 || origenX < 0 || origenY < 0) {
			return false;
		}
		//Valida que las casillas de destino sean mayores a 0 y menores que 10
		else if(destinoX > 9 || destinoY > 9 || destinoX < 0 || destinoY < 0) {
			return false;
		}
		else {
			return true;
		}
	}

    //Metodo que valida que la tropa sea capaz de moverse por el tablero
	private boolean validarTropaAtaque(Construccion pTropa) {
    	return pTropa instanceof TropaAtaque;
	}

	//Metodo que valida que a la tropa de quedan movimientos suficientes como para completar el movimiento
	private boolean validarMovimientoTropa(TropaAtaque pTropa, int pMovimientoTropa){
    	return pTropa.getCantMovimientos() >= pMovimientoTropa;
	}

	//Metodo que valida que el movimiento solicitado tiene un distancia menor o igual a los movimientos restantes en el dado
	private boolean validarMovimientoDado(int pDistancia, int pValorDado) {
		return pDistancia <= pValorDado;
	}

	private boolean validarTropaJugador(TropaAtaque pTropa, Jugador pJugador){
		for(Tropa tropa : pJugador.getTropas()){
			if(pTropa.equals(tropa)){
				return true;
			}
		}
		return false;
	}

	//Metodo que descuenta los movimientos realizados por la tropa
	private void descontarMovimientosTropa(TropaAtaque pTropa, int cantidadMovimientosRealizados){
    	int cantidadMovimientosTropa = pTropa.getCantMovimientos();
    	pTropa.setCantMovimientos(cantidadMovimientosTropa - cantidadMovimientosRealizados);
	}



	@Override
	public String recorrerTablero() {
		String tablero = "";

		for (Casilla[] i : getCasillas()) {
			for (Casilla j : i) {
				if (j.getPieza() != null) {
					tablero += " [" + j.getPieza().getNombre() + " (" + j.getX() + " - " + j.getY() + ")] ";
				} else {
					tablero += " [] ";
				}
			}
			tablero += "\n";
		}
		return tablero;
	}

	public Casilla obtenerCasilla(int x, int y){
    	return casillas[x][y];
	}

}
