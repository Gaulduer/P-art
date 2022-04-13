package screens;

/*
 * Peter Gauld
 * Development Stage - A Development Stage for showing certain variables. Meant to help during development.
 * 
 * 2/23/2022 - File Created.
 * 2/24/2022 - Development Stage successfully transfered from PArt. Converted from method to class.
 */


import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class DevelopmentStage extends Stage{
	private Stage parentStage;
	private Boolean open = false;
	private TextArea tracker = new TextArea();
	
	public DevelopmentStage(Stage parentStage) {
		this.parentStage = parentStage;
	}
	
	//Open and Close Methods
		public void open() {
			//Limit Variables
			Boolean[] triggered = {false}; 
		
		//Instantiating Components 
			Stage devStage = new Stage();
			//Scene mainScene = new Scene(new Pane(tracker));
			Pane testingPane = new Pane();
			Scene mainScene = new Scene(new VBox(tracker, testingPane));
			
		//Instantiating Events
			EventHandler<KeyEvent> parentClosesDev = new EventHandler<KeyEvent>() {
				public void handle(KeyEvent e) {
					if(e.getCode() == KeyCode.BACK_QUOTE && triggered[0] == true)
						devStage.fireEvent(new WindowEvent(devStage, WindowEvent.WINDOW_CLOSE_REQUEST));
					else
						triggered[0] = true;
				}
			};
			
		//Setting
			//Appearance
				//Development Stage
					devStage.setTitle("Development Window");
			
	 			//Tracker
					tracker.setPrefSize(300, 50);
	 				tracker.setEditable(false);
	 				
			//Events
				//Development Stage
	 				devStage.setOnShown(new EventHandler<WindowEvent>() {
						public void handle(WindowEvent e) {
							parentStage.addEventHandler(KeyEvent.KEY_PRESSED, parentClosesDev);
							open = true;
						}
					});
	 				
	 				devStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
						public void handle(WindowEvent e) {
							open = false;
							parentStage.removeEventHandler(KeyEvent.KEY_PRESSED, parentClosesDev);
							devStage.close();
						}
					});
	 		
			//Presenting
				devStage.setScene(mainScene);
				devStage.show();
		};
		
		public void close() {
			
		}
		
		public Boolean isOpen() {
			return open;
		}
		
	//Monitor Methods
		public void setTracker(String text) {
			tracker.setText(text);
		}
}
