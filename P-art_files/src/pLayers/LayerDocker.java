/*
 * Peter Gauld
 * Layer Docker - A docker for the user to select and set drawing layers.
 * 
 * 3/2/2022 - File Created
 */

package pLayers;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import pGeneral.GeneralDocker;
import screens.DrawingScreen;

public class LayerDocker extends GeneralDocker{

	public LayerDocker(DrawingScreen parentScene) {
		super(parentScene);
		surrogateStage.setTitle("Layer Docker");
	}

	//Docker Methods
		public void setMainPane() {
			Text text = new Text("This Docker will be implemented in a future release.");
			StackPane textHolder = new StackPane(text);
			
			//Adding
				mainPane.getChildren().add(textHolder);
			
			//Appearance
				mainPane.setPrefSize(400, 300);
		}
}
