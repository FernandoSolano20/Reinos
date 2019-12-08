package ui;

import bl.Construccion.Tropa.Tropa;
import bl.Construccion.Tropa.TropaAtaque.TropaAtaque;
import ui.Tablero.pnlTablero;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class pnlControles extends JPanel {
	private JButton btnMover;
	private JButton btnPasarTurno;
	private JButton btnAtacar;
	private JButton btnComprar;
	private JButton btnMiOro;
	private JButton btnMisTropas;
	private JButton btnUsarPowerUp;

	/**
	 * Create the panel.
	 */
	public pnlControles(int widthTablero) {
		setBorder(new LineBorder(Color.RED));
		this.setLayout(null);
		this.setSize(800, 140);
		this.setBackground(new java.awt.Color(51, 51, 51));
		this.setForeground(new java.awt.Color(250, 250, 250));

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
		btnMiOro = new JButton("Mi oro");
		btnMiOro.setBounds(429, 11, 142, 55);
		add(btnMiOro);
		btnMisTropas = new JButton("Mis tropas");
		btnMisTropas.setBounds(429, 69, 142, 55);
		add(btnMisTropas);

		btnUsarPowerUp = new JButton("Usar power up");
		btnUsarPowerUp.setBounds(600, 11, 142, 55);
		add(btnUsarPowerUp);

		agregarAcciones();
	}

	private void agregarAcciones() {
		btnMover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// acci�n de mover
			}
		});

		btnPasarTurno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// acci�n de pasar turno
			}
		});

		btnAtacar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(pnlTablero.getTropaSeleccionada() != null)
					pnlTablero.isAtaque = true;
			}
		});
		btnComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// acci�n de comprar
			}
		});
		btnMiOro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// acci�n de mi oro
			}
		});
		btnMisTropas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// acci�n de mis tropas
			}
		});
		btnUsarPowerUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tropa tropa = pnlTablero.getTropaSeleccionada();
				TropaAtaque tropaAtaque = null;
				if (tropa != null && tropa instanceof TropaAtaque){
					tropaAtaque = (TropaAtaque) tropa;
					tropaAtaque = tropaAtaque.usarPowerUp(tropaAtaque);
					tropaAtaque.getCasilla().setPieza(tropaAtaque);
					pnlTablero.setTropaSeleccionada(null);
				}
			}
		});
	}
}
