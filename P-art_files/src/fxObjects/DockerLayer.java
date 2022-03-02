package fxObjects;

import javafx.scene.layout.Pane;

/*
 * Peter Gauld
 * Layer Docker - A docker for the user to select and set drawing layers.
 * 
 * 3/2/2022 - File Created
 */

import screens.DrawingScreen;

public class DockerLayer extends Docker{

	public DockerLayer(DrawingScreen parentScene) {
		super(parentScene);
	}

	public Pane getMainPane() {
		Pane mainPane = new Pane();
		mainPane.setPrefSize(100, 100);
		
		return mainPane;
	}
}
