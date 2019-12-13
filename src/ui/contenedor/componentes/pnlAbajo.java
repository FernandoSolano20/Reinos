package ui.contenedor.componentes;

import javax.swing.*;

import ui.eConfiguracion;

import java.awt.*;

@SuppressWarnings("serial")
public class pnlAbajo extends JPanel {

	private final int ALTURA = 25;

	public pnlAbajo(int width) {
		this.setLayout(null);
		this.setSize(width, ALTURA);
		this.setBackground(eConfiguracion.COLOR_FONDO);
		this.setForeground(eConfiguracion.COLOR_LETRA);
	}

}
