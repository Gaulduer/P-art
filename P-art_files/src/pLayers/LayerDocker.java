/*
 * Peter Gauld
 * Layer Docker - A docker for the user to select and set drawing layers.
 * 
 * 3/2/2022 - File Created
 */

package pLayers;

import javafx.scene.layout.Pane;
import pGeneral.GeneralDocker;
import screens.DrawingScreen;

public class LayerDocker extends GeneralDocker{

	public LayerDocker(DrawingScreen parentScene) {
		super(parentScene);
	}

	//Docker Methods
		public void setMainPane() {
			Pane mainPane = new Pane();
			mainPane.setPrefSize(100, 100);
		}
}
