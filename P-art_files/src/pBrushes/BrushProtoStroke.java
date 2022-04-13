package pBrushes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;

/*
 * Peter Gauld
 * Proto Stroke Brush - A brush to show off the imperfect version of stroke.
 * 
 * 2/28/2022 - File Created
 */

public class BrushProtoStroke extends Brush{
	public void startStroke(MouseEvent e, GraphicsContext g) {
		double diameter = g.getLineWidth();
		double radius = diameter/2;
		g.strokeOval(e.getX() - radius, e.getY() - radius, diameter, diameter);
	}

	public void continueStroke(MouseEvent e, GraphicsContext g) {
		double diameter = g.getLineWidth();
		double radius = diameter/2;
		g.strokeOval(e.getX() - radius, e.getY() - radius, diameter, diameter);
	}
}
