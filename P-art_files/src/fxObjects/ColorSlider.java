package fxObjects;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/*
 * Peter Gauld
 * Color Slider - A slider object meant to be used when selecting rgb colors.
 * 
 * 3/30/2022 - File Created.
 */

import javafx.scene.control.Slider;

public class ColorSlider extends Slider{
	public ColorSlider() {
		super(0, 255, 0);
		
		ColorSlider slider = this;
		
		slider.valueProperty().addListener(new ChangeListener<Number>() {
			public void changed(ObservableValue<? extends Number> o, Number l, Number n) {
				slider.setValue(Math.round(n.doubleValue()));
			}
		});
	}
}