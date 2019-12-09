package ui.contenedor.Controles;

import bl.Construccion.Tropa.Tropa;
import bl.Construccion.Tropa.TropaAtaque.TropaAtaque;
import ui.eConfiguracion;
import ui.Tablero.pnlTablero;

import ui.contenedor.Controles.Tienda.pnlTienda;
import ui.contenedor.FrmMain;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class pnlControles extends JPanel {
	private JButton btnMover;
	private JButton btnPasarTurno;
	private JButton btnAtacar;
	private JButton btnComprar;
	private JButton btnMisTropas;
	private JButton btnUsarPowerUp;

	/**
	 * Create the panel.
	 */
	public pnlControles(int widthTablero) {
		setBorder(new LineBorder(new Color(255, 255, 204, 255)));
		this.setLayout(null);
		this.setSize(603, 140);
		this.setBackground(eConfiguracion.COLOR_FONDO);
		this.setForeground(eConfiguracion.COLOR_LETRA);

		btnMover = new JButton("Mover");
		btnMover.setBounds(45, 11, 142, 55);
		add(btnMover);

		btnPasarTurno = new JButton("Pasar Turno");
		btnPasarTurno.setBounds(45, 69, 142, 55);
		add(btnPasarTurno);

		btnAtacar = new JButton("Atacar");
		btnAtacar.setBounds(238, 11, 142, 55);
		add(btnAtacar);

		btnComprar = new JButton("Comprar");
		btnComprar.setBounds(238, 69, 142, 55);
		add(btnComprar);

		btnUsarPowerUp = new JButton("Usar power up");
		btnUsarPowerUp.setBounds(429, 11, 142, 55);
		add(btnUsarPowerUp);

		btnMisTropas = new JButton("Mis tropas");
		btnMisTropas.setBounds(429, 69, 142, 55);
		add(btnMisTropas);

		agregarAcciones();
	}

	private void agregarAcciones() {
		btnMover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// acción de mover
			}
		});

		btnPasarTurno.addActionListener(e -> {
			FrmMain.juego.pasarTurno();
			String jugadorActual = FrmMain.juego.getTurnoActual().getJugador().getNombreJugador();
			JOptionPane.showMessageDialog(new JPanel(), "Turno de " + jugadorActual, "Pasar turno",
					JOptionPane.INFORMATION_MESSAGE);
		});

		btnAtacar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (pnlTablero.getTropaSeleccionada() != null)
					pnlTablero.isAtaque = true;
			}
		});

		btnComprar.addActionListener(e -> {
			pnlTienda pnlTienda = new pnlTienda();
			pnlTienda.setVisible(true);
		});
		btnMisTropas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// acción de mis tropas
			}
		});
		btnUsarPowerUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tropa tropa = pnlTablero.getTropaSeleccionada();
				TropaAtaque tropaAtaque = null;
				if (tropa != null && tropa instanceof TropaAtaque) {
					tropaAtaque = (TropaAtaque) tropa;
					tropaAtaque = tropaAtaque.usarPowerUp(tropaAtaque);
					tropaAtaque.getCasilla().setPieza(tropaAtaque);
					pnlTablero.setTropaSeleccionada(null);
				}
			}
		});
	}
}
