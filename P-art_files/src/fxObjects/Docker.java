package fxObjects;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import screens.DrawingScreen;

/*
 * Peter Gauld
 * Docker - The class all dockers will be based upon.
 * 
 * 3/2/2022 - File Created.
 */

public abstract class Docker extends Scene {
	//Attribute Variables
		private boolean open = false;
	
	//Attribute Objects
		protected Stage surrogateStage = new Stage();
		protected DrawingScreen parentScene;
	
	public Docker(DrawingScreen parentScene) {
		super(new Pane());
		
		surrogateStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			public void handle(WindowEvent e) {
				open = false;
				surrogateStage.close();
			}
		});
		
		this.setRoot(getMainPane());
		this.parentScene = parentScene;
	}
	
	public void openStage() {
		if(open == true)
			return;
		
		open = true;
		surrogateStage.setScene(this);
		surrogateStage.centerOnScreen();
		surrogateStage.show();
	}
	
	public DrawingScreen getParentScene() {
		return parentScene;
	}
	
	public abstract Pane getMainPane();
}
