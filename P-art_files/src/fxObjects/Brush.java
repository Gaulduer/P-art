package fxObjects;

/*
 * Peter Gauld
 * Brush - This is meant to be an abstract class that all brushes are based upon.
 * 
 * Notes:
 * Consider changing the class methods to return a event handler, rather than performing methods triggered by an event handler.
 * 
 * 2/26/2022 - File Created
 */

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;

public abstract class Brush {
	public abstract void startStroke(MouseEvent e, GraphicsContext g);
	public abstract void continueStroke(MouseEvent e, GraphicsContext g);
}
