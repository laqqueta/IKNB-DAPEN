package id.go.ojk.bptk.client.builder.field.lpbptkjkp.reference;

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
public enum EHeaderMetadataLpbptkjkp implements IObject<ReferenceMetadata> {
  R6202RPIU(ER6202RPIU.getRefNumber(), ER6202RPIU.getName(), ER6202RPIU.getObjects()),
  R6203RPMF(ER6203RPMF.getRefNumber(), ER6203RPMF.getName(), ER6203RPMF.getObjects()),
  R6205RKPMF(ER6205RKPMF.getRefNumber(), ER6205RKPMF.getName(), ER6205RKPMF.getObjects()),
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
    for (EHeaderMetadataLpbptkjkp eEnum : EHeaderMetadataLpbptkjkp.values()) {
      res.add(eEnum.getObject());
    }
    return res;
  }

  public static Map<String, List<KeyValueString>> getMap() {
    Map<String, List<KeyValueString>> res = new HashMap<>();
    for (EHeaderMetadataLpbptkjkp eEnum : EHeaderMetadataLpbptkjkp.values()) {
      res.put(eEnum.getFileName(), eEnum.references);
    }
    return res;
  }
}
