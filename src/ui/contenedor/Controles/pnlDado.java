package ui.contenedor.Controles;

import javax.swing.JPanel;

import bl.Construccion.Juego.Juego;
import ui.eConfiguracion;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class pnlDado extends JPanel {

	private Juego juego;
	private JLabel lblNumero = new JLabel("___");

	/**
	 * Create the panel.
	 */
	public pnlDado(Juego juego) {
		this.juego = juego;
		setLayout(null);
		this.setOpaque(true);
		this.setSize(230, 45);
		setBorder(new LineBorder(new Color(255, 255, 204, 255)));
		this.setBackground(eConfiguracion.COLOR_FONDO);
		this.setForeground(eConfiguracion.COLOR_LETRA);

		lblNumero.setForeground(eConfiguracion.COLOR_LETRA);
		lblNumero.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumero.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNumero.setBounds(0, 0, 126, 40);
		add(lblNumero, null);

		JButton btnTirarDado = new JButton("Tirar dado");
		btnTirarDado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnTirarDadoClick(arg0);
			}

		});
		btnTirarDado.setBounds(136, 10, 81, 23);
		add(btnTirarDado);

	}

	public void btnTirarDadoClick(ActionEvent arg0) {
		this.setNumero(juego.tirarDado());
	}

	public String getNumero() {
		return this.lblNumero.getText();
	}

	public void setNumero(int lblNumero) {
		this.lblNumero.setText("" + lblNumero);
	}

	public void limpiarNumero() {
		this.lblNumero.setText("___");
	}

}
