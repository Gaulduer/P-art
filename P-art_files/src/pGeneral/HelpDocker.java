/*
 * Peter Gauld
 * Help Docker - A docker meant to help the user understand the program better.
 * 
 * 5/4/2022 - File Created. Displays information to the user.
 */

package pGeneral;

import javafx.scene.control.TextArea;
import screens.DrawingScreen;

public class HelpDocker extends GeneralDocker{
	private TextArea text;
	
	public HelpDocker(DrawingScreen parentScene) {
		super(parentScene);
		surrogateStage.setTitle("Help Docker");
	}
	
	public void setMainPane() {
		text = new TextArea();
		text.setEditable(false);
		text.setText("Helpful Text");
		
		//Adding
			mainPane.getChildren().add(text);
		
		//Appearance
			text.setPrefSize(400, 300);
			text.setWrapText(true);
	}
	
	public void display(String output) {
		text.setText(output);
		openStage();
	}
}
