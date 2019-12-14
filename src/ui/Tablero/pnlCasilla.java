package ui.Tablero;

import bl.Construccion.Construccion;
import bl.Construccion.Recursos.IRecurso;
import bl.Construccion.Recursos.PowerUps.PowerUp;
import bl.Construccion.Tablero.Casilla;
import bl.Construccion.Tropa.Tropa;
import bl.Construccion.Tablero.CasillaActual;
import bl.Construccion.Tropa.TropaAtaque.TropaAtaque;
import ui.eConfiguracion;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import static javax.swing.BorderFactory.createMatteBorder;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class pnlCasilla extends JPanel implements MouseListener {
	private pnlTablero tablero;
	public int i;
	public int j;
	private Color[] fondoCasilla = null;

	private int[] casillaMarcada = new int[2]; // { i, j }

	private Image imgActual = null;

	/**
	 * Create the panel.
	 */
	public pnlCasilla() {

	}

	public pnlCasilla(pnlTablero t) {
		this.tablero = t;
		this.setLayout(null);
		this.setOpaque(true);

		// Borde de la celda:
		this.setBorder(createMatteBorder(2, 2, 2, 2, new Color(80, 80, 80, 255)));

		// responde a clics:
		this.addMouseListener(this);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;

		g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		GradientPaint gp = new GradientPaint(0, 0, getFondoCasilla()[0], 0, this.getHeight(), getFondoCasilla()[1]);
		g2.setPaint(gp);
		g2.fillRect(2, 2, this.getWidth() - 4, this.getHeight() - 4);

		if (null != getImgActual()) {

			int hh = getImgActual().getHeight(this);
			int ww = getImgActual().getWidth(this);

			if (hh < this.getHeight()) {
				hh = (this.getHeight() - hh) / 2;
			} else {
				hh = 0;
			}

			if (ww < this.getWidth()) {
				ww = (this.getWidth() - ww) / 2;
			} else {
				ww = 0;
			}

			g2.drawImage(getImgActual(), ww, hh, getImgActual().getWidth(this), getImgActual().getHeight(this), this);
		}

	}

	public void mouseClicked(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {

		// Marcamos la casilla seleccionada.
		this.setCasillaMarcada(tablero.getCoordenadas((pnlCasilla) e.getComponent()));

		// Obtenemos la casilla del tablero para asignarla a la casilla actual
		Casilla casillaActual = tablero.getTablero().getCasillas()[this.getCasillaMarcada()[0]][this
				.getCasillaMarcada()[1]];
		CasillaActual.setCasilla(casillaActual);

		// JOptionPane.showMessageDialog(null, "Casilla seleccionada:\nI: " + i + ", J:
		// " + j);

		// Recursos
		Casilla casilla = tablero.getTableroLogica().obtenerCasilla(i, j);
		if (casilla.tieneRecurso()) {
			recorgerRecurso(casilla);
		}

		Construccion construccion = tablero.getTableroLogica().obtenerPiezaCasilla(i, j);
		if (pnlTablero.getTropaSeleccionada() == null && construccion instanceof Tropa) {
			Tropa tropa = (Tropa) construccion;
			pnlTablero.setTropaSeleccionada(tropa);
		} else if (pnlTablero.isAtaque) {
			atacar(construccion);
		}

	}

	public void mouseReleased(MouseEvent e) {
	}

	public int[] getCasillaMarcada() {
		return casillaMarcada;
	}

	public void setCasillaMarcada(int[] aCasillaMarcada) {
		casillaMarcada = aCasillaMarcada;
	}

	private int recogerPowerUp() {
		int opcion = 0;
		String cad = "Quiere Recoger Power Up:\n";
		String[] opciones = { "          Si          ", "          No          " };
		do {
			opcion = JOptionPane.showOptionDialog(null, cad, eConfiguracion.TITULO_APP,
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);
		} while (opcion != 0 && opcion != 1);

		return opcion;
	}

	private int recogerOro() {
		int opcion = 0;
		String cad = "Quiere Recoger oro:\n";
		String[] opciones = { "          Si          ", "          No          " };
		do {
			opcion = JOptionPane.showOptionDialog(null, cad, eConfiguracion.TITULO_APP,
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);
		} while (opcion != 0 && opcion != 1);

		return opcion;
	}

	private void atacar(Construccion construccion) {
		if (null != construccion && null != construccion.getCasilla()) {
			pnlTablero.getTropaSeleccionada().atacar(construccion);
			pnlTablero.setTropaSeleccionada(null);
			pnlTablero.isAtaque = false;
			this.tablero.repintarCasillas();
		} else {
			System.err.println("No se puede atacar.");
		}
	}

	private void recorgerRecurso(Casilla casilla) {
		IRecurso recurso = casilla.getRecurso();
		Construccion construccion = tablero.getTableroLogica().obtenerPiezaCasilla(i, j);
		if (construccion instanceof TropaAtaque) {
			TropaAtaque tropaAtaque = (TropaAtaque) construccion;
			if (recurso instanceof PowerUp) {
				int opc = recogerPowerUp();
				if (opc == 0) {
					tropaAtaque.recogerPowerUp(casilla);
					// this.tablero.construirEnCasilla(this.getCasillaMarcada()[0],
					// this.getCasillaMarcada()[1], "");
					this.tablero.repintarCasillas();
				}
			} else {
				int opc = recogerOro();
				if (opc == 0) {
					tropaAtaque.recogerOro(casilla);
					// this.tablero.construirEnCasilla(this.getCasillaMarcada()[0],
					// this.getCasillaMarcada()[1], "");
					this.tablero.repintarCasillas();
				}
			}
		}
	}

	public Image getImgActual() {
		return imgActual;
	}

	public void setImgActual(Image imgActual) {
		this.imgActual = imgActual;
	}

	public Color[] getFondoCasilla() {
		return fondoCasilla;
	}

	public void setFondoCasilla(Color[] fondoCasilla) {
		this.fondoCasilla = fondoCasilla;
	}
}
