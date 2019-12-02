package ui.Tablero;

import java.awt.Color;
import javax.swing.JPanel;

import bl.Construccion.Construccion;
import bl.Construccion.Tablero.Casilla;
import bl.Construccion.Tablero.Tablero;

@SuppressWarnings("serial")
public class pnlTablero extends JPanel {

	private pnlCasilla[][] casillasUI;
	private int ancho; // width
	private int largo; // height

	private Color[] resaltarCasilla = new Color[] { new Color(255, 255, 92, 255), new Color(255, 255, 162, 255) };

	/**
	 * Create the panel.
	 */
	public pnlTablero(int anchoTablero, int largoTablero, Tablero tablero) {
		this.setLayout(null);
		this.setSize(anchoTablero, largoTablero);
		this.setBackground(new java.awt.Color(51, 51, 51));
		this.setForeground(new java.awt.Color(250, 250, 250));

		this.setAncho(tablero.getAncho());
		this.setLargo(tablero.getLargo());

		int sizeCasillaW = (int) anchoTablero / this.getLargo();
		int sizeCasillaH = (int) largoTablero / this.getAncho();

		--sizeCasillaW;
		--sizeCasillaH;
		construirCasillas(sizeCasillaW, sizeCasillaH);

		// Pintar casillas que no están vacias:
		for (Casilla[] i : tablero.getCasillas()) {
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
				this.add(casillasUI[j][i]);
			}
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

	public void construirEnCasilla(int i, int j, String nombrePieza, int Vida) {

		// TODO: Aquí se dibuja de acuerdo a la pieza obtenida.
		// Por ejemplo si es un castillo: mostrar la imagen de un castillo.

		casillasUI[i][j].setFondo(resaltarCasilla);
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

}
