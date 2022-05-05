/*
 * Peter Gauld
 * Polygon Tool - A tool for P-art meant to create polygon shapes.
 * 
 * 5/4/2022 - Log Started. Now prints a message to let the user know this doesn't work yet.
 */

package pTools;

import javafx.scene.input.MouseEvent;

public class ToolPolygon extends Tool{
	public ToolPolygon() {
		toolName = "Polygon";
	}
	
	public void startTool(MouseEvent e) {
		g.fillText("This tool will work in a future release", e.getX(), e.getY());
	}
	
	public void continueTool(MouseEvent e) {

	}

	public void cancelTool() {
		
	}

}
