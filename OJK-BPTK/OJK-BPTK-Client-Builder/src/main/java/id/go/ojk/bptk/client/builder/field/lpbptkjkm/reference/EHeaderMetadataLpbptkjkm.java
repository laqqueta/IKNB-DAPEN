package id.go.ojk.bptk.client.builder.field.lpbptkjkm.reference;

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
public enum EHeaderMetadataLpbptkjkm implements IObject<ReferenceMetadata> {
  R60035RPMF(ER6003RPMF.getRefNumber(), ER6003RPMF.getName(), ER6003RPMF.getObjects()),
  R6005RKPMF(ER6005RKPMF.getRefNumber(), ER6005RKPMF.getName(), ER6005RKPMF.getObjects()),
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
    for (EHeaderMetadataLpbptkjkm eEnum : EHeaderMetadataLpbptkjkm.values()) {
      res.add(eEnum.getObject());
    }
    return res;
  }

  public static Map<String, List<KeyValueString>> getMap() {
    Map<String, List<KeyValueString>> res = new HashMap<>();
    for (EHeaderMetadataLpbptkjkm eEnum : EHeaderMetadataLpbptkjkm.values()) {
      res.put(eEnum.getFileName(), eEnum.references);
    }
    return res;
  }
}
