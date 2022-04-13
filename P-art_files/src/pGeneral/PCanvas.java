/*
 * Peter Gauld
 * Canvas Object - A canvas object that can be drawn on.
 * 
 * 2/25/2022 - File Created.
 */


package pGeneral;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import pTools.Tool;

public class PCanvas extends Canvas {
	//Attributes
		private Boolean mousePresent = false;
		private Boolean mousePressed = false;
		private Pane parentPane = new Pane();
		private Tool tool;
		
	public PCanvas() {	
		//Attributes
			
		
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
							tool.startTool(e);
						}
					});			
					
					this.addEventHandler(MouseEvent.MOUSE_DRAGGED, new EventHandler<MouseEvent>() {
						public void handle(MouseEvent e) {
							tool.continueTool(e);
						}
					});		
	}
	
	public Boolean isMousePresent() {
		return mousePresent;
	}
	
	public Boolean isMousePressed() {
		return mousePressed;
	}
	
	public void setTool(Tool tool) {
		this.tool = tool;
	}
	
	public Tool getTool() {
		return tool;
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
		/*
		this.parentPane = parentPane;
		parentPane.visibleProperty().addListener(new ChangeListener<Boolean>() {
			public void changed(ObservableValue<? extends Boolean> v, Boolean o, Boolean n) {
				System.out.println(o);
				System.out.println(n);
			}		
		});
		
		parentPane.setVisible(false);
		*/
		this.parentPane = parentPane;
		this.widthProperty().bind(parentPane.widthProperty());
		this.heightProperty().bind(parentPane.heightProperty());
		parentPane.widthProperty().addListener(new ChangeListener<Number>() {
			public void changed(ObservableValue<? extends Number> v, Number o, Number n) {	

			}
		});
	}
	
	public Pane getParentPane() {
		return parentPane;
	}
}
