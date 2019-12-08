package ui.Tablero;

import bl.Construccion.Tablero.Casilla;
import bl.Construccion.Tablero.CasillaActual;
import ui.contenedor.FrmMain;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import static javax.swing.BorderFactory.createMatteBorder;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class pnlCasilla extends JPanel implements MouseListener {
	private pnlTablero tablero;
	private Color[] fondo = new Color[] { new Color(220, 220, 220, 255), new Color(248, 248, 248, 255) };
	private int[] casillaMarcada = new int[2]; //{ i, j }

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
		GradientPaint gp = new GradientPaint(0, 0, getFondo()[0], 0, this.getHeight(), getFondo()[1]);
		g2.setPaint(gp);
		g2.fillRect(2, 2, this.getWidth() - 4, this.getHeight() - 4);
	}

	public void setFondo(Color[] fondo) {
		this.fondo = fondo;
	}

	public Color[] getFondo() {
		return this.fondo;
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

		if(tablero.getJuego().getTablero().isModoAtaque()){
			System.out.println("Atacando a casilla: " +  tablero.getJuego().getTablero().getCasillas()[this.getCasillaMarcada()[0]][this.getCasillaMarcada()[1]].getX() + "," +  tablero.getJuego().getTablero().getCasillas()[this.getCasillaMarcada()[0]][this.getCasillaMarcada()[1]].getY());
		}
		else if(tablero.getJuego().getTablero().isModoMovimiento()){
			System.out.println("Movimiendo a casilla: " +  tablero.getJuego().getTablero().getCasillas()[this.getCasillaMarcada()[0]][this.getCasillaMarcada()[1]].getX() + "," +  tablero.getJuego().getTablero().getCasillas()[this.getCasillaMarcada()[0]][this.getCasillaMarcada()[1]].getY());
			tablero.getJuego().moverPieza(CasillaActual.getCasilla().getX(), CasillaActual.getCasilla().getY(), casillaMarcada[0],casillaMarcada[1]);
		}
		else{
			System.out.println("Casilla seleccionada");
			//Obtenemos la casilla del tablero para asignarla a la casilla actual
			Casilla casillaActual = tablero.getJuego().getTablero().getCasillas()[this.getCasillaMarcada()[0]][this.getCasillaMarcada()[1]];
			CasillaActual.setCasilla(casillaActual);
		}



		Color[] colorVerde = new Color[] { new Color(20, 143, 119, 255), new Color(115, 198, 182, 255) };
		this.tablero.pintarCasilla(this.getCasillaMarcada()[0], this.getCasillaMarcada()[1], colorVerde);

		JOptionPane.showMessageDialog(null,
				"Casilla seleccionada:\nI: " + this.getCasillaMarcada()[0] + ",  J: " + this.getCasillaMarcada()[1]);
	}

	public void mouseReleased(MouseEvent e) {
	}

	public int[] getCasillaMarcada() {
		return casillaMarcada;
	}

	public void setCasillaMarcada(int[] aCasillaMarcada) {
		casillaMarcada = aCasillaMarcada;
	}

}
