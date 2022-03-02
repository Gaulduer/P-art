package fxObjects;

/*
 * Peter Gauld
 * Marker Brush - This is meant to create a marker brush for the P-art program.
 * 
 * 2/25/2022 - File Created. Lines are a bit rough, but works as a brush.
 */

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;

public class BrushMarker extends Brush {
	private int lineWidth;
	private double lastX;
	private double lastY;

	public void startStroke(MouseEvent e, GraphicsContext g) {
		lastX = e.getX();
		lastY = e.getY();
		g.strokeLine(lastX, lastY, lastX, lastY);
	}

	public void continueStroke(MouseEvent e, GraphicsContext g) {
		g.setLineWidth(lineWidth);
		g.strokeLine(lastX, lastY, e.getX(), e.getY());
		lastX = e.getX();
		lastY = e.getY();
	}

}
