/*
 * Peter Gauld
 * Line Tool - A tool that creates a line.
 * 
 * 5/4/2022 - File created/recreated. The code for this was done pretty much before brush was created, but I didn't save it because I wasn't working on a line at the time, but the brush! I am kind of sad I didn't save that line code since I managed to get rounded circles at the end of the line.
 */

package pTools;

import javafx.scene.input.MouseEvent;

public class ToolLine extends Tool {
	private double oldX = -1;
	private double oldY = -1;
	
	public ToolLine() {
		toolName = "Line";
	}
	
	public void startTool(MouseEvent e) {
		if(oldX >= 0 && oldY >= 0) {
			g.strokeLine(oldX, oldY, e.getX(), e.getY());
			oldX = -1;
			oldY = -1;
		}
		else {
			oldX = e.getX();
			oldY = e.getY();
		}
	}

	public void continueTool(MouseEvent e) {
		
	}

	public void cancelTool() {
	
	}
}
