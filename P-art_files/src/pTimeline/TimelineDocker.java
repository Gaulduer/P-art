/*
 * Peter Gauld
 * Timeline Docker - A docker for the user to select and edit frames on a timeline.
 * 
 * 3/2/2022 - File Created
 */


package pTimeline;

import pGeneral.GeneralDocker;
import screens.DrawingScreen;

public class TimelineDocker extends GeneralDocker{

	public TimelineDocker(DrawingScreen parentScene) {
		super(parentScene);
	}

	public void setMainPane() {
		mainPane.setPrefSize(100, 100);
	}
}
