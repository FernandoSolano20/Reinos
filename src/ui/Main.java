package ui;

import java.io.IOException;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import bl.Construccion.Tablero.Tablero;
import bl.Construccion.Tropa.TropaAtaque.Arquero;
import bl.Construccion.Tropa.TropaAtaque.TropaAtaque;
import ui.contenedor.FrmMain;
import ui.contenedor.OSUtil;

public class Main {
	private static Tablero tablero;

	public static void main(String args[]) throws IOException {

		try {
			OSUtil.OS_TYPE os = OSUtil.getOSType();
			if (os == OSUtil.OS_TYPE.WINDOWS) {
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			} else {
				for (LookAndFeelInfo ui : UIManager.getInstalledLookAndFeels()) {
					System.out.println("Available look and feel: " + ui.getName() + " " + ui.getClassName());
					if (ui.getName().equals("Nimbus")) {
						UIManager.setLookAndFeel(ui.getClassName());
						break;
					}
				}
			}
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				FrmMain elMain = new FrmMain();
				elMain.setVisible(true);
				elMain.iniciar();
			}
		});
	}
}
