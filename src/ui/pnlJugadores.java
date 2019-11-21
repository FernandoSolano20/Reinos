package ui;

import javax.swing.JPanel;
import javax.swing.JSpinner;
import java.awt.Font;
import javax.swing.JLabel;

public class pnlJugadores extends JPanel {

	/**
	 * Create the panel.
	 */
	public pnlJugadores() {
		setLayout(null);
		
		JSpinner txtCantidad = new JSpinner();
		txtCantidad.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtCantidad.setBounds(281, 12, 76, 32);
		add(txtCantidad);
		
		JLabel lblCantidadDeJugadores = new JLabel("Cantidad de jugadores");
		lblCantidadDeJugadores.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCantidadDeJugadores.setBounds(89, 12, 182, 32);
		add(lblCantidadDeJugadores);

	}
}
