package id.go.ojk.lib.client.model.bind;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class VersionModel {

	public final StringProperty applicationVersionProperty = new SimpleStringProperty();
	public final StringProperty libraryVersionProperty = new SimpleStringProperty();
	public final StringProperty referencesVersionProperty = new SimpleStringProperty();
	public final StringProperty metadataVersionProperty = new SimpleStringProperty();
	public final StringProperty setupModifiedProperty = new SimpleStringProperty();
	public final StringProperty setupModifiedParseProperty = new SimpleStringProperty();

}
