/*
 * Peter Gauld
 * Timeline Docker - A docker for the user to select and edit frames on a timeline.
 * 
 * 3/2/2022 - File Created
 */

package pTimeline;

import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import pGeneral.GeneralDocker;
import screens.DrawingScreen;

public class TimelineDocker extends GeneralDocker{

	public TimelineDocker(DrawingScreen parentScene) {
		super(parentScene);
		surrogateStage.setTitle("Timeline Docker");
	}

	public void setMainPane() {
		Text text = new Text("This Docker will be implemented in a future release.");
		StackPane textHolder = new StackPane(text);
		
		//Adding
			mainPane.getChildren().add(textHolder);
		
		//Appearance
			mainPane.setPrefSize(400, 300);
	}
}
