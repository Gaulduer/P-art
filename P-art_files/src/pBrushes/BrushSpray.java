/*
 * Peter Gauld
 * Spray Brush - A brush that emulates a spray can!
 * 
 * 4/13/2022 - File created.
 */

package pBrushes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;

public class BrushSpray extends Brush{
	int circlesPerTick = 100;
	
	public void startStroke(MouseEvent e, GraphicsContext g) {
		double diameter = g.getLineWidth();
		double radius = diameter/2;
		for(int i = 0 ; i < circlesPerTick ; i++) {
			double randomX = -radius + diameter*Math.random();
			double randomY = -radius + diameter*Math.random();
			g.strokeOval(e.getX() - radius + randomX, e.getY() - radius + randomY, diameter/circlesPerTick, diameter/circlesPerTick);
		}
	}
	
	public void continueStroke(MouseEvent e, GraphicsContext g) {

	}	
}
