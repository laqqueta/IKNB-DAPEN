package id.go.ojk.pa.client.builder.field.tpp.reference;

import java.util.*;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.lib.client.model.reference.ReferenceMetadata;
import id.go.ojk.lib.client.model.reference.ReferenceType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EHeaderMetadataTpp implements IObject<ReferenceMetadata> {
    R1000_Pos81A101(ER1000Pos81A101.getRefNumber(), ER1000Pos81A101.getName(), ER1000Pos81A101.getObjects()),
    R1001_Pos81A201(ER1001Pos81A201.getRefNumber(), ER1001Pos81A201.getName(), ER1001Pos81A201.getObjects())
    ;

    private final int number;
    private final String name;
    private final List<KeyValueString> references;

    public String getFileName() {
        StringBuilder res = new StringBuilder("R");
        res.append(number);
        res.append(name);
        res.append(".xml");
        return res.toString();
    }

    public String getDescription() {
        return "Form " + name.substring(3);
    }

    @Override
    public ReferenceMetadata getObject() {
        ReferenceMetadata res = new ReferenceMetadata(number, name, ReferenceType.keyValue, getDescription(), "");
        res.setPerSegment(false);
        res.setLabel1Map(null);
        return res;
    }

    public static List<ReferenceMetadata> getObjects() {
        List<ReferenceMetadata> res = new ArrayList<>();
        for (EHeaderMetadataTpp eEnum : EHeaderMetadataTpp.values()) {
            res.add(eEnum.getObject());
        }
        return res;
    }

    public static Map<String, List<KeyValueString>> getMap() {
        Map<String, List<KeyValueString>> res = new HashMap<>();
        for (EHeaderMetadataTpp eEnum : EHeaderMetadataTpp.values()) {
            res.put(eEnum.getFileName(), eEnum.references);
        }
        return res;
    }

}
