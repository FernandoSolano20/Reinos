package ui.contenedor;

import java.awt.Font;
import java.awt.Frame;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bl.Construccion.Fabricas.FabricadorDeTropas;
import bl.Construccion.Fachada.Fachada;
import bl.Construccion.Juego.Juego;
import bl.Construccion.Jugadores.Jugador;
import bl.Construccion.Tablero.Tablero;
import ui.eConfiguracion;
import ui.eIMG;
import ui.contenedor.Controles.pnlControles;
import ui.contenedor.Controles.pnlDado;
import ui.Tablero.pnlTablero;
import ui.contenedor.componentes.*;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class FrmMain extends JFrame {

	private static Juego juego;

	@SuppressWarnings("unused")
	private eIMG eIMGIniciaConstructor = new eIMG();

	private JPanel pnlMain;
	private JPanel pPnlArriba;
	private JPanel pPnlIzquierda;
	private JPanel pPnlAbajo;
	private JPanel pPnlDerecha;
	private JPanel pPnlCentro;
	private JLabel btnSalir = new JLabel();
	private JLabel txtTitulo = new JLabel();

	private JLabel txtJugador = new JLabel();


	private pnlTablero tableroUI;
	private pnlControles pnlControles;
	private pnlDado dado;

	private int cantidadJugadores = 0;

	/**
	 * Create the frame.
	 */
	public FrmMain() {

		// Se determinan las caracteristicas para la escena del juego
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setBounds(0, 0, 780, 430);
		this.setResizable(false);
		this.setState(Frame.MAXIMIZED_BOTH);
		this.setUndecorated(true);
		this.setTitle(eConfiguracion.TITULO_APP);
		this.setIconImage(eIMG.IMAGE_APP);
		this.setBackground(eConfiguracion.COLOR_FONDO);
		this.setForeground(eConfiguracion.COLOR_LETRA);
		this.setPantallaCompleta();
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent evt) {
				SALIR();
			}
		});

		// Se crea el panel principal
		pnlMain = new JPanel();

		pnlMain.setBorder(new EmptyBorder(5, 5, 5, 5));
		pnlMain.setBackground(eConfiguracion.COLOR_FONDO);
		pnlMain.setForeground(eConfiguracion.COLOR_LETRA);
		pnlMain.setLayout(null);
		pnlMain.setSize(this.getWidth(), this.getHeight());
		this.setContentPane(pnlMain);

		int mainAncho = (pnlMain.getWidth() - pnlMain.getInsets().left - pnlMain.getInsets().right);
		int mainAlto = (pnlMain.getHeight() - pnlMain.getInsets().top - pnlMain.getInsets().bottom);

		// Se crea el panel superior
		pPnlArriba = new pnlArriba(pnlMain.getWidth());
		pPnlArriba.setBounds(0, 0, pPnlArriba.getWidth(), pPnlArriba.getHeight());
		pnlMain.add(pPnlArriba, null);
		int arribaAlto = (pPnlArriba.getHeight() - pPnlArriba.getInsets().top - pPnlArriba.getInsets().bottom);

		// Se crea el boton de salida del juego
		btnSalir.setBackground(new java.awt.Color(71, 71, 71));
		btnSalir.setFont(new Font("Viner Hand ITC", 1, 18));
		btnSalir.setForeground(new java.awt.Color(255, 102, 102));
		btnSalir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		btnSalir.setText("X");
		btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnSalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		btnSalir.setOpaque(false);

		btnSalir.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				SALIR();
			}

			public void mouseEntered(MouseEvent e) {
				btnSalir.setForeground(new java.awt.Color(255, 103, 80));
				btnSalir.setFont(new Font("Viner Hand ITC", 1, 22));
			}

			public void mouseExited(MouseEvent e) {
				btnSalir.setForeground(new java.awt.Color(255, 102, 102));
				btnSalir.setFont(new Font("Viner Hand ITC", 1, 18));
			}
		});

		pPnlArriba.add(btnSalir, null);
		btnSalir.setBounds(pPnlArriba.getWidth() - 40, 0, 40, 35);
		int btnSalirAncho = (btnSalir.getWidth() - btnSalir.getInsets().left - btnSalir.getInsets().right);

		txtTitulo.setFont(new java.awt.Font("Snap ITC", 1, 36));
		txtTitulo.setForeground(new java.awt.Color(249, 249, 249));
		txtTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		txtTitulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		txtTitulo.setText(eConfiguracion.TITULO_APP);
		txtTitulo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		int txtTituloAncho = 500;
		int txtTituloX = (pPnlArriba.getWidth() - btnSalirAncho - txtTituloAncho - pPnlArriba.getInsets().left
				- pPnlArriba.getInsets().right) / 2;
		pPnlArriba.add(txtTitulo, null);
		txtTitulo.setBounds(txtTituloX, 0, txtTituloAncho, 47);

		pPnlAbajo = new pnlAbajo(pnlMain.getWidth());

		pPnlAbajo.add(txtJugador, null);
		txtJugador.setText("           ");
		txtJugador.setFont(new java.awt.Font("Snap ITC", 1, 18));
		txtJugador.setForeground(new java.awt.Color(249, 249, 249));
		txtJugador.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		txtJugador.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		txtJugador.setBounds(40, 0, 400, 40);

		this.setBackground(eConfiguracion.COLOR_FONDO);
		this.setForeground(eConfiguracion.COLOR_LETRA);
		this.setVisible(true);

		int cantidadJugadores = getCantidadDeJugadores();
		this.setCantidadJugadores(cantidadJugadores);
		juego = new Fachada().construirJuego(cantidadJugadores);
		dado = new pnlDado(juego);

		dado.setBounds(40, 60, dado.getWidth(), dado.getHeight());
		pnlControles = new pnlControles(pnlMain.getWidth(), juego, txtJugador, dado);

		pPnlAbajo.add(dado, null);

		pPnlAbajo.add(pnlControles);
		pPnlAbajo.setSize(pPnlAbajo.getWidth(), pnlControles.getHeight());

		int controlesAncho = (pPnlAbajo.getWidth() - pPnlAbajo.getInsets().left - pPnlAbajo.getInsets().right);

		if (controlesAncho > mainAncho) {
			controlesAncho = mainAncho;
		}

		controlesAncho = Math.round((controlesAncho / 2) / 2);

		pnlControles.setBounds(controlesAncho, 0, pnlControles.getWidth(), pnlControles.getHeight());

		pnlControles.setVisible(false);

		pPnlAbajo.setBounds(0, (mainAlto - pPnlAbajo.getHeight()), pnlMain.getWidth(), pPnlAbajo.getHeight());

		int abajoAlto = (pPnlAbajo.getHeight() - pPnlAbajo.getInsets().top - pPnlAbajo.getInsets().bottom);

		int centroAlto = (mainAlto - arribaAlto - abajoAlto);

		pnlMain.add(pPnlAbajo, null);

		// Margen:
		centroAlto -= 5;

		pPnlDerecha = new pnlDerecha(centroAlto);
		pPnlDerecha.setBounds(0, arribaAlto, pPnlDerecha.getWidth(), centroAlto);
		pnlMain.add(pPnlDerecha, null);

		pPnlIzquierda = new pnlIzquierda(centroAlto);
		pPnlIzquierda.setBounds((pnlMain.getWidth() - pPnlIzquierda.getWidth()), arribaAlto, pPnlIzquierda.getWidth(),
				centroAlto);
		pnlMain.add(pPnlIzquierda, null);

		int derechaAncho = (pPnlDerecha.getWidth() - pPnlDerecha.getInsets().left - pPnlDerecha.getInsets().right);
		int izquierdaAncho = (pPnlIzquierda.getWidth() - pPnlIzquierda.getInsets().left
				- pPnlIzquierda.getInsets().right);
		int centroAncho = (mainAncho - derechaAncho - izquierdaAncho);

		pPnlCentro = new JPanel();
		pPnlCentro.setLayout(null);
		pPnlCentro.setBackground(eConfiguracion.COLOR_FONDO);
		pPnlCentro.setBounds(derechaAncho, arribaAlto, centroAncho, centroAlto);
		pnlMain.add(pPnlCentro, null);

	}

	public pnlTablero getTableroUI() {
		return tableroUI;
	}

	public void setTableroUI(Tablero pTablero) {
		this.tableroUI = new pnlTablero(pPnlCentro.getWidth(), pPnlCentro.getHeight(), juego, dado);
	}

	public int pnlCentrogetWidth() {
		return pPnlCentro.getWidth();
	}

	public int pnlCentrogetHeight() {
		return pPnlCentro.getHeight();
	}

	public void limpiarPanelCentral() {
		pPnlCentro.removeAll();
		pPnlCentro.repaint();
	}

	public void setPanelCentral(JPanel nuevoPanel) {
		pPnlCentro.removeAll();
		pPnlCentro.add(nuevoPanel);
		pPnlCentro.repaint();
	}

	public void setPanelAbajo(JPanel nuevoPanel) {
		System.out.println("nuevo: " + nuevoPanel.getWidth() + " - " + nuevoPanel.getHeight());
		pPnlAbajo.removeAll();
		pPnlAbajo.add(nuevoPanel, null);
		pPnlAbajo.setBounds(nuevoPanel.getBounds());
		pPnlAbajo.repaint();
		pPnlAbajo.setVisible(true);
	}

	private void SALIR() {
		Object[] opciones = { "Si", "Cancelar" };
		Icon icono = null;
		try {
			icono = eIMG.getIcon(eIMG.getImgSalir());
		} catch (Exception e) {
		}
		int opcion = JOptionPane.showOptionDialog(null, "<html><b>¿Seguro que desea salir?</b></html>", " ",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, icono, opciones, opciones[1]);

		if (opcion == JOptionPane.YES_OPTION) {
			this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
			this.setVisible(false);
			this.dispose();
			System.exit(0);
		}
	}

	private void setPantallaCompleta() {
		// Toolkit para conocer la resolución de la pantalla.
		int largoBarraTareas = Toolkit.getDefaultToolkit().getScreenInsets(getGraphicsConfiguration()).bottom;
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(screenSize.width, screenSize.height - largoBarraTareas);
	}

	public void mostrarTablero() {
		setPanelCentral(tableroUI);
		pnlControles.setVisible(true);
	}

	public int getCantidadJugadores() {
		return cantidadJugadores;
	}

	public void setCantidadJugadores(int cantidadJugadores) {
		this.cantidadJugadores = cantidadJugadores;
	}

	private int getCantidadDeJugadores() {
		int opcion = 0;
		String cad = "Seleccione la cantidad de jugadores:\n";
		String[] opciones = { "          2          ", "          3          ", "          4          " };
		do {
			opcion = JOptionPane.showOptionDialog(null, cad, eConfiguracion.TITULO_APP,
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);
			opcion += 2;
		} while (opcion != 2 && opcion != 3 && opcion != 4);

		return opcion;
	}

	public void pasarTurno() {
		juego.pasarTurno();
	}

	public void iniciar() {

		// Envía el tablero a pnlTablero:
		this.setTableroUI(juego.getTablero());

		// Nombre del jugador:
		int numJugador = 1;
		for (Jugador jugador : juego.getJugadores()) {
			jugador.setNombreJugador("Jugador" + numJugador);
			++numJugador;
		}

		txtJugador.setText(getJuego().getTurnoActual().getJugador().getNombreJugador());

		// Mostrar el tablero:
		this.mostrarTablero();
	}

	public Juego getJuego() {
		return juego;
	}

	@SuppressWarnings("static-access")
	public void setJuego(Juego juego) {
		this.juego = juego;
	}

	public JLabel getTxtJugador() {
		return txtJugador;
	}

	public void setTxtJugador(JLabel txtJugador) {
		this.txtJugador = txtJugador;
	}

}
