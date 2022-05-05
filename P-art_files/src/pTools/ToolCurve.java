/*
 * Peter Gauld
 * Curve Tool - A tool for P-art meant to create curved lines.
 * 
 * 5/4/2022 - Log Started. Now prints a message to let the user know this doesn't work yet.
 */
 
package pTools;

import javafx.scene.input.MouseEvent;

public class ToolCurve extends Tool{
	public ToolCurve() {
		toolName = "Curve";
	}

	public void startTool(MouseEvent e) {
		g.fillText("This tool will work in a future release", e.getX(), e.getY());
	}

	public void continueTool(MouseEvent e) {

	}

	public void cancelTool() {
		
	}
}
