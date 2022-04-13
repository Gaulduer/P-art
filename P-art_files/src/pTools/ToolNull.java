package pTools;

import javafx.scene.input.MouseEvent;

public class ToolNull extends Tool{
	public ToolNull() {
		toolName = "Null";
	}
	
	public void startTool(MouseEvent e) {
		//Do Nothing.		
	}

	public void continueTool(MouseEvent e) {
		//Do Nothing.
	}

	public void cancelTool() {
		//Cancel Nothing.		
	}

}
