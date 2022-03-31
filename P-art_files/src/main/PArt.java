package main;


/*
 * Peter Gauld
 * P-art - An art program by Peter Gauld!
 * 
 * 2/13/2022 - File Created. 
 * 2/14/2022 - UI window added. Menu Bar, Menus, and Menu Items added. Tool and Canvas Panes added.
 * 2/15/2022 - Development Window Added. Mouse click and entry/exit listeners added.
 */

import fxFiles.FxResourceHandler;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import screens.DevelopmentStage;
import screens.DrawingScreen;

public class PArt extends Application {
	public static void main(String[] args) {
		launch();
	}
	
	//Main Stage
		public void start(Stage mainStage) throws Exception {
			//Control Variables
				String mainStageTitle = "P-art";
				String mainStageIconImage = "peterHead.PNG";
				
			//Function Objects
				DrawingScreen draw = new DrawingScreen();
				
			//Monitor Objects
				DevelopmentStage devStage = new DevelopmentStage(mainStage);
				
			//Adding
				mainStage.setScene(draw);
				
			//Setting Events
				//Main Stage
					mainStage.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
						public void handle(KeyEvent e) {
							if(e.getCode() == KeyCode.BACK_QUOTE)
								if(devStage.isOpen() == false)
									devStage.open();
							if(e.getCode() == KeyCode.C)
								draw.clearCanvas();
						}
					});
					
					mainStage.addEventHandler(Event.ANY, new EventHandler<Event>() {
						public void handle(Event e) {
							if(devStage.isOpen() == true) {
								devStage.setTracker("Mouse Present: " + draw.getCanvas().isMousePresent() + "\nMouse Pressed: " + draw.getCanvas().isMousePressed() + "\nTool Selected: " + draw.getToolName());
							}
						}
					});
					
					mainStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
						public void handle(WindowEvent e) {
							System.exit(0);
						}
					});
			
			//Presenting
				mainStage.setTitle(mainStageTitle);
				FxResourceHandler.addStageIcon(mainStage, mainStageIconImage);
				mainStage.centerOnScreen();
				mainStage.show();
		}	
	
	//Utility Methods

}
