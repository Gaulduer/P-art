package pTools;

import javafx.scene.input.MouseEvent;

/*
 * Peter Gauld
 * 4/6/2022 - Started log. 
 * 4/20/2022 - Added basic functionality.
 */

public class ToolBucket extends Tool{
	public ToolBucket() {
		toolName = "Bucket";
	}

	public void startTool(MouseEvent e) {
		int canvasWidth = (int)g.getCanvas().getWidth();
		int canvasHeight = (int)g.getCanvas().getHeight();
		
		g.fillRect(0, 0, canvasWidth, canvasHeight);
	}

	@Override
	public void continueTool(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancelTool() {
		// TODO Auto-generated method stub
		
	}
}
