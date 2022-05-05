/*
 * Peter Gauld
 * General Docker - The class all dockers will be based upon.
 * 
 * 3/2/2022 - File Created.
 * 4/12/2022 - Added Primary and Secondary Color Object Attributes.
 * 4/13/2022 - Replaced Primary and Secondary Color Objects with ObjectProperty<Color> Objects.
 */

package pGeneral;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import pProperties.ColorProperty;
import screens.DrawingScreen;

public abstract class GeneralDocker extends Scene {
	//Attribute Variables	
		private boolean open = false;
	
	//Attribute Objects
		protected Stage surrogateStage = new Stage();
		protected DrawingScreen parentScene;
		protected Pane mainPane = new Pane();
		protected GraphicsContext g;
		
		protected ColorProperty primaryColorProperty = new ColorProperty();
		protected ColorProperty secondaryColorProperty = new ColorProperty(); 
	
	//Abstract Methods
		public abstract void setMainPane();
		
	public GeneralDocker(DrawingScreen parentScene) {
		super(new Pane());
		
		//Setting Events
			surrogateStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
				public void handle(WindowEvent e) {
					open = false;
					surrogateStage.close();
				}
			});
		
		this.setRoot(mainPane);
		this.parentScene = parentScene;
		g = parentScene.getCanvas().getGraphicsContext2D();
		setMainPane();
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
	
	public Pane dock() {
		return mainPane;
	}
	
	//Appearance Methods
	public void setPrimaryColor(Color primaryColor) {
		primaryColorProperty.setValue(primaryColor);;
	}
	
	public Color getPrimaryColor() {
		return primaryColorProperty.getValue();
	}
	
	public void setSecondaryColor(Color secondaryColor) {
		secondaryColorProperty.set(secondaryColor);
	}
	
	public Color getSecondaryColor() {
		return secondaryColorProperty.getValue();
	}
	
	//Property Methods
	public ColorProperty primaryColorProperty() {
		return primaryColorProperty;
	}
	
	public ColorProperty secondaryColorProperty(){
		return secondaryColorProperty;
	}
	
	public void close() {
		surrogateStage.close();
	}
}
