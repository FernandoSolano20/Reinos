package ui.contenedor.Controles.Tropas;

import bl.Construccion.Juego.Juego;
import bl.Construccion.Tropa.Tropa;
import ui.Tablero.pnlTablero;
import ui.eConfiguracion;
import ui.eIMG;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class pnlTropas extends JFrame {

	// Juego
	private Juego juego;

	// Paneles
	private JPanel panelPrincipal;
	private JPanel panelBotones;

	// Labels
	private JLabel titulo;
	private JLabel descripcion;

	// Botones tropas
	private final int CANTIDADBOTONES = 7;
	ArrayList<JButton> botones = new ArrayList<>();

	public pnlTropas(Juego juego) {

		setJuego(juego);
		this.setSize(400, 600);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setTitle(eConfiguracion.TITULO_APP);
		this.setIconImage(eIMG.IMAGE_APP);
		this.setBackground(eConfiguracion.COLOR_FONDO);
		this.setForeground(eConfiguracion.COLOR_LETRA);
		this.setAlwaysOnTop(false);
		// centrar:
		this.setLocationRelativeTo(null);

		// PANEL PRINCIPAL
		panelPrincipal = new JPanel();
		panelPrincipal.setPreferredSize(new Dimension(400, 400));
		panelPrincipal.setLayout(new FlowLayout());
		this.add(panelPrincipal);

		titulo = new JLabel("Mis tropas");
		titulo.setFont(new Font(titulo.getFont().getName(), titulo.getFont().getStyle(), 20));
		titulo.setBackground(new Color(46, 139, 87));
		titulo.setOpaque(true);
		titulo.setPreferredSize(new Dimension(400, 75));
		titulo.setHorizontalAlignment(JLabel.CENTER);
		titulo.setVerticalAlignment(JLabel.CENTER);
		panelPrincipal.add(titulo);

		// Label descripcion
		descripcion = new JLabel("Seleccione la tropa que desea agregar: ");
		descripcion.setFont(new Font(titulo.getFont().getName(), titulo.getFont().getStyle(), 15));
		descripcion.setBackground(new Color(60, 179, 113));
		descripcion.setOpaque(true);
		descripcion.setPreferredSize(new Dimension(400, 45));
		descripcion.setHorizontalAlignment(JLabel.CENTER);
		descripcion.setVerticalAlignment(JLabel.CENTER);
		panelPrincipal.add(descripcion);

		// Panel botones
		panelBotones = new JPanel();
		panelBotones.setBorder(new LineBorder(Color.BLACK));
		panelBotones.setPreferredSize(new Dimension(400, 400));
		panelBotones.setLayout(new GridLayout(7, 1));

		// Se crean y se agregan todos los botones al panel de botones
		panelPrincipal.add(panelBotones);
		crearBotones();
		agregarEventos();

	}

	// Metodo para crear los botones dinamicamente
	private void crearBotones() {
		JButton botonTropa;
		ArrayList<Tropa> tropasJugador = getJuego().getTurnoActual().getJugador().getTropas();
		int posicion = 0;
		for (int i = 0; i < CANTIDADBOTONES; i++) {
			if (tropasJugador.size() > i && !tropasJugador.get(i).isEnJuego()) {
				botonTropa = new JButton(tropasJugador.get(i).getNombre());
			} else if (tropasJugador.size() > i && tropasJugador.get(i).isEnJuego()) {
				botonTropa = new JButton(tropasJugador.get(i).getNombre() + " (En juego)");
				botonTropa.setEnabled(false);
			} else {
				posicion = i + 1;
				botonTropa = new JButton("Tropa " + posicion);
				botonTropa.setEnabled(false);
			}
			botones.add(botonTropa);
			panelBotones.add(botonTropa);
		}
	}

	private void agregarEventos() {
		botones.get(0).addActionListener(e -> seleccionarTropa(0));
		botones.get(1).addActionListener(e -> seleccionarTropa(1));
		botones.get(2).addActionListener(e -> seleccionarTropa(2));
		botones.get(3).addActionListener(e -> seleccionarTropa(3));
		botones.get(4).addActionListener(e -> seleccionarTropa(4));
		botones.get(5).addActionListener(e -> seleccionarTropa(5));
		botones.get(6).addActionListener(e -> seleccionarTropa(6));
	}

	private void seleccionarTropa(int pPosicionTropa) {
		int cantidadTropas = getJuego().getTurnoActual().getJugador().getTropas().size();
		Tropa tropaSeleccionada;

		if (pPosicionTropa < cantidadTropas) {
			tropaSeleccionada = getJuego().getTurnoActual().getJugador().getTropas().get(pPosicionTropa);
			pnlTablero.setTropaSeleccionada(tropaSeleccionada);
			getJuego().getTablero().setModoColocarPieza(true);
			mostrarMensaje(tropaSeleccionada.getNombre());
			this.dispose();
		}
	}

	private void mostrarMensaje(String pNombreTropa) {
		JOptionPane.showMessageDialog(new JPanel(), "Colocando " + pNombreTropa, "Colocar pieza",
				JOptionPane.INFORMATION_MESSAGE);

	}

	public Juego getJuego() {
		return juego;
	}

	public void setJuego(Juego juego) {
		this.juego = juego;
	}

	public ArrayList<JButton> getBotones() {
		return botones;
	}

	public void setBotones(ArrayList<JButton> botones) {
		this.botones = botones;
	}
}
