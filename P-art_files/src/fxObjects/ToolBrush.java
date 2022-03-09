package fxObjects;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;

public class ToolBrush extends Tool{
	//Attributes
		private int strokeWidth;
		private Brush brush = new BrushStroke();
		private GraphicsContext g;
	
	//Constructors
		public ToolBrush() {
			
		}
		
		public ToolBrush(Brush brush) {
			setBrush(brush);
		}
		
		public ToolBrush(GraphicsContext g) {
			setGraphics(g);
		}
			
		public ToolBrush(Brush brush, GraphicsContext g) {
			setBrush(brush);
			setGraphics(g);
		}
	
	//Graphics Methods	
		public void setGraphics(GraphicsContext g) {
			this.g = g;
		}
		
		public GraphicsContext getGraphics() {
			return g;
		}
	
	//Brush Methods
		public void setBrush(Brush brush) {
			this.brush = brush;
		}
		
		public Brush getBrush() {
			return brush;
		}
		
		public void startStroke(MouseEvent e) {
			this.getBrush().startStroke(e, g);
		}
		
		public void continueStroke(MouseEvent e) {
			this.getBrush().continueStroke(e, g);
		}
		
		public void setStrokeWidth(int strokeWidth) {
			this.strokeWidth = strokeWidth;
		}
		
		public int getStrokeWidth() {
			return strokeWidth;
		}
}
