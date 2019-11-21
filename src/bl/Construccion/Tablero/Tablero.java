package bl.Construccion.Tablero;

import bl.Construccion.Construccion;
import bl.Construccion.IConstruccion;
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

    private Construccion obtenerPiezaCasilla(int coordenadaX, int coordenadaY){
        try{

            return casillas[coordenadaX][coordenadaY].getPieza();

        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    private void colocarPiezaCasilla(int coordenadaX, int coordenadaY, Construccion pieza){

            casillas[coordenadaX][coordenadaY].setPieza(pieza);
    }

    private void removerPiezaCasilla(int coordenadaX, int coordenadaY){

        casillas[coordenadaX][coordenadaY].setPieza(null);
    }

    @Override
    public void generarGemas() {

    }

    @Override
    public void generarPowerUps() {

    }

    @Override
    public void generarCastillos() {

	}

	public String moverPieza(int origenX, int origenY, int destinoX, int destinoY) throws Exception {
		if (validarMovimiento(origenX, origenY, destinoX, destinoY)) {

			if (obtenerPiezaCasilla(destinoX, destinoY) != null) {
				throw new Exception("La casilla de destino se encuentra ocupada");
			}

			if (obtenerPiezaCasilla(origenX, origenY) != null) {
				Construccion tropaAtaque = obtenerPiezaCasilla(origenX, origenY);
				colocarPiezaCasilla(destinoX, destinoY, tropaAtaque);
				removerPiezaCasilla(origenX, origenY);
				return "La pieza ha sido movida a: " + destinoX + "," + destinoY;
			}

			throw new Exception("No hay una pieza en la casilla de origen");

		} else {
			throw new Exception("El movimiento solicitado es inv�lido");
		}
	}

	private boolean validarMovimiento(int origenX, int origenY, int destinoX, int destinoY) {
		if (origenX != destinoX && origenY != destinoY) {
			return false;
		} else {
			return true;
		}
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

}
