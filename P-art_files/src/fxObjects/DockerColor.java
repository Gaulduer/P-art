package fxObjects;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import screens.DrawingScreen;

/*
 * Peter Gauld
 * Color Docker - A docker for the user to select and set tool colors. Docker can now change brush color.
 * 
 * 3/2/2022 - File Created
 */

public class DockerColor extends Docker {
	public DockerColor(DrawingScreen parentScene) {
		super(parentScene);
		surrogateStage.setTitle("Color Docker");
	}
	
	public Pane getMainPane() {
		//Display Objects
			Pane mainPane = new Pane();
		
		//Control Objects
			TextField rEntry = new TextField();
			TextField gEntry = new TextField();
			TextField bEntry = new TextField();
			Button confirmColor = new Button("Confirm Color");
		
		//Adding to
			//Main Pane
				mainPane.getChildren().add(new HBox(rEntry, gEntry, bEntry, confirmColor));
				
		//Setting
			//Appearance
				//Main Pane
					mainPane.setPrefSize(600, 300);		
			
			//Events
				//Confirm Color
					confirmColor.setOnAction(new EventHandler<ActionEvent>() {
						public void handle(ActionEvent e) {							
							int r = -1;
							int g = -1;
							int b = -1;
							
							try {
								r = Integer.parseInt(rEntry.getText());
							}
							catch(Exception d) {
								//Do nothing.
							}
							
							try {
								g = Integer.parseInt(gEntry.getText());
							}
							catch(Exception d) {
								//Do nothing.
							}
							
							try {
								b = Integer.parseInt(bEntry.getText());
							}
							catch(Exception d) {
								//Do nothing.
							}
							
							if(r >= 0 && g >= 0 && b >= 0) {
								parentScene.getCanvas().setStrokeColor(Color.rgb(r, g, b));
							}
							else {
								if(r < 0)
									rEntry.setText("");
								if(g < 0)
									gEntry.setText("");
								if(b < 0)
									bEntry.setText("");
							}
						}
					});
				
		return mainPane;
	}
}
