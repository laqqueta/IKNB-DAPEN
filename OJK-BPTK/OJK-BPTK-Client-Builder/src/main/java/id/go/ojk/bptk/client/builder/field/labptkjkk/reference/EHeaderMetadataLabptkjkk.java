package id.go.ojk.bptk.client.builder.field.labptkjkk.reference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.lib.client.model.reference.ReferenceMetadata;
import id.go.ojk.lib.client.model.reference.ReferenceType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EHeaderMetadataLabptkjkk implements IObject<ReferenceMetadata> {
  R6401DTUM(ER6401DTUM.getRefNumber(), ER6401DTUM.getName(), ER6401DTUM.getObjects()),
  R6402RAS(ER6402RAS.getRefNumber(), ER6402RAS.getName(), ER6402RAS.getObjects()),
  ;

  private int number;
  private String name;
  private List<KeyValueString> references;

  public String getFileName() {
    StringBuilder res = new StringBuilder("R");
    res.append(number);
    res.append(name);
    res.append(".xml");
    return res.toString();
  }

  public String getDescription() {
    return name;
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
    for (EHeaderMetadataLabptkjkk eEnum : EHeaderMetadataLabptkjkk.values()) {
      res.add(eEnum.getObject());
    }
    return res;
  }

  public static Map<String, List<KeyValueString>> getMap() {
    Map<String, List<KeyValueString>> res = new HashMap<>();
    for (EHeaderMetadataLabptkjkk eEnum : EHeaderMetadataLabptkjkk.values()) {
      res.put(eEnum.getFileName(), eEnum.references);
    }
    return res;
  }
}
