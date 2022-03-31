package fxObjects;

import javafx.scene.layout.Pane;

/*
 * Peter Gauld
 * Timeline Docker - A docker for the user to select and edit frames on a timeline.
 * 
 * 3/2/2022 - File Created
 */

import screens.DrawingScreen;

public class TimelineDocker extends Docker{

	public TimelineDocker(DrawingScreen parentScene) {
		super(parentScene);
	}

	public Pane getMainPane() {
		Pane mainPane = new Pane();
		mainPane.setPrefSize(100, 100);
		
		return mainPane;
	}
}
