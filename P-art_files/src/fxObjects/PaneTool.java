package fxObjects;

import fxAppeareance.Designer;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/*
 * Peter Gauld
 * Tool Pane - A pane for holding all the tool buttons.
 * 
 * 3/9/2022 - File created.
 */

public class PaneTool extends Pane {
	public PaneTool() {
		this.setBackground(Designer.getBackground(0, 0, 0));
		this.getChildren().add(new VBox(new HBox()));
		
		ToolButton cursor = new ToolButton(new ToolCursor());
		ToolButton brush = new ToolButton(new ToolBrush());
		ToolButton eraser = new ToolButton(new ToolEraser());
		ToolButton[] toolButtons = {cursor, brush, eraser};
		
		addToolButtons(toolButtons);
	}
	
	public void addToolButton(ToolButton tool) {
		VBox rows = (VBox)this.getChildren().get(0);
		HBox row = (HBox)rows.getChildren().get(rows.getChildren().size()-1);
		
		if(row.getChildren().size() == 2) {
			row = new HBox();
			row.getChildren().add(tool);
			rows.getChildren().add(row);
		}
		else
			row.getChildren().add(tool);
	}
	
	public void addToolButtons(ToolButton[] tools) {
		for(int i = 0 ; i < tools.length ; i++)
			addToolButton(tools[i]);
	}
}
