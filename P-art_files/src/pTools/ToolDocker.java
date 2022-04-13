/*
 * Peter Gauld
 * Tool Pane - A pane for holding all the tool buttons.
 * 
 * 3/9/2022 - File created.
 * 4/6/2022 - Tool pane changed to tool docker.
 * 4/13/2022 - Tool buttons are now bound to the tool pane's primary and secondary colors. Number Properties added to properly size buttons.
 */

package pTools;

import fxAppeareance.Designer;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import pBrushes.Brush;
import pGeneral.GeneralDocker;
import pProperties.ColorProperty;
import pProperties.NumberProperty;
import screens.DrawingScreen;

public class ToolDocker extends GeneralDocker {
	private ToolButton selected; //TODO Make it so the selected tool is based on the currently selected item.
	private ToolBrush brushTool; //A brush tool tied to a tool button;
	
	public ToolDocker(DrawingScreen parentScene) {
		super(parentScene);
	}
	
	//Docker Methods
		public void setMainPane() {
			mainPane.setBackground(Designer.getBackground(0, 0, 0));
			mainPane.getChildren().add(new VBox(new HBox()));
			
			ToolButton cursor = new ToolButton(new ToolCursor());
			ToolButton brush = new ToolButton(new ToolBrush());
			ToolButton eraser = new ToolButton(new ToolEraser());
			ToolButton bucket = new ToolButton(new ToolBucket());
			ToolButton curve = new ToolButton(new ToolCurve());
			ToolButton polygon = new ToolButton(new ToolPolygon());
			ToolButton[] toolButtons = {cursor, brush, eraser, bucket, curve, polygon};
		
			addToolButtons(toolButtons);	
			selected = brush;
		}
	
	public void addToolButton(ToolButton tool) {
		//Control Variables
			int sizeLimit = 2;
			
		//Recurring Objects
			VBox rows = (VBox)mainPane.getChildren().get(0);
			HBox row = (HBox)rows.getChildren().get(rows.getChildren().size()-1);
		
		if(row.getChildren().size() == sizeLimit) {
			row = new HBox();
			row.getChildren().add(tool);
			rows.getChildren().add(row);
		}
		else
			row.getChildren().add(tool);
	
		//Setting Events
			//For Attributes
				//Changes
					primaryColorProperty.addListener(new ChangeListener<Color>() {
						public void changed(ObservableValue<? extends Color> v, Color o, Color n) {
							syncAppearance(tool);
						}				
					});
							
					secondaryColorProperty.addListener(new ChangeListener<Color>() {
						public void changed(ObservableValue<? extends Color> v, Color o, Color n) {
							syncAppearance(tool);
						}
					});
					
					mainPane.widthProperty().addListener(new ChangeListener<Number>() {
						public void changed(ObservableValue<? extends Number> v, Number o, Number n) {
							syncAppearance(tool);
						}
					});
					
					mainPane.heightProperty().addListener(new ChangeListener<Number>() {
						public void changed(ObservableValue<? extends Number> v, Number o, Number n) {
							syncAppearance(tool);
						}
					});
			
			//For Tool
				//Binds
					tool.textFillProperty().bind(secondaryColorProperty());
					
				//Changes
					tool.widthProperty().addListener(new ChangeListener<Number>() {
						public void changed(ObservableValue<? extends Number> v, Number o, Number n) {
							syncAppearance(tool);
						}
					});
					
					tool.heightProperty().addListener(new ChangeListener<Number>() {
						public void changed(ObservableValue<? extends Number> v, Number o, Number n) {
							syncAppearance(tool);
						}
					});
				
				//Actions
					tool.setOnAction(new EventHandler<ActionEvent>() {
						public void handle(ActionEvent e) {
							selected.setSelected(false);
							syncAppearance(selected);
							
							if(tool.isSelected()) {
								selected = new ToolButton(new ToolNull());
								tool.setSelected(false);
								syncAppearance(tool);
							}
							else {
								selected = tool;
								tool.setSelected(true);
								syncAppearance(tool);
							}
						}
					});
		
		if(tool.getTool().getName().equals("Brush"))
			brushTool = (ToolBrush)tool.getTool();	
		
		tool.getTool().setGraphicsContext(g);
	}
	//Sub methods
		public void syncAppearance(ToolButton tool) {
			ColorProperty primary;
			ColorProperty secondary;
			
			if(tool.isSelected()) {
				primary = secondaryColorProperty();
				secondary = primaryColorProperty();
			}
			else {
				primary = primaryColorProperty();
				secondary = secondaryColorProperty();
			}
			
			tool.prefWidthProperty().set(mainPane.widthProperty().divide(tool.getParent().getChildrenUnmodifiable().size()).getValue().doubleValue());
			tool.prefHeightProperty().set(mainPane.heightProperty().divide(tool.getParent().getParent().getChildrenUnmodifiable().size()).getValue().doubleValue());
			
			tool.textFillProperty().unbind();
			tool.textFillProperty().bind(secondary);
			tool.backgroundProperty().set(Designer.getBackground(primary.getValue()));
			tool.borderProperty().set(Designer.getBorder(tool.widthProperty().divide(10).intValue(), tool.heightProperty().divide(10).intValue(), secondary.getValue()));
		}
	
	public void addToolButtons(ToolButton[] tools) {
		for(int i = 0 ; i < tools.length ; i++)
			addToolButton(tools[i]);
	}
	
	public Tool getSelectedTool() {
		return selected.getTool(); //TODO Make it so the selected tool is based on the currently selected item.
	}
	
	public void setBrush(Brush brush) {
		if(brushTool == null)
			return;
		
		brushTool.setBrush(brush);
	}
}
