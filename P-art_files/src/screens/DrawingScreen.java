package screens;

import javafx.scene.canvas.Canvas;

/*
 * Peter Gauld
 * Drawing Screen - This is meant to act as the main screen in P-art. Here the user can interact with the menu bar, tools, and the canvas.
 * 
 * 2/25/2022 - File Created.
 */

public class DrawingScreen {
	private Canvas canvas = new Canvas();
	
	public Canvas getCanvas() {
		return canvas;
	}
}
