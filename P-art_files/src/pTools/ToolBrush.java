
/*
 * Peter Gauld
 * Name
 * 
 * 4/6/2022 - Started log.
 */

package pTools;

import javafx.scene.input.MouseEvent;
import pBrushes.Brush;
import pBrushes.BrushStroke;

public class ToolBrush extends Tool{
	//Attributes
		private int strokeWidth;
		private Brush brush = new BrushStroke();
		
	//Constructors
		public ToolBrush() {
			toolName = "Brush";
		}
	
	//Brush Methods
		public void setBrush(Brush brush) {
			this.brush = brush;
		}
		
		public Brush getBrush() {
			return brush;
		}
		
		public void continueStroke(MouseEvent e) {
			this.getBrush().continueStroke(e, g);
		}
		
		public void setStrokeWidth(int strokeWidth) {
			this.strokeWidth = strokeWidth;
		}
		
		public int getStrokeWidth() {
			return strokeWidth;
		}

		//Tool Methods
			public void startTool(MouseEvent e) {
				this.getBrush().startStroke(e, g);
			}
	
			public void continueTool(MouseEvent e) {
				this.getBrush().continueStroke(e, g);
			}
	
			public void cancelTool() {

			}
	}
