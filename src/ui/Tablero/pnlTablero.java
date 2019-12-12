package ui.Tablero;

import java.awt.Color;
import javax.swing.JPanel;

import bl.Construccion.Construccion;
import bl.Construccion.Juego.Juego;
import bl.Construccion.Recursos.Gemas.Tipo.Azul;
import bl.Construccion.Recursos.Gemas.Tipo.Blanca;
import bl.Construccion.Recursos.Gemas.Tipo.Verde;
import bl.Construccion.Recursos.PowerUps.PowerUp;
import bl.Construccion.Tablero.Casilla;
import bl.Construccion.Tablero.Tablero;
import bl.Construccion.Tropa.Tropa;
import bl.Construccion.Tropa.TropaAtaque.Asesino;
import bl.Construccion.Tropa.TropaAtaque.Jinete;
import javafx.beans.binding.When;

@SuppressWarnings("serial")
public class pnlTablero extends JPanel {

	private Tablero tablero;
	private static Tropa tropaSeleccionada;
	public static boolean isAtaque;
	private pnlCasilla[][] casillasUI;
	private int ancho; // width
	private int largo; // height
	private Juego juego;
	private Color[] Yellow = new Color[] { new Color(255, 255, 92, 255), new Color(255, 255, 162, 255) };
	private Color[] Red = new Color[] {new Color(255, 45, 100, 100), new Color(255, 45, 100, 100)};
	private Color[] Green = new Color[] {new Color(45, 255, 100, 100), new Color(45, 255, 100, 100)};
	private Color[] White = new Color[] {new Color(255, 255, 255, 255), new Color(255, 255, 255, 255)};
	private Color[] Blue = new Color[] {new Color(45, 100, 255, 100), new Color(45, 100, 255, 100)};


	/**
	 * Create the panel.
	 */
	public pnlTablero(int anchoTablero, int largoTablero, Juego juego) {
		this.tablero = juego.getTablero();
		this.setLayout(null);
		this.setSize(anchoTablero, largoTablero);
		this.setBackground(new java.awt.Color(51, 51, 51));
		this.setForeground(new java.awt.Color(250, 250, 250));
		this.setJuego(juego);
		this.setAncho(getJuego().getTablero().getAncho());
		this.setLargo(getJuego().getTablero().getLargo());



		int sizeCasillaW = (int) anchoTablero / this.getLargo();
		int sizeCasillaH = (int) largoTablero / this.getAncho();

		--sizeCasillaW;
		--sizeCasillaH;
		construirCasillas(sizeCasillaW, sizeCasillaH);
int count = 0;
		// Pintar casillas que no est�n vacias:
		for (Casilla[] i : getJuego().getTablero().getCasillas()) {
			for (Casilla j : i) {
				if (j.tienePieza()) {
					Construccion laPieza = j.getPieza();
					if (null != laPieza) {

						int vida = laPieza.getVida();
						String nombrePieza = laPieza.getNombre();

						construirEnCasilla(j.getX(), j.getY(), nombrePieza, vida);

						System.out.println(" [" + nombrePieza + " (" + j.getX() + " - " + j.getY() + ")] ");
					}
				}
				if(j.tieneRecurso()){
					if(j.getRecurso() instanceof PowerUp){
						pintarCasilla(j.getX(), j.getY(), Red);
					}
					else {
						if(j.getRecurso() instanceof Azul){
							pintarCasilla(j.getX(), j.getY(), Blue);
						}
						else if(j.getRecurso() instanceof Blanca){
							pintarCasilla(j.getX(), j.getY(), White);
						}
						else if(j.getRecurso() instanceof Verde){
							pintarCasilla(j.getX(), j.getY(), Green);
						}
					}
				}
			}
		}
		System.out.println("\n\n");
	}

	private void construirCasillas(int sizeCasillaW, int sizeCasillaH) {
		int x, y;
		casillasUI = new pnlCasilla[this.getAncho()][this.getLargo()];
		for (int i = 0; i < this.getLargo(); ++i) {
			x = (i * sizeCasillaW) + 2;
			for (int j = 0; j < this.getAncho(); ++j) {
				y = (j * sizeCasillaH) + 2;
				casillasUI[j][i] = new pnlCasilla(this);
				casillasUI[j][i].setBounds(x, y, sizeCasillaW, sizeCasillaH);
				casillasUI[j][i].i = j;
				casillasUI[j][i].j = i;
				this.add(casillasUI[j][i]);
			}
			Asesino asesino = new Asesino();
			Jinete jinete  = new Jinete();
			getTableroLogica().colocarPiezaCasilla(5,4, asesino);
			getTableroLogica().colocarPiezaCasilla(3,4, jinete);
		}
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

	public Juego getJuego() {
		return juego;
	}

	public void setJuego(Juego juego) {
		this.juego = juego;
	}

	public void construirEnCasilla(int i, int j, String nombrePieza, int Vida) {

		// TODO: Aqu� se dibuja de acuerdo a la pieza obtenida.
		// Por ejemplo si es un castillo: mostrar la imagen de un castillo.

		casillasUI[i][j].setFondo(Yellow);
		this.repaint();
	}

	public void pintarCasilla(int i, int j, Color[] color) {
		casillasUI[i][j].setFondo(color);
		this.repaint();
	}

	public int[] getCoordenadas(pnlCasilla casilla) {
		for (int i = 0; i < this.getAncho(); ++i) {
			for (int j = 0; j < this.getLargo(); ++j) {
				if (this.casillasUI[i][j] == casilla) {
					return new int[] { i, j };
				}
			}
		}
		return new int[2];
	}

	public void moverPieza(int origenX, int origenY, int destinoX, int destinoY){
		juego.moverPieza(origenX,origenY,destinoX,destinoY);
	}
	
	public Tablero getTableroLogica() {
		return tablero;
	}
	
	public static Tropa getTropaSeleccionada() {
		return tropaSeleccionada;
	}

	public static void setTropaSeleccionada(Tropa tropaSeleccionada) {
		pnlTablero.tropaSeleccionada = tropaSeleccionada;
	}
}
