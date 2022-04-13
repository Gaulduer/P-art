package pBrushes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;

/*
 * Peter Gauld
 * 
 * 3/1/2022 - File Created.
 */

public class BrushStrokePlus extends Brush{
	//Attributes
			//private double lastX = 0;
			//private double lastY = 0;
			//private double midX = 0;
			//private double midY = 0;
		
		public void startStroke(MouseEvent e, GraphicsContext g) {
			//lastX = e.getX();
			//lastY = e.getX();
			//midX = e.getX();
			//midY = e.getX();
			
			double diameter = g.getLineWidth();
			double radius = diameter/2;
			
			double x1 = 100;
			double y1 = 100;
			double x2 = 200;
			double y2 = 100;
			double x3 = 300;
			double y3 = 200;
			double x4 = 400;
			double y4 = 200;
				
			g.fillOval(x1 - radius, y2 - radius, diameter, diameter);
			drawFillLine(x1, y1, x2, y2, g);
			g.fillOval(x2 - radius, y2 - radius, diameter, diameter);
			//drawFillLine(x2, y2, x3, y3, g);
			drawSmoothLine(x2, y2, x3, y3, g);
			g.fillOval(x3 - radius, y3 - radius, diameter, diameter);
			drawFillLine(x3, y3, x4, y4, g);
			g.fillOval(x4 - radius, y4 - radius, diameter, diameter);
			
			/*
			lastX = e.getX();
			lastY = e.getY();
			double diameter = g.getLineWidth();
			double radius = diameter/2;
			g.fillOval(lastX - radius, lastY - radius, diameter, diameter);
			*/
		}

		public void continueStroke(MouseEvent e, GraphicsContext g) {
			/*
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
			*/
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
		
		public void drawSmoothLine(double ix1, double iy1, double ix2, double iy2, GraphicsContext g) {
			double diameter = g.getLineWidth();
			double radius = diameter/2;
			//double angle = Math.toRadians(getLineAngle(ix1, iy1, ix2, iy2));
			//double length = Math.pow(Math.pow(ix2 - ix1, 2) + Math.pow(iy2 - iy1, 2), .5);
			//double segments = Math.pow(2, 2);
			//double segmentAngle = angle/segments;
			//double segmentLength = length/segments;
			
			double XDifference = ix2 - ix1;
			double YDifference = iy2 - iy1;
			
			double ox = ix1;
			double oy = iy2;
			
			System.out.println(XDifference);
			System.out.println(YDifference);
			
			g.fillOval(ox - radius, oy - radius, diameter, diameter);
			
			for(int i = 270; i < 315 ; i += 1) {
				double XDisplacement = XDifference*Math.cos(Math.toRadians(i));
				double YDisplacement = YDifference*Math.sin(Math.toRadians(i));
				g.fillOval(ox + XDisplacement - radius, oy	 + YDisplacement - radius, diameter, diameter);
			}
			
			//drawFillLine(ix1, iy1, segmentLength*Math.cos(angle) + ix1, segmentLength*Math.sin(angle) + iy1, g);
			//g.fillOval(segmentLength*Math.cos(angle) + ix1 - radius, segmentLength*Math.sin(angle) + iy1 - radius, diameter, diameter);
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
