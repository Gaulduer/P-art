package fxObjects;

import java.awt.event.ComponentEvent;

import fxAppeareance.Designer;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Canvas extends Pane{
	//Attributes
		private Boolean mousePresent = false;
		private Boolean mousePressed = false;
		private Pane parentPane = new Pane();
		
	public Canvas() {		
		//Control Variables
			Color canvasPaneColor = Color.rgb(255, 255, 255);	
			
		//Appearance
			//Canvas Pane
				this.setBackground(Designer.getBackground(canvasPaneColor));
				this.prefWidthProperty().bind(parentPane.widthProperty().multiply(3).divide(4));
				this.prefHeightProperty().bind(parentPane.heightProperty());
				
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
				//Component Events

					
	}
	
	public Boolean isMousePresent() {
		return mousePresent;
	}
	
	public Boolean isMousePressed() {
		return mousePressed;
	}
}
