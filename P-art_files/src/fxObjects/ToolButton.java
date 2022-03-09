package fxObjects;

import javafx.scene.control.Button	;

public class ToolButton extends Button{
	private Tool tool;
	
	public ToolButton(Tool tool){
		setTool(tool);
		this.setText(tool.getName());
	}
	
	public void setTool(Tool tool) {
		this.tool = tool;
	}
	
	public Tool getTool() {
		return tool;
	}
}
