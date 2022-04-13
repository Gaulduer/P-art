package pProperties;

/*
 * Peter Gauld
 * ColorProperty - A color property to be used with certain P-art objects.
 * 
 * 4/13/2022 - File Created.
 */

import javafx.scene.paint.Color;
import fxAppeareance.Designer;
import javafx.beans.property.ObjectPropertyBase;

public class ColorProperty extends ObjectPropertyBase<Color>{
	public ColorProperty() {
		this.setValue(Designer.getColor(0, 0, 0));
	}
	
	public ColorProperty(Color color) {
		this.setValue(color);
	}
	
	public Color getBean() {
		return this.getValue();
	}

	public String getName() {
		return "Color Property";
	}
}
