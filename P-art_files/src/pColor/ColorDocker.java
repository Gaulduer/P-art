/*
 * Peter Gauld
 * Color Docker - A docker for the user to select and set tool colors. Docker can now change brush color.
 * 
 * 3/2/2022 - File Created
 * 5/4/2022 - Important improvements made to color entry.
 */

package pColor;

import fxAppeareance.Designer;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import pGeneral.GeneralDocker;
import screens.DrawingScreen;

public class ColorDocker extends GeneralDocker {
	public ColorDocker(DrawingScreen parentScene) {
		super(parentScene);
		surrogateStage.setTitle("Color Docker");
	}
	
	//Docker Methods
		public void setMainPane() {
			//Control Objects
				TextField rEntry = new TextField("0");
				TextField gEntry = new TextField("0");
				TextField bEntry = new TextField("0");
				ColorSlider rSlider = new ColorSlider();
				ColorSlider gSlider = new ColorSlider();
				ColorSlider bSlider = new ColorSlider();
	
			//Adding to
				//Main Pane
					mainPane.getChildren().add(new VBox(new HBox(rSlider, rEntry), new HBox(gSlider, gEntry), new HBox(bSlider, bEntry)));
					
			//Setting
				//Appearance
					//Main Pane
						mainPane.setBackground(Designer.getBackground(0, 0, 0));
				
				//Events
					//Color Sliders
						EventHandler<MouseEvent> sliderEvent = new EventHandler<MouseEvent>() {
							public void handle(MouseEvent e) {
								rEntry.setText(rSlider.getValue() + "");
								gEntry.setText(gSlider.getValue() + "");
								bEntry.setText(bSlider.getValue() + "");
								setColor(rSlider, gSlider, bSlider);
								mainPane.setBackground(Designer.getBackground(rSlider.getInt(), gSlider.getInt(), bSlider.getInt()));
							}
						};
						
						rSlider.addEventHandler(MouseEvent.MOUSE_DRAGGED, sliderEvent);
						gSlider.addEventHandler(MouseEvent.MOUSE_DRAGGED, sliderEvent);
						bSlider.addEventHandler(MouseEvent.MOUSE_DRAGGED, sliderEvent);
						
					//Color Fields
						EventHandler<KeyEvent> fieldEnterEvent = new EventHandler<KeyEvent>() {
							public void handle(KeyEvent e) {
								if(e.getCode() == KeyCode.ENTER)
									setColor(rEntry, gEntry, bEntry);
								
								try {
									rSlider.setValue(Double.parseDouble(rEntry.getText()));
								}
								catch(Exception ex) {
									//Do nothing.
								}
								
								try {
									gSlider.setValue(Double.parseDouble(gEntry.getText()));
								}
								catch(Exception ex) {
									//Do nothing.
								}
								
								try {
									bSlider.setValue(Double.parseDouble(bEntry.getText()));
								}
								catch(Exception ex) {
									//Do nothing.
								}
							}
						};
						
						
						
						rEntry.addEventHandler(KeyEvent.KEY_PRESSED , fieldEnterEvent);
						gEntry.addEventHandler(KeyEvent.KEY_PRESSED , fieldEnterEvent);
						bEntry.addEventHandler(KeyEvent.KEY_PRESSED , fieldEnterEvent);
		}
	
	private void setColor(TextField rEntry, TextField gEntry, TextField bEntry) {
		int r = 0;
		int g = 0;
		int b = 0;
			
		try {
			r = Integer.parseInt(rEntry.getText());
		}
		catch(Exception d) {
			//Do nothing.
		}
		
		try {
			g = Integer.parseInt(gEntry.getText());
		}
		catch(Exception d) {
			//Do nothing.
		}
		
		try {
			b = Integer.parseInt(bEntry.getText());
		}
		catch(Exception d) {
			//Do nothing.
		}
		
		submitColor(r, g, b);
	}
	
	private void setColor(ColorSlider rSlider, ColorSlider gSlider, ColorSlider bSlider) {
		int r = rSlider.getInt();
		int g = gSlider.getInt();
		int b = bSlider.getInt();
			
		submitColor(r, g, b);
	}
	
	private void submitColor(int r, int g, int b) {
		if(r > 255)
			r = 255;
		else if(r < 0)
			r = 0;
		if(g > 255)
			g = 255;
		else if(g < 0)
			g = 0;
		if(b > 255 || b < 0)
			b = 255;
		else if(b < 0)
			b = 0;
		
		mainPane.setBackground(Designer.getBackground(r, g, b));
		parentScene.getCanvas().setStrokeColor(Color.rgb(r, g, b));
	}
}
