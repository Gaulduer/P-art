package pTools;

/*
 * Peter Gauld
 * Eraser Tool - Clears a portion of the canvas.
 * 
 * 4/6/2022 - Log started.
 * 4/20/2022 - Added basic functionality. Eraser is a bit choppy. This could be fixed similarly to how brush is fixed.
 */

import javafx.scene.input.MouseEvent;

public class ToolEraser extends Tool{

	public ToolEraser() {
		toolName = "Eraser";
	}
	
	public void startTool(MouseEvent e) {
		int offset = (int)g.getLineWidth();
		
		g.clearRect(e.getX() - offset/2, e.getY() - offset/2, offset, offset);
	}

	public void continueTool(MouseEvent e) {
		int offset = (int)g.getLineWidth();
		
		g.clearRect(e.getX() - offset/2, e.getY() - offset/2, offset, offset);
	}

	public void cancelTool() {
	
	}
}
