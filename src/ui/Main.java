package ui;

import java.awt.Color;
import java.io.IOException;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import bl.Construccion.FabricadorDeTropas;
import bl.Construccion.Fachada.Fachada;
import bl.Construccion.Juego.Juego;
import bl.Construccion.Jugadores.Jugador;
import ui.Tablero.pnlTablero;
import ui.contenedor.FrmMain;
import ui.contenedor.OSUtil;

public class Main {
	private static FrmMain elMain;

	/**
	 * Launch the application.
	 */
	public static void main(String args[]) throws IOException {

		System.out.println(FabricadorDeTropas.procesarFuncion(1));
		System.out.println(FabricadorDeTropas.procesarFuncion(2));
		System.out.println(FabricadorDeTropas.procesarFuncion(3));
		System.out.println(FabricadorDeTropas.procesarFuncion(4));
		System.out.println(FabricadorDeTropas.procesarFuncion(5));
		System.out.println(FabricadorDeTropas.procesarFuncion(6));
		System.out.println(FabricadorDeTropas.procesarFuncion(7));
		System.out.println(FabricadorDeTropas.procesarFuncion(8));
		System.out.println(FabricadorDeTropas.procesarFuncion(9));
		System.out.println(FabricadorDeTropas.procesarFuncion(10));

		System.out.print("Cantidad de jugadores: ");

		// TODO: Crear panel donde selecciona la cantidad de jugadores y se escribe el
		// nombre de cada jugador:
		int cantidadJugadores = 4;

		Fachada fachada = new Fachada();

		Juego juego = fachada.construirJuego(cantidadJugadores);
		if (null != juego) {
			for (Jugador jugador : juego.getJugadores()) {
				System.out.println(jugador.getNombreJugador());
			}
		} else {
			System.err.println("No está permitido un jugador");
			return;
		}

		try {
			// javax.swing.UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

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
				elMain = new FrmMain();
				elMain.setVisible(true);

				// Mostrar el tablero para demostración:
				elMain.mostrarTablero();

				// Pintar casillas para demostración:
				int[][] inicioCasilla = new int[][] { { 0, 0 }, { 9, 9 }, { 9, 0 }, { 0, 9 } };
				for (int i = 0; i < cantidadJugadores; ++i) {
					elMain.getTableroUI().pintarCasilla(inicioCasilla[i][0], inicioCasilla[i][1]);
				}

			}
		});
	}
}
