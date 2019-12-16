package ui.contenedor.Controles.Tienda;
import bl.Construccion.Juego.Juego;

import ui.eConfiguracion;
import ui.eIMG;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

@SuppressWarnings("serial")
public class pnlTienda extends JFrame {

	@SuppressWarnings("unused")
    private Juego juego;

	private JPanel panelPrincipal;
	private JPanel panelTropas;
	private JPanel panelDefensas;

	private JLabel titulo;
	private JLabel tropas;
	private JLabel defensas;
	private JLabel oroJugador;

	// Botones tropas ataque
	private JButton arquero;
	private JButton asesino;
	private JButton bersequer;
	private JButton espadachin;
	private JButton espia;
	private JButton jinete;
	private JButton mago;

	// Botones tropas defensa
	private JButton catapulta;
	private JButton ballesta;

    public pnlTienda(Juego juego){
        setJuego(juego);
		this.setSize(600, 600);
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
		GridBagLayout layout = new GridBagLayout();
		panelPrincipal.setLayout(layout);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;

		// LABEL Titulo principal
		titulo = new JLabel("Tienda");
		titulo.setFont(new Font(titulo.getFont().getName(), titulo.getFont().getStyle(), 20));
		titulo.setBorder(new LineBorder(Color.BLACK));
		titulo.setBackground(new Color(46, 139, 87));
		titulo.setOpaque(true);
		titulo.setPreferredSize(new Dimension(250, 65));
		titulo.setHorizontalAlignment(JLabel.CENTER);
		titulo.setVerticalAlignment(JLabel.CENTER);
		gbc.gridwidth = 2;
		gbc.gridx = 0;
		gbc.gridy = 0;
		panelPrincipal.add(titulo, gbc);

		// Label oro disponible
        oroJugador = new JLabel("Oro disponible: " + getJuego().getTurnoActual().getJugador().getCastillo().getOros());
        oroJugador.setFont(new Font(oroJugador.getFont().getName(), oroJugador.getFont().getStyle(), 15));
        oroJugador.setBorder(new LineBorder(Color.BLACK));
        oroJugador.setBackground(new Color(60,179,113));
        oroJugador.setOpaque(true);
        oroJugador.setPreferredSize(new Dimension(250, 30));
        oroJugador.setHorizontalAlignment(JLabel.CENTER);
        oroJugador.setVerticalAlignment(JLabel.CENTER);
        gbc.gridwidth = 2;

		gbc.gridx = 0;
		gbc.gridy = 1;
		panelPrincipal.add(oroJugador, gbc);

		// Label tropas
		tropas = new JLabel("Tropas");
		tropas.setFont(new Font(tropas.getFont().getName(), tropas.getFont().getStyle(), 15));
		tropas.setBorder(new LineBorder(Color.BLACK));
		tropas.setBackground(new Color(60, 179, 113));
		tropas.setOpaque(true);
		tropas.setPreferredSize(new Dimension(250, 45));
		tropas.setHorizontalAlignment(JLabel.CENTER);
		tropas.setVerticalAlignment(JLabel.CENTER);
		gbc.gridwidth = 1;
		gbc.gridx = 0;
		gbc.gridy = 2;

		panelPrincipal.add(tropas, gbc);

		// Label defensas
		defensas = new JLabel("Defensas");
		defensas.setFont(new Font(defensas.getFont().getName(), defensas.getFont().getStyle(), 15));
		defensas.setBorder(new LineBorder(Color.BLACK));
		defensas.setBackground(new Color(60, 179, 113));
		defensas.setOpaque(true);
		defensas.setPreferredSize(new Dimension(250, 45));
		defensas.setHorizontalAlignment(JLabel.CENTER);
		defensas.setVerticalAlignment(JLabel.CENTER);

		gbc.gridx = 1;
		gbc.gridy = 2;
		panelPrincipal.add(defensas, gbc);

		// Panel tropas
		panelTropas = new JPanel();
		panelTropas.setBorder(new LineBorder(Color.BLACK));
		panelTropas.setPreferredSize(new Dimension(250, 300));
		panelTropas.setLayout(new GridLayout(7, 1));

		gbc.gridx = 0;
		gbc.gridy = 3;
		panelPrincipal.add(panelTropas, gbc);

		// Panel defensas
		panelDefensas = new JPanel();
		panelDefensas.setBorder(new LineBorder(Color.BLACK));
		panelDefensas.setPreferredSize(new Dimension(250, 300));
		panelDefensas.setLayout(new GridLayout(7, 1));

		gbc.gridx = 1;
		gbc.gridy = 3;
		panelPrincipal.add(panelDefensas, gbc);

		// Botones tropas

		arquero = new JButton("    Arquero       -   10 oro");
		setIconButton(arquero, eIMG.ICON_ARQUERO);
		panelTropas.add(arquero);

		asesino = new JButton("   Asesino        -     5 oro");
		setIconButton(asesino, eIMG.ICON_ASESINO);
		panelTropas.add(asesino);

		bersequer = new JButton("   Berserquer    -   25 oro");
		setIconButton(bersequer, eIMG.ICON_BERSEQUER);
		panelTropas.add(bersequer);

		espadachin = new JButton("   Espadachín  -   15 oro");
		setIconButton(espadachin, eIMG.ICON_ESPADACHIN);
		panelTropas.add(espadachin);

		espia = new JButton("    Espía            -     5 oro");
		setIconButton(espia, eIMG.ICON_ESPIA);
		panelTropas.add(espia);

		jinete = new JButton(" Jinete             -  15 oro  ");
		setIconButton(jinete, eIMG.ICON_JINETE);
		panelTropas.add(jinete);

		mago = new JButton("   Mago            -   10 oro");
		setIconButton(mago, eIMG.ICON_MAGO);
		panelTropas.add(mago);

		// Botones defensas

		catapulta = new JButton("   Catapulta   -  8 oro");
		setIconButton(catapulta, eIMG.ICON_CATAPULTA);
		panelDefensas.add(catapulta);

		ballesta = new JButton("   Ballesta      -  5 oro");
		setIconButton(ballesta, eIMG.ICON_BALLESTA);
		panelDefensas.add(ballesta);

		this.add(panelPrincipal, BorderLayout.PAGE_START);
		pack();
		agregarAcciones();
	}

	private void agregarAcciones() {
		ballesta.addActionListener(e -> comprarTropa(1));
		catapulta.addActionListener(e -> comprarTropa(2));
		arquero.addActionListener(e -> comprarTropa(3));
		espadachin.addActionListener(e -> comprarTropa(4));
		bersequer.addActionListener(e -> comprarTropa(5));
		mago.addActionListener(e -> comprarTropa(6));
		asesino.addActionListener(e -> comprarTropa(7));
		jinete.addActionListener(e -> comprarTropa(8));
		espia.addActionListener(e -> comprarTropa(9));
	}

	private void comprarTropa(int tipoTropa) {

		try {
			boolean compraRealizada = false;

            compraRealizada = getJuego().getTienda().comprarTropa(getJuego().getTurnoActual().getJugador(), tipoTropa);

			if (compraRealizada) {
				mostrarMensaje();
				actualizarOro();
			}

		} catch (Exception exc) {
			System.out.println(exc);
		}
	}

	private void mostrarMensaje() {
		JOptionPane.showMessageDialog(new JPanel(), "La tropa ha sido agregada correctamente", "Compra completada",
				JOptionPane.INFORMATION_MESSAGE);
	}

	private void actualizarOro() {
        oroJugador.setText("Oro disponible: " + getJuego().getTurnoActual().getJugador().getCastillo().getOros());
    }

    public Juego getJuego() {
        return juego;
    }

    public void setJuego(Juego juego) {
        this.juego = juego;
	}

	private void setIconButton(JButton btn, ImageIcon imagenIcono) {
		btn.setIcon(imagenIcono);
		btn.setSelectedIcon(imagenIcono);
		btn.setIconTextGap(2);
		btn.setHorizontalAlignment(SwingConstants.CENTER);
		btn.setVerticalAlignment(SwingConstants.CENTER);
		btn.setHorizontalTextPosition(SwingConstants.RIGHT);
		btn.setVerticalTextPosition(SwingConstants.CENTER);
	}
}
