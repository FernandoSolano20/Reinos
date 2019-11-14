package ui.Tablero;

import java.awt.Color;

import javax.swing.JPanel;

import bl.Construccion.Tablero.Tablero;

public class pnlTablero extends JPanel {

	private Tablero tablero = new Tablero(10, 10);
	private pnlCasilla[][] casillasUI;

	public Tablero getTablero() {
		return tablero;
	}

	private Color[] resaltarCasilla = new Color[] { new Color(255, 255, 92, 255), new Color(255, 255, 162, 255) };

	/**
	 * Create the panel.
	 */
	public pnlTablero(int widthTablero, int heightTablero) {
		this.setLayout(null);
		this.setSize(widthTablero, heightTablero);
		this.setBackground(new java.awt.Color(51, 51, 51));
		this.setForeground(new java.awt.Color(250, 250, 250));

		int sizeCasillaW = (int) widthTablero / tablero.getAncho();
		int sizeCasillaH = (int) heightTablero / tablero.getLargo();

		--sizeCasillaW;
		--sizeCasillaH;

		int x, y;
		casillasUI = new pnlCasilla[tablero.getAncho()][tablero.getLargo()];
		for (int i = 0; i < tablero.getAncho(); i++) {
			x = (i * sizeCasillaW) + 2;
			for (int j = 0; j < tablero.getLargo(); j++) {
				casillasUI[i][j] = new pnlCasilla(this);
				y = (j * sizeCasillaH) + 2;
				casillasUI[i][j].setBounds(x, y, sizeCasillaW, sizeCasillaH);
				this.add(casillasUI[i][j]);
			}

		}
	}

	public void pintarCasilla(int x, int y) {
		casillasUI[x][y].setFondo(resaltarCasilla);
		this.repaint();
	}
	

	public void pintarCasilla(int x, int y, Color[] color) {
		casillasUI[x][y].setFondo(color);
		this.repaint();
	}

	public int[] getCoordenadas(pnlCasilla casilla) {
		int[] coordenadas = new int[2];
		for (int i = 0; i < this.casillasUI.length; i++) {
			for (int j = 0; j < this.casillasUI.length; j++) {
				if (this.casillasUI[i][j] == casilla) {
					coordenadas[0] = i;
					coordenadas[1] = j;
				}
			}
		}
		return coordenadas;
	}

}
