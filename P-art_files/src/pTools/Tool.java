package pTools;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;

/*
 * Peter Gauld
 * Tool - The tool class that all tools will extend.
 * 
 * 3/9/2022 - File created.
 */

public abstract class Tool {
	protected String toolName = "Unnamed";
	protected GraphicsContext g;
	
	public abstract void startTool(MouseEvent e); //Starts the use of the tool.
	public abstract void continueTool(MouseEvent e); //Continues the use of the tool.
	public abstract void cancelTool(); //Cancels the use of the tool.
	
	//Graphics Methods	
		public void setGraphicsContext(GraphicsContext g) {
			this.g = g;
		}
		
		public GraphicsContext getGraphicsContext() {
			return g;
		}
	
	public String getName() {
		return toolName;
	}
}
