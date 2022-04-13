/*
 * Peter Gauld
 * Tool Button - A button that holds a tool to be used on the canvas.
 * 
 * 4/13/2022 - Log started.
 */

package pTools;

import javafx.scene.control.Button;

public class ToolButton extends Button {
	private Tool tool;
	private boolean selected;
	
	public ToolButton(Tool tool){
		setTool(tool);
		setText(tool.getName());
	}
	
	public void setTool(Tool tool) {
		this.tool = tool;
	}
	
	public Tool getTool() {
		return tool;
	}
	
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	public boolean isSelected() {
		return this.selected;
	}
}
