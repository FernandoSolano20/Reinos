package ui.Tablero;

import java.awt.Color;
import javax.swing.JPanel;
import bl.Construccion.Tablero.Tablero;
import bl.Construccion.Tropa.Tropa;
import bl.Construccion.Tropa.TropaAtaque.Asesino;
import bl.Construccion.Tropa.TropaAtaque.Jinete;

@SuppressWarnings("serial")
public class pnlTablero extends JPanel {

	private Tablero tablero;
	private Tropa tropaAtacante;
	private pnlCasilla[][] casillasUI;
	private int ancho; // width
	private int largo; // height

	private Color[] resaltarCasilla = new Color[] { new Color(255, 255, 92, 255), new Color(255, 255, 162, 255) };

	/**
	 * Create the panel.
	 */
	public pnlTablero(int widthTablero, int heightTablero, Tablero tablero) {
		this.tablero = tablero;
		this.setLayout(null);
		this.setSize(widthTablero, heightTablero);
		this.setBackground(new java.awt.Color(51, 51, 51));
		this.setForeground(new java.awt.Color(250, 250, 250));

		this.setAncho(tablero.getAncho());
		this.setLargo(tablero.getLargo());

		int sizeCasillaW = (int) widthTablero / this.getAncho();
		int sizeCasillaH = (int) heightTablero / this.getLargo();

		--sizeCasillaW;
		--sizeCasillaH;

		int x, y;
		casillasUI = new pnlCasilla[this.getAncho()][this.getLargo()];
		for (int i = 0; i < this.getAncho(); ++i) {
			x = (i * sizeCasillaW) + 2;
			for (int j = 0; j < this.getLargo(); ++j) {
				casillasUI[i][j] = new pnlCasilla(this);
				y = (j * sizeCasillaH) + 2;
				casillasUI[i][j].setBounds(x, y, sizeCasillaW, sizeCasillaH);
				casillasUI[i][j].x = i;
				casillasUI[i][j].y = j;
				this.add(casillasUI[i][j]);
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

	public void construirEnCasilla(int x, int y, String nombrePieza) {

		// TODO: Aqu� se dibuja de acuerdo a la pieza obtenida.
		// Por ejemplo si es un castillo: mostrar la imagen de un castillo.

		casillasUI[x][y].setFondo(resaltarCasilla);
		this.repaint();
	}

	public void construirEnCasilla(int x, int y) {
		casillasUI[x][y].setFondo(resaltarCasilla);
		this.repaint();
	}

	public void construirEnCasilla(int x, int y, Color[] color) {
		casillasUI[x][y].setFondo(color);
		this.repaint();
	}

	public int[] getCoordenadas(pnlCasilla casilla) {
		for (int i = 0; i < this.getAncho(); i++) {
			for (int j = 0; j < this.getLargo(); j++) {
				if (this.casillasUI[i][j] == casilla) {
					return new int[] {i, j};
				}
			}
		}
		return new int[2];
	}

	public Tablero getTableroLogica() {
		return tablero;
	}

	public Tropa getTropaAtacante() {
		return tropaAtacante;
	}

	public void setTropaAtacante(Tropa tropaAtacante) {
		this.tropaAtacante = tropaAtacante;
	}
}
