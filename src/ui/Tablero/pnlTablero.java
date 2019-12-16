package ui.Tablero;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;

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
import ui.contenedor.Controles.pnlDado;
import ui.eConfiguracion;
import ui.eIMG;

@SuppressWarnings("serial")
public class pnlTablero extends JPanel {

	private static pnlTablero instancia = null;
	private static boolean llamadaInterna = false;

	@SuppressWarnings("unused")
	private eIMG eIMGIniciaConstructor = new eIMG();
	private Tropa tropaSeleccionada;
	public boolean isAtaque;
	private pnlCasilla[][] casillasUI;
	private int ancho; // width
	private int largo; // height
	private Juego juego;
	private pnlDado pnlDado;
	private Cursor mano = new Cursor(Cursor.HAND_CURSOR);
	private Color[] gris = new Color[] { new Color(200, 200, 200, 200), new Color(200, 200, 200, 200) };
	// private Color[] grisClaro = new Color[] { new Color(230, 230, 230, 255), new
	// Color(240, 240, 240, 255) };
	private Color[] Yellow = new Color[] { new Color(255, 255, 92, 200), new Color(255, 255, 162, 200) };
	private Color[] Red = new Color[] { new Color(255, 45, 100, 100), new Color(255, 45, 100, 100) };
	private Color[] Green = new Color[] { new Color(45, 255, 100, 100), new Color(45, 255, 100, 100) };
	private Color[] White = new Color[] { new Color(255, 255, 255, 255), new Color(255, 255, 255, 255) };
	private Color[] Blue = new Color[] { new Color(45, 100, 255, 100), new Color(45, 100, 255, 100) };

	public pnlTablero() {
		if (llamadaInterna == false) {
			throw new Error("Debes usar getInstancia()");
		}
	}

	/**
	 * Create the panel.
	 */
	public static pnlTablero getInstancia(int anchoTablero, int largoTablero, Juego juego, pnlDado pnlDado) {
		if (instancia == null) {
			llamadaInterna = true;

			instancia = new pnlTablero();
			instancia.setAncho(anchoTablero);
			instancia.setLargo(largoTablero);
			instancia.setJuego(juego);
			instancia.setPnlDado(pnlDado);

			instancia.setLayout(null);
			instancia.setSize(anchoTablero, largoTablero);
			instancia.setBackground(eConfiguracion.COLOR_FONDO);
			instancia.setForeground(eConfiguracion.COLOR_LETRA);
			instancia.setJuego(juego);
			instancia.setAncho(instancia.getJuego().getTablero().getAncho());
			instancia.setLargo(instancia.getJuego().getTablero().getLargo());
			instancia.setPnlDado(pnlDado);

			int sizeCasillaW = (int) anchoTablero / instancia.getLargo();
			int sizeCasillaH = (int) largoTablero / instancia.getAncho();

			--sizeCasillaW;
			--sizeCasillaH;
			instancia.construirCasillas(sizeCasillaW, sizeCasillaH);
			instancia.repintarCasillas();

			llamadaInterna = false;

		}
		return instancia;
	}

	private void construirCasillas(int sizeCasillaW, int sizeCasillaH) {
		int x, y;
		this.casillasUI = new pnlCasilla[this.getAncho()][this.getLargo()];
		for (int i = 0; i < this.getLargo(); ++i) {
			x = (i * sizeCasillaW) + 2;
			for (int j = 0; j < this.getAncho(); ++j) {
				y = (j * sizeCasillaH) + 2;
				this.casillasUI[j][i] = new pnlCasilla(this);
				this.casillasUI[j][i].setBounds(x, y, sizeCasillaW, sizeCasillaH);
				this.casillasUI[j][i].i = j;
				this.casillasUI[j][i].j = i;
				this.casillasUI[j][i].setFondoCasilla(this.getColorDefault());
				this.add(casillasUI[j][i]);
			}
		}
	}

	public void repintarCasillas() {
		// Pintar casillas que no están vacias:
		for (Casilla[] i : this.juego.getTablero().getCasillas()) {
			for (Casilla j : i) {
				if (false == j.tienePieza() && false == j.tieneRecurso()) {
					// Se pinta el color default
					this.construirEnCasilla(j.getX(), j.getY(), "");
				} else {
					if (j.tienePieza()) {
						Construccion laPieza = j.getPieza();
						if (null != laPieza) {
							this.casillasUI[j.getX()][j.getY()].setCursor(mano);
							String nombrePieza = laPieza.getNombre();
							this.construirEnCasilla(j.getX(), j.getY(), nombrePieza);
						}
					}
					if (j.tieneRecurso()) {
						if (j.getRecurso() instanceof PowerUp) {
							this.construirEnCasilla(j.getX(), j.getY(), "PowerUp");
						} else {
							if (j.getRecurso() instanceof Azul) {
								// pintarCasilla(j.getX(), j.getY(), Blue);
								this.construirEnCasilla(j.getX(), j.getY(), "GemaAzul");
							} else if (j.getRecurso() instanceof Blanca) {
								// pintarCasilla(j.getX(), j.getY(), White);
								this.construirEnCasilla(j.getX(), j.getY(), "GemaBlanca");
							} else if (j.getRecurso() instanceof Verde) {
								// pintarCasilla(j.getX(), j.getY(), Green);
								this.construirEnCasilla(j.getX(), j.getY(), "GemaVerde");
							}
						}
					}
				}
			}
		}
		this.pnlDado.actualizarNumero();
	}

	private void construirEnCasilla(int i, int j, String nombrePieza) {
		// System.out.println("nombrePieza: " + nombrePieza);

		this.casillasUI[i][j].setFondoCasilla(this.getColorDefault());

		if (nombrePieza.trim().length() < 1) {
			if (movimientoEsPermitido(i, j)) {
				this.casillasUI[i][j].setFondoCasilla(this.Yellow);
			}
			// Se pinta el color default y no se pone imagen (null).
			this.casillasUI[i][j].setImgActual(null);
			this.casillasUI[i][j].repaint();

		} else {

			switch (nombrePieza.toUpperCase()) {

			case "CASTILLO":
				this.casillasUI[i][j].setImgActual(eIMG.IMAGE_CASTILLO1);
				break;

			case "BALLESTA":
				this.casillasUI[i][j].setImgActual(eIMG.IMAGE_BALLESTA);
				break;
			case "CATAPULTA":
				this.casillasUI[i][j].setImgActual(eIMG.IMAGE_CATAPULTA);
				break;
			case "ARQUERO":
				this.casillasUI[i][j].setImgActual(eIMG.IMAGE_ARQUERO);
				break;
			case "ESPADACHIN":
				this.casillasUI[i][j].setImgActual(eIMG.IMAGE_ESPADACHIN);
				break;
			case "BERSEQUER":
				this.casillasUI[i][j].setImgActual(eIMG.IMAGE_BERSEQUER);
				break;
			case "MAGO":
				this.casillasUI[i][j].setImgActual(eIMG.IMAGE_MAGO);
				break;
			case "ASESINO":
				this.casillasUI[i][j].setImgActual(eIMG.IMAGE_ASESINO);
				break;
			case "JINETE":
				this.casillasUI[i][j].setImgActual(eIMG.IMAGE_JINETE);
				break;
			case "ESPIA":
				this.casillasUI[i][j].setImgActual(eIMG.IMAGE_ESPIA);
				break;
			case "TROPA":
				this.casillasUI[i][j].setImgActual(eIMG.IMAGE_TROPA);
				break;
			case "POWERUP":
				if (null == eIMG.IMAGE_POWERUP)
					this.casillasUI[i][j].setFondoCasilla(Red);
				else
					this.casillasUI[i][j].setImgActual(eIMG.IMAGE_POWERUP);
				break;
			case "GEMAAZUL":
				if (null == eIMG.IMAGE_GEMAAZUL)
					this.casillasUI[i][j].setFondoCasilla(Blue);
				else
					this.casillasUI[i][j].setImgActual(eIMG.IMAGE_GEMAAZUL);
				break;
			case "GEMABLANCA":
				if (null == eIMG.IMAGE_GEMABLANCA)
					this.casillasUI[i][j].setFondoCasilla(White);
				else
					this.casillasUI[i][j].setImgActual(eIMG.IMAGE_GEMABLANCA);
				break;
			case "GEMAVERDE":
				if (null == eIMG.IMAGE_GEMAVERDE)
					this.casillasUI[i][j].setFondoCasilla(Green);
				else
					this.casillasUI[i][j].setImgActual(eIMG.IMAGE_GEMAVERDE);
				break;

			}

			this.casillasUI[i][j].repaint();
		}
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

	public void moverPieza(int origenX, int origenY, int destinoX, int destinoY) {
		this.juego.moverPieza(origenX, origenY, destinoX, destinoY);
		this.repintarCasillas();
	}

	public void ponerPiezaEnJuego(int origenX, int origenY, int destinoX, int destinoY) {
		this.juego.ponerPiezaEnJuego(origenX, origenY, destinoX, destinoY, this.getTropaSeleccionada());
		this.repintarCasillas();
	}

	private boolean movimientoEsPermitido(int destinoX, int destinoY) {
		int jugadorCoordenadaX = this.getJuego().getTurnoActual().getJugador().getPosicionCastillo()[0];
		int jugadorCoordenadaY = this.getJuego().getTurnoActual().getJugador().getPosicionCastillo()[1];
		return this.getJuego().getTurnoActual().getTablero().movimientoEsPermitido(jugadorCoordenadaX,
				jugadorCoordenadaY, destinoX, destinoY, this.getJuego().getTurnoActual());
	}

	public Tablero getTableroLogica() {
		return this.juego.getTablero();
	}

	public Tropa getTropaSeleccionada() {
		return this.tropaSeleccionada;
	}

	public void setTropaSeleccionada(Tropa tropaSeleccionada) {
		this.tropaSeleccionada = tropaSeleccionada;
	}

	public int getAncho() {
		return this.ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public int getLargo() {
		return this.largo;
	}

	public void setLargo(int largo) {
		this.largo = largo;
	}

	public Color[] getColorDefault() {
		return this.gris;
	}

	public void setJuego(Juego juego) {
		this.juego = juego;
	}

	public Juego getJuego() {
		return this.juego;
	}

	public pnlDado getPnlDado() {
		return this.pnlDado;
	}

	public void setPnlDado(ui.contenedor.Controles.pnlDado pnlDado) {
		this.pnlDado = pnlDado;
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g); // without this line, map scrolls with errors
	}
}
