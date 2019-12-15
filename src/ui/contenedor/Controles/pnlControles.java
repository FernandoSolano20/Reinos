package ui.contenedor.Controles;

import bl.Construccion.Juego.Juego;
import bl.Construccion.decorador.ObjetoDecorado;
import ui.Tablero.pnlTablero;
import bl.Construccion.Tropa.Tropa;
import bl.Construccion.Tropa.TropaAtaque.TropaAtaque;
import ui.contenedor.Controles.Tropas.pnlTropas;
import ui.eConfiguracion;
import ui.Tablero.pnlTablero;

import ui.contenedor.Controles.Tienda.pnlTienda;
import ui.contenedor.FrmMain;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class pnlControles extends JPanel {
	private JButton btnMover;
	private JButton btnPasarTurno;
	private JButton btnAtacar;
	private JButton btnComprar;
	private JButton btnMisTropas;
	private JButton btnTransferirOro;
	private Juego juego;
	private JButton btnUsarPowerUp;

	/**
	 * Create the panel.
	 */
	public pnlControles(int widthTablero, Juego juego) {

		setBorder(new LineBorder(new Color(255, 255, 204, 255)));
		this.juego = juego;
		this.setLayout(null);
		this.setSize(800, 140);
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

		btnTransferirOro = new JButton("Tranferir Oro");
		btnTransferirOro.setBounds(632, 11, 142, 55);
		add(btnTransferirOro);

		agregarAcciones();
	}

	private void agregarAcciones() {
		btnMover.addActionListener(e -> {
			juego.getTablero().setModoMovimiento(true);
			juego.getTablero().setModoAtaque(false);
				// acción de mover
		});

		btnPasarTurno.addActionListener(e -> {
			juego.pasarTurno();
			String jugadorActual = juego.getTurnoActual().getJugador().getNombreJugador();
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
			pnlTienda pnlTienda = new pnlTienda(this.getJuego());
			pnlTienda.setVisible(true);
		});

		btnMisTropas.addActionListener(e -> {
			pnlTropas pnlTropas = new pnlTropas(this.getJuego());
			pnlTropas.setVisible(true);
		});

		btnUsarPowerUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tropa tropa = pnlTablero.getTropaSeleccionada();
				TropaAtaque tropaAtaque = null;
				if (tropa != null && tropa instanceof TropaAtaque) {
					tropaAtaque = (TropaAtaque) tropa;
					if(tropaAtaque.getPowerUp() != null){
						ArrayList<Tropa> tropas = tropaAtaque.getJugador().getTropas();
						tropas.remove(tropaAtaque);
						tropaAtaque = tropaAtaque.usarPowerUp(tropaAtaque);
						tropas.add(tropaAtaque);
						tropaAtaque.getCasilla().setPieza(tropaAtaque);
						mostrarMsg("Tropa: " + tropaAtaque.getNombre() + "" +
								"\nPowerUp: " + ((ObjetoDecorado)tropaAtaque).getNombrePowerUp() + "" +
								"\nDefensa: " + tropaAtaque.getDefensa() + "" +
								"\nAtaque: " + tropaAtaque.getAtaque() + "");
					}
					else {
						mostrarMsg("No tiene Power Up");
					}
				}
				pnlTablero.setTropaSeleccionada(null);
			}
		});

		btnTransferirOro.addActionListener(e -> {
			Tropa tropa = pnlTablero.getTropaSeleccionada();
			if(tropa != null && tropa instanceof TropaAtaque){
				mostrarMsg(((TropaAtaque) tropa).tranferirOroCastillo());
			}
		});
	}

	private void mostrarMsg(String msg) {
		int opcion = 0;
		String cad = msg;
		JOptionPane.showMessageDialog(null, msg, eConfiguracion.TITULO_APP, JOptionPane.INFORMATION_MESSAGE);
	}

	public Juego getJuego() {
		return this.juego;
	}

	public void setJuego(Juego juego) {
		this.juego = juego;
	}
}
