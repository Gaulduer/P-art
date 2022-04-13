package pProperties;

import javafx.beans.property.ObjectPropertyBase;

public class BooleanProperty extends ObjectPropertyBase<Boolean>{
	public Object getBean() {
		return getValue();
	}

	@Override
	public String getName() {
		return "Boolean Property";
	}

}
