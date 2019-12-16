package ui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class JButtonRound extends JButton {

	// for mouse detection purposes
	private Shape shape;
	private final int BORDER_RADIUS = 14;

	private final Color[] colorFondo = new Color[] { new Color(255, 255, 255, 255), new Color(238, 238, 238, 255) };

	private final Color[] colorFondoFocus = new Color[] { new Color(210, 244, 254, 235),
			new Color(250, 250, 250, 255) };

	private final Color[] colorFondoPressed = new Color[] { new Color(149, 194, 253, 250),
			new Color(250, 250, 250, 255) };

	public JButtonRound(String label) {
		super(label);
		super.setBorderPainted(true);
		// super.setBorder(null);
		// allows us to paint a round background
		// if true, it would be rectangular
		setContentAreaFilled(false);

		super.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	protected void paintComponent(Graphics g) {
		setContentAreaFilled(false);
		if (ui != null) {
			Graphics scratchGraphics = (g == null) ? null : g.create();
			Graphics2D g2 = (Graphics2D) scratchGraphics;

			GradientPaint gp;

			if (getModel().isRollover() && !getModel().isPressed()) {
				gp = new GradientPaint(0, 0, colorFondoFocus[0], 0, getSize().height - 1, colorFondoFocus[1]);
			} else {
				// if the button is pressed and ready to be released
				if (getModel().isArmed()) {

					gp = new GradientPaint(0, 0, colorFondoPressed[0], 0, getSize().height - 1, colorFondoPressed[1]);
				} else {
					gp = new GradientPaint(0, 0, colorFondo[0], 0, getSize().height - 1, colorFondo[1]);
				}
			}

			// LinearGradient ln = new LinearGradient();

			g2.setPaint(gp);

			g2.fillRoundRect(0, 0, getSize().width - 1, getSize().height - 1, BORDER_RADIUS, BORDER_RADIUS);
			super.paintComponent(g2);
		}
	}

	// paint a round border as opposed to a rectangular one
	protected void paintBorder(Graphics g) {
		g.setColor(super.getForeground());
		g.drawRoundRect(0, 0, getSize().width - 3, getSize().height - 3, BORDER_RADIUS, BORDER_RADIUS);
		super.paintBorder(g);
	}

	// only clicks within the round shape should be accepted
	public boolean contains(int x, int y) {
		if (shape == null || !shape.getBounds().equals(getBounds())) {
			shape = new Ellipse2D.Float(0, 0, getWidth(), getHeight());
		}

		return shape.contains(x, y);
	}
}