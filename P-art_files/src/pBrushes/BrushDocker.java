/*
 * Peter Gauld
 * Brush Docker - A docker for the user to select and size drawing brushes.
 * 
 * 3/2/2022 - File Created. Docker can now change brush type and size.
 */

package pBrushes;

import fxAppeareance.Designer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import pGeneral.GeneralDocker;
import screens.DrawingScreen;

public class BrushDocker extends GeneralDocker {
	public BrushDocker(DrawingScreen parentScene) {
		super(parentScene);
		surrogateStage.setTitle("Brush Docker");
	}

	//Docker Methods
		public void setMainPane() {
			//Control Objects
				ComboBox<String> brushCB = new ComboBox<>();
				TextField brushSize = new TextField();
				Button brushSizeButton = new Button("Set Size");
				
			//Adding to
				//Main Pane
					mainPane.getChildren().add(new HBox(brushCB, brushSize, brushSizeButton));
					
					//Brush Combo Box
						brushCB.getItems().add("");
						brushCB.getItems().add("Stroke");
						brushCB.getItems().add("Marker");
						brushCB.getItems().add("Spray");
				
			//Setting
				//Appearance
					//Main Pane
						mainPane.setBackground(Designer.getBackground(150, 150, 150));
						
				//Events
					//Brush Combo Box
						brushCB.setOnAction(new EventHandler<ActionEvent>() {
							public void handle(ActionEvent e) {
								String check = brushCB.getSelectionModel().getSelectedItem();
								
								if(check.equals("Stroke"))
									parentScene.getTools().setBrush((Brush)new BrushStroke());
								else if(check.equals("Marker"))
									parentScene.getTools().setBrush((Brush)new BrushMarker());
								else if(check.equals("Spray"))
									parentScene.getTools().setBrush((Brush)new BrushSpray());
							}					
						});
						
					//Brush Size
						brushSize.setOnAction(new EventHandler<ActionEvent>() {
							public void handle(ActionEvent e) {
								//Change the text field color here.
							}
						});
						
					//Brush Size Button
						brushSizeButton.setOnAction(new EventHandler<ActionEvent>() {
							public void handle(ActionEvent e) {
								String check = brushSize.getText();
								
								try {
									double size = Double.parseDouble(check);
									parentScene.getCanvas().getGraphicsContext2D().setLineWidth(size);
								}
								catch(Exception b) {
									brushSize.setText("");
								}
							}					
						});
		}
}
