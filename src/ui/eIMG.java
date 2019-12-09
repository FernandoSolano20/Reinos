package ui;

import java.awt.Image;
import javax.swing.ImageIcon;

public final class eIMG {

	private static final String IMG_APP = "Xprogram.png";
	private static final String IMG_SALIR = "salir.png";

	private static final String IMG_BALLESTA = "ballesta_ori.png";
	private static final String IMG_CATAPULTA = "catapulta_ori.png";
	private static final String IMG_ARQUERO = "arquero_ori.png";
	private static final String IMG_ESPADACHIN = "espadachin_ori.png";
	private static final String IMG_BERSEQUER = "berserker_ori.png";
	private static final String IMG_MAGO = "mago_ori.png";
	private static final String IMG_ASESINO = "asesino_ori.png";
	private static final String IMG_JINETE = "jinete_ori.png";
	private static final String IMG_ESPIA = "espia_ori.png";
	private static final String IMG_TROPA = "tropa_ori.png";

	private static final String ICO_BALLESTA = "ballesta.png";
	private static final String ICO_CATAPULTA = "catapulta.png";
	private static final String ICO_ARQUERO = "arquero.png";
	private static final String ICO_ESPADACHIN = "espadachin.png";
	private static final String ICO_BERSEQUER = "berserker.png";
	private static final String ICO_MAGO = "mago.png";
	private static final String ICO_ASESINO = "asesino.png";
	private static final String ICO_JINETE = "jinete.png";
	private static final String ICO_ESPIA = "espia.png";
	private static final String ICO_TROPA = "tropa.png";

	private static final String IMG_CASTILLO1 = "castillo1.png";
	private static final String IMG_CASTILLO2 = "castillo2.png";
	private static final String IMG_CASTILLO3 = "castillo3.png";
	private static final String IMG_CASTILLO4 = "castillo4.png";

	private static final String IMG_POWERUP = "powerup.png";
	private static final String IMG_GEMAAZUL = "gemaazul.png";
	private static final String IMG_GEMABLANCA = "gemablanca.png";
	private static final String IMG_GEMAVERDE = "gemaverde.png";

	public static Image IMAGE_APP = null;
	public static Image IMAGE_SALIR = null;

	public static Image IMAGE_CASTILLO1 = null;
	public static Image IMAGE_CASTILLO2 = null;
	public static Image IMAGE_CASTILLO3 = null;
	public static Image IMAGE_CASTILLO4 = null;

	public static Image IMAGE_BALLESTA = null;
	public static Image IMAGE_CATAPULTA = null;
	public static Image IMAGE_ARQUERO = null;
	public static Image IMAGE_ESPADACHIN = null;
	public static Image IMAGE_BERSEQUER = null;
	public static Image IMAGE_MAGO = null;
	public static Image IMAGE_ASESINO = null;
	public static Image IMAGE_JINETE = null;
	public static Image IMAGE_ESPIA = null;
	public static Image IMAGE_TROPA = null;

	public static Image IMAGE_POWERUP = null;
	public static Image IMAGE_GEMAAZUL = null;
	public static Image IMAGE_GEMABLANCA = null;
	public static Image IMAGE_GEMAVERDE = null;

	public static ImageIcon ICON_BALLESTA = null;
	public static ImageIcon ICON_CATAPULTA = null;
	public static ImageIcon ICON_ARQUERO = null;
	public static ImageIcon ICON_ESPADACHIN = null;
	public static ImageIcon ICON_BERSEQUER = null;
	public static ImageIcon ICON_MAGO = null;
	public static ImageIcon ICON_ASESINO = null;
	public static ImageIcon ICON_JINETE = null;
	public static ImageIcon ICON_ESPIA = null;
	public static ImageIcon ICON_TROPA = null;

	public eIMG() {
		IMAGE_APP = getImage(IMG_APP);
		IMAGE_SALIR = getImage(IMG_SALIR);

		IMAGE_CASTILLO1 = getImage(IMG_CASTILLO1);
		IMAGE_CASTILLO2 = getImage(IMG_CASTILLO2);
		IMAGE_CASTILLO3 = getImage(IMG_CASTILLO3);
		IMAGE_CASTILLO4 = getImage(IMG_CASTILLO4);

		IMAGE_BALLESTA = getImage(IMG_BALLESTA, 55, 47);
		IMAGE_CATAPULTA = getImage(IMG_CATAPULTA, 55, 47);
		IMAGE_ARQUERO = getImage(IMG_ARQUERO, 51, 43);
		IMAGE_ESPADACHIN = getImage(IMG_ESPADACHIN, 55, 47);
		IMAGE_BERSEQUER = getImage(IMG_BERSEQUER, 55, 47);
		IMAGE_MAGO = getImage(IMG_MAGO, 55, 47);
		IMAGE_ASESINO = getImage(IMG_ASESINO, 55, 47);
		IMAGE_JINETE = getImage(IMG_JINETE, 55, 47);
		IMAGE_ESPIA = getImage(IMG_ESPIA, 55, 47);
		IMAGE_TROPA = getImage(IMG_TROPA, 55, 47);

		IMAGE_POWERUP = getImage(IMG_POWERUP, 55, 47);
		IMAGE_GEMAAZUL = getImage(IMG_GEMAAZUL, 55, 47);
		IMAGE_GEMABLANCA = getImage(IMG_GEMABLANCA, 55, 47);
		IMAGE_GEMAVERDE = getImage(IMG_GEMAVERDE, 55, 47);

		ICON_BALLESTA = getIcon(ICO_BALLESTA);
		ICON_CATAPULTA = getIcon(ICO_CATAPULTA);
		ICON_ARQUERO = getIcon(ICO_ARQUERO);
		ICON_ESPADACHIN = getIcon(ICO_ESPADACHIN);
		ICON_BERSEQUER = getIcon(ICO_BERSEQUER);
		ICON_MAGO = getIcon(ICO_MAGO);
		ICON_ASESINO = getIcon(ICO_ASESINO);
		ICON_JINETE = getIcon(ICO_JINETE);
		ICON_ESPIA = getIcon(ICO_ESPIA);
		ICON_TROPA = getIcon(ICO_TROPA);
	}

	public static String getImgSalir() {
		return IMG_SALIR;
	}

	private static Image getImage(String nombreImagen) {
		ImageIcon icono = null;
		Image xIMAGEN = null;
		try {
			icono = new ImageIcon(eIMG.class.getResource("/ui/Imagenes/" + nombreImagen));
			xIMAGEN = icono.getImage();
		} catch (Exception e) {
			if (null != e.getMessage())
				System.err.println("Error en eIMG: " + e.getMessage());
		}
		return xIMAGEN;
	}

	private static Image getImage(String nombreImagen, int escalaWidth, int escalaHeight) {
		ImageIcon icono = null;
		Image xIMAGEN = null;
		try {
			icono = new ImageIcon(eIMG.class.getResource("/ui/Imagenes/" + nombreImagen));
			xIMAGEN = icono.getImage().getScaledInstance(escalaWidth, escalaHeight, Image.SCALE_SMOOTH);
		} catch (Exception e) {
			if (null != e.getMessage())
				System.err.println("Error en eIMG: " + e.getMessage());
		}
		return xIMAGEN;
	}

	public static ImageIcon getIcon(String nombreImagen) {
		ImageIcon icono = null;
		try {
			icono = new ImageIcon(eIMG.class.getResource("/ui/Imagenes/" + nombreImagen));
		} catch (Exception e) {
			if (null != e.getMessage())
				System.err.println("Error en eIMG: " + e.getMessage());
		}
		return icono;
	}

	public static ImageIcon getIcon(Image pImagen) {
		ImageIcon icono = null;
		try {
			icono = new ImageIcon(pImagen);
		} catch (Exception e) {
			if (null != e.getMessage())
				System.err.println("Error en eIMG: " + e.getMessage());
		}
		return icono;
	}

}
