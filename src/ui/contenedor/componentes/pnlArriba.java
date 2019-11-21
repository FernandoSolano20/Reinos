package ui.contenedor.componentes;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class pnlArriba extends JPanel {
	private Image imagenfondo;
	private final int ALTURA = 50;

	public pnlArriba(int width) {
		this.setLayout(null);
		this.setSize(width, ALTURA);
		imagenfondo = new ImageIcon(getClass().getResource("/ui/imagenes/fondos.jpg")).getImage()
				.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
	}

	public void paintComponent(Graphics g) {
		g.drawImage(imagenfondo, 0, 0, getWidth(), getHeight(), this);
	}

}
