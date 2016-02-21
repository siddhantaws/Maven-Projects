package com.manh.spring.mvc.binders;

import java.beans.PropertyEditorSupport;

public class NameTypeEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) {
		if (text == null) {
			setValue(null);
		}
		else {
			String value = text.toUpperCase();
			setValue(value);
		}
	}
}
