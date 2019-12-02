package ui;

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

	/**
	 * Create the panel.
	 */
	public pnlControles(int widthTablero) {
		setBorder(new LineBorder(Color.RED));
		this.setLayout(null);
		this.setSize(603, 140);
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

		agregarAcciones();
	}

	private void agregarAcciones() {
		btnMover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// acción de mover
			}
		});

		btnPasarTurno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// acción de pasar turno
			}
		});

		btnAtacar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// acción de atacar
			}
		});
		btnComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// acción de comprar
			}
		});
		btnMiOro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// acción de mi oro
			}
		});
		btnMisTropas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// acción de mis tropas
			}
		});
	}
}
