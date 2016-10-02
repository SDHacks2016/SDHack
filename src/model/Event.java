
package model;

import java.awt.event.ActionListener;

public class Event {

	private String category;
	public String getCategory() {
		return category;
	}
	public String getName() {
		return name;
	}
	public Action getAssociatedAction() {
		return associatedAction;
	}
	private String name;
	public Event(String category, String name, Action associatedAction) {
		super();
		this.category = category;
		this.name = name;
		this.associatedAction = associatedAction;
	}
	private Action associatedAction;
}
