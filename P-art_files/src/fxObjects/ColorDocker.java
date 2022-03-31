package fxObjects;

import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import screens.DrawingScreen;

/*
 * Peter Gauld
 * Color Docker - A docker for the user to select and set tool colors. Docker can now change brush color.
 * 
 * 3/2/2022 - File Created
 */

public class ColorDocker extends Docker {
	public ColorDocker(DrawingScreen parentScene) {
		super(parentScene);
		surrogateStage.setTitle("Color Docker");
	}
	
	public Pane getMainPane() {
		//Display Objects
			Pane mainPane = new Pane();
		
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
					mainPane.setPrefSize(600, 300);		
			
			//Events
				//Color Sliders
					EventHandler<MouseEvent> sliderEvent = new EventHandler<MouseEvent>() {
						public void handle(MouseEvent e) {
							rEntry.setText(rSlider.getValue() + "");
							gEntry.setText(gSlider.getValue() + "");
							bEntry.setText(bSlider.getValue() + "");
							setColor(rEntry, gEntry, bEntry);
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
					
		return mainPane;
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
		
		if(r > 255)
			r = 255;
		if(g > 255)
			g = 255;
		if(b > 255)
			b = 255;
			
		parentScene.getCanvas().setStrokeColor(Color.rgb(r, g, b));
	}
}
