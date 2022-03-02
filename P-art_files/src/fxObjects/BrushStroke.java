package fxObjects;

/*
 * Peter Gauld
 * Stroke Brush - This is meant to create the default brush for the P-art program.
 * 
 * 2/26/2022 - File Created.
 */

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;

public class BrushStroke extends Brush{
	//Attributes
		private double lastX = 0;
		private double lastY = 0;
		//private double midX = 0;
		//private double midY = 0;
	
	public void startStroke(MouseEvent e, GraphicsContext g) {
		lastX = e.getX();
		lastY = e.getY();
		double diameter = g.getLineWidth();
		double radius = diameter/2;
		g.fillOval(lastX - radius, lastY - radius, diameter, diameter);
	}
	
	public void continueStroke(MouseEvent e, GraphicsContext g) {
		double diameter = g.getLineWidth();
		double radius = diameter/2;
		
		double x1 = lastX;
		double y1 = lastY;
		double x2 = e.getX();
		double y2 = e.getY();
		g.fillOval(lastX - radius, lastY - radius, diameter, diameter);
		drawFillLine(x1, y1, x2, y2, g);
		g.fillOval(x2 - radius, y2 - radius, diameter, diameter);
		lastX = e.getX();
		lastY = e.getY();
	}
	
	public void drawFillLine(double ix1, double iy1, double ix2, double iy2, GraphicsContext g) {
		double diameter = g.getLineWidth();
		double radius = diameter/2;
		double angle = getLineAngle(ix1, iy1, ix2, iy2);
		double XDifference = -radius*Math.sin(Math.toRadians(180 - angle));
		double YDifference = -radius*Math.cos(Math.toRadians(180 - angle));
		double x1 = ix1 - XDifference;
		double x2 = ix1 + XDifference;
		double x3 = ix2 + XDifference;
		double x4 = ix2 - XDifference;
		double y1 = iy1 - YDifference;
		double y2 = iy1 + YDifference;
		double y3 = iy2 + YDifference;
		double y4 = iy2 - YDifference;
		
		g.fillPolygon(new double[] {x1, x2, x3, x4}, new double[] {y1, y2, y3, y4}, 4);	
	}
	
	private double getLineAngle(double x1, double y1, double x2, double y2) {
		double angle = 0;
		
		double XDifference = x2 - x1;
		double YDifference = y2 - y1;
		
		angle = Math.toDegrees(Math.atan(YDifference/XDifference));
		
		if(XDifference < 0 && Math.abs(YDifference) > 0)
			angle += 180;
		
		return angle;
	}
}
