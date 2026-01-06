package id.go.ojk.lib.client.vc.object;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ReportValue {
	private final StringProperty id;
	private final StringProperty name;

	public ReportValue(String id, String name) {
		this.id = new SimpleStringProperty(id);
		this.name = new SimpleStringProperty(name);
	}

	public StringProperty idProperty() {
		return id;
	}

	public StringProperty nameProperty() {
		return name;
	}
}
