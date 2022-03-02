package fxObjects;

/*
 * Peter Gauld
 * Canvas Object - A canvas object that can be drawn on.
 * 
 * 2/25/2022 - File Created.
 */
																																																																																																																																																																																																																																																																																																																																																																																			
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class PCanvas extends Canvas {
	//Attributes
		private Boolean mousePresent = false;
		private Boolean mousePressed = false;
		private ToolBrush brush = new ToolBrush(new BrushStroke(), this.getGraphicsContext2D());
		private Pane parentPane = new Pane();
		
	public PCanvas() {					
		//Appearance
			//Canvas
				
		//Events
			//Canvas Pane
				//Tracking Events
					this.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
						public void handle(MouseEvent e) {
							mousePresent = true;
						}
					});
							
					this.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
						public void handle(MouseEvent e) {
							mousePresent = false;
						}
					});
					
					this.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
						public void handle(MouseEvent e) {
							mousePressed = true;
						}
					});
					
					this.addEventHandler(MouseEvent.MOUSE_RELEASED, new EventHandler<MouseEvent>() {
						public void handle(MouseEvent e) {
							mousePressed = false;
						}
					});
					
				//Tool Events
					this.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
						public void handle(MouseEvent e) {
							brush.startStroke(e);
						}
					});			
					
					this.addEventHandler(MouseEvent.MOUSE_DRAGGED, new EventHandler<MouseEvent>() {
						public void handle(MouseEvent e) {
							brush.continueStroke(e);
						}
					});		
	}
	
	public Boolean isMousePresent() {
		return mousePresent;
	}
	
	public Boolean isMousePressed() {
		return mousePressed;
	}
	
	public void setToolBrush(ToolBrush brush) {
		this.brush = brush;
	}
	
	public ToolBrush getToolBrush() {
		return brush;
	}
	
	//Graphics Methods
		public void setStrokeWidth(double strokeWidth) {
			this.getGraphicsContext2D().setLineWidth(strokeWidth);
		}
		
		public double getStrokeWidth() {
			return this.getGraphicsContext2D().getLineWidth();
		}
		
		public void setStrokeColor(Color strokeColor) {
			this.getGraphicsContext2D().setStroke(strokeColor);
			this.getGraphicsContext2D().setFill(strokeColor);
		}
		
		public void clear() {
			this.getGraphicsContext2D().clearRect(0, 0, this.getWidth(), this.getHeight());
		}
	
	public void setParentPane(Pane parentPane) {
		this.parentPane = parentPane;
		this.widthProperty().bind(parentPane.widthProperty());
		this.heightProperty().bind(parentPane.heightProperty());
	}
	
	public Pane getParentPane() {
		return parentPane;
	}
}
