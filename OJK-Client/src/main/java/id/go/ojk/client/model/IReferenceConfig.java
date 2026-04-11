package id.go.ojk.client.model;

import id.go.ojk.lib.client.model.KeyValueString;

import java.util.List;

public interface IReferenceConfig {

    default String getSavePos(List<KeyValueString> objects) {
        return null;
    }

    default String getSavePosForm(List<KeyValueString> objects) {
        return null;
    }

    default String getFieldSave(List<KeyValueString> objects) {
        return null;
    }

    default String getRequiredPos(List<KeyValueString> objects) {
        return null;
    }

    default String getUniquePos(List<KeyValueString> objects) {
        return null;
    }
}
