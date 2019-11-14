package ui.contenedor;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import ui.eConfiguracion;
import ui.Tablero.pnlTablero;
import ui.contenedor.componentes.*;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.MouseEvent;

public class FrmMain extends JFrame {

	private JPanel pnlMain;
	private JPanel pPnlArriba;
	private JPanel pPnlIzquierda;
	private JPanel pPnlAbajo;
	private JPanel pPnlDerecha;
	private JPanel pPnlCentro;
	private JLabel btnSalir = new JLabel();
	private JLabel txtTitulo = new JLabel();
	private final int PNL_CENTRAL_BORDE = 4;

	private pnlTablero tableroUI;

	/**
	 * Create the frame.
	 */
	public FrmMain() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(0, 0, 780, 430);
		this.setResizable(false);
		this.setState(Frame.MAXIMIZED_BOTH);
		setUndecorated(true);
		setTitle("Reinos Cenfotecos");
		this.setIcono(this, "/ui/imagenes/Xprogram.png");
		this.setBackground(eConfiguracion.COLOR_FONDO);
		this.setForeground(eConfiguracion.COLOR_LETRA);
		setPantallaCompleta();
		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent evt) {
				SALIR();
			}
		});

		pnlMain = new JPanel();
		pnlMain.setBorder(new EmptyBorder(5, 5, 5, 5));
		pnlMain.setBackground(eConfiguracion.COLOR_FONDO);
		pnlMain.setForeground(eConfiguracion.COLOR_LETRA);
		pnlMain.setLayout(null);
		pnlMain.setSize(this.getWidth(), this.getHeight());
		setContentPane(pnlMain);

		int mainAncho = (pnlMain.getWidth() - pnlMain.getInsets().left - pnlMain.getInsets().right);
		int mainAlto = (pnlMain.getHeight() - pnlMain.getInsets().top - pnlMain.getInsets().bottom);

		pPnlArriba = new pnlArriba(pnlMain.getWidth());
		pPnlArriba.setBounds(0, 0, pPnlArriba.getWidth(), pPnlArriba.getHeight());
		pnlMain.add(pPnlArriba, null);
		int arribaAlto = (pPnlArriba.getHeight() - pPnlArriba.getInsets().top - pPnlArriba.getInsets().bottom);

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
		pPnlAbajo.setBounds(0, (mainAlto - pPnlAbajo.getHeight()), pnlMain.getWidth(), pPnlAbajo.getHeight());
		pnlMain.add(pPnlAbajo, null);
		int abajoAlto = (pPnlAbajo.getHeight() - pPnlAbajo.getInsets().top - pPnlAbajo.getInsets().bottom);

		int centroAlto = (mainAlto - arribaAlto - abajoAlto);

		pPnlDerecha = new pnlDerecha(centroAlto);
		pPnlDerecha.setBounds(0, arribaAlto, pPnlDerecha.getWidth(), centroAlto);
		pnlMain.add(pPnlDerecha, null);

		pPnlIzquierda = new pnlIzquierda(centroAlto);
		pPnlIzquierda.setBounds((pnlMain.getWidth() - pPnlIzquierda.getWidth()), arribaAlto, pPnlIzquierda.getWidth(), centroAlto);
		pnlMain.add(pPnlIzquierda, null);

		int derechaAncho = (pPnlDerecha.getWidth() - pPnlDerecha.getInsets().left - pPnlDerecha.getInsets().right);
		int izquierdaAncho = (pPnlIzquierda.getWidth() - pPnlIzquierda.getInsets().left
				- pPnlIzquierda.getInsets().right);
		int centroAncho = (mainAncho - derechaAncho - izquierdaAncho);

		pPnlCentro = new JPanel();
		pPnlCentro.setLayout(null);
		pPnlCentro.setBackground(new Color(47, 79, 79, 255));
		pPnlCentro.setBounds(derechaAncho, arribaAlto, centroAncho, centroAlto);
		pnlMain.add(pPnlCentro, null);

		tableroUI = new pnlTablero(pPnlCentro.getWidth(), pPnlCentro.getHeight());

	}

	public pnlTablero getTableroUI() {
		return tableroUI;
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

	private void SALIR() {
		Object[] opciones = { "Si", "Cancelar" };
		Icon icono = null;
		try {
			icono = new ImageIcon(this.getClass().getResource("/ui/Imagenes/salir.png"));
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

	private void setIcono(JFrame contenedor, String nombreImagen) {
		try {
			Image xIMAGEN = new ImageIcon(getClass().getResource(nombreImagen)).getImage().getScaledInstance(96, 96,
					Image.SCALE_SMOOTH);

			contenedor.setIconImage(xIMAGEN);
		} catch (Exception ex) {
			System.err.println("no cargó icono!");
		}
	}

	public void mostrarTablero() {
		setPanelCentral(tableroUI);
	}

}
