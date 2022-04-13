package pProperties;

import javafx.beans.property.ObjectPropertyBase;

public class NumberProperty extends ObjectPropertyBase<Number>{
	public Object getBean() {
		return this.getValue();
	}

	public String getName() {
		return "Number Property";
	}

}
