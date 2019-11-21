package ui;

import java.awt.Cursor;
import java.io.IOException;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import bl.Construccion.FabricadorDeTropas;
import bl.Construccion.Fachada.Fachada;
import bl.Construccion.Juego.Juego;
import bl.Construccion.Jugadores.Jugador;
import bl.Construccion.Tropa.TropaAtaque.Arquero;
import bl.Construccion.Tropa.TropaAtaque.TropaAtaque;
import ui.contenedor.FrmMain;
import ui.contenedor.OSUtil;

public class Main {
	private static FrmMain elMain;

	private static Fachada fachada = new Fachada();
	private static Juego juego;

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
				iniciar();
			}
		});
	}

	private static void iniciar() {

		elMain = new FrmMain();
		elMain.setVisible(true);

		// TODO: Crear panel donde selecciona la cantidad de jugadores y se escribe el
		// nombre de cada jugador:
		int cantidadJugadores = 3;

		if (cantidadJugadores < 5) {

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

			juego = fachada.construirJuego(cantidadJugadores);

			if (null != juego) {

				elMain.setTableroUI(juego.getTablero());

				for (Jugador jugador : juego.getJugadores()) {
					System.out.println(jugador.getNombreJugador());
				}

				// Mostrar el tablero:
				elMain.mostrarTablero();

				TropaAtaque pieza = new Arquero();
				juego.getJugadores().get(0).getTropas().add(pieza);

				// Ejemplo:
				juego.getTablero().getCasillas()[0][1].setPieza(pieza);
				System.out.println(juego.getTablero().recorrerTablero());

				// Pintar casillas que no están vacias:
				for (int i = 0; i < juego.getTablero().getAncho(); i++) {
					for (int j = 0; j < juego.getTablero().getLargo(); j++) {
						if (juego.getTablero().getCasillas()[i][j].getPieza() != null) {
							String nombrePieza = juego.getTablero().getCasillas()[i][j].getPieza().getNombre();
							elMain.getTableroUI().construirEnCasilla(i, j, nombrePieza);

						}
					}
				}

			} else {
				elMain.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
				elMain.setVisible(false);
				elMain.dispose();
				System.err.println("No está permitido un jugador");
				System.exit(0);
			}
		} else {
			elMain.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
			elMain.setVisible(false);
			elMain.dispose();
			System.err.println("No está permitido más de 4 jugadores");
			System.exit(0);
		}
	}
}
