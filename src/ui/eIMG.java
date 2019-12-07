package ui;

import java.awt.Image;
import javax.swing.ImageIcon;

public class eIMG {

	public static final String IMG_APP = "Xprogram.png";
	public static final String IMG_SALIR = "salir.png";
	public static final String IMG_BALLESTA = "ballesta.png";
	public static final String IMG_CATAPULTA = "catapulta.png";
	public static final String IMG_ARQUERO = "arquero.png";
	public static final String IMG_ESPADACHIN = "espadachin.png";
	public static final String IMG_BERSEQUER = "berserker.png"; // berserker_n.png
	public static final String IMG_MAGO = "mago.png";
	public static final String IMG_ASESINO = "asesino.png";
	public static final String IMG_JINETE = "jinete.png";
	public static final String IMG_ESPIA = "espia.png";
	public static final String IMG_TROPA = "tropa.png";

	public static Image getImage(String nombreImagen) {
		ImageIcon icono = null;
		Image xIMAGEN = null;
		try {
			icono = new ImageIcon(eIMG.class.getResource("/ui/Imagenes/" + nombreImagen));
			xIMAGEN = icono.getImage().getScaledInstance(96, 96, Image.SCALE_SMOOTH);
		} catch (Exception e) {
		}
		return xIMAGEN;
	}

	public static ImageIcon getIcon(String nombreImagen) {
		ImageIcon icono = null;
		try {
			icono = new ImageIcon(eIMG.class.getResource("/ui/Imagenes/" + nombreImagen));
		} catch (Exception e) {
		}
		return icono;
	}

}
