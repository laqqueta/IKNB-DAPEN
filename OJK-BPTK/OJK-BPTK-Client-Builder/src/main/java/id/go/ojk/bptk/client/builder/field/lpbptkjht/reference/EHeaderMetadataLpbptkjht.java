package id.go.ojk.bptk.client.builder.field.lpbptkjht.reference;

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
public enum EHeaderMetadataLpbptkjht implements IObject<ReferenceMetadata> {
  R6103RDJHT(ER6103RDJHT.getRefNumber(), ER6103RDJHT.getName(), ER6103RDJHT.getObjects()),
  R6104RPMF(ER6104RPMF.getRefNumber(), ER6104RPMF.getName(), ER6104RPMF.getObjects()),
  R6105RKPIU(ER6105RKPIU.getRefNumber(), ER6105RKPIU.getName(), ER6105RKPIU.getObjects()),
  R6106RKPMF(ER6106RKPMF.getRefNumber(), ER6106RKPMF.getName(), ER6106RKPMF.getObjects()),
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
    for (EHeaderMetadataLpbptkjht eEnum : EHeaderMetadataLpbptkjht.values()) {
      res.add(eEnum.getObject());
    }
    return res;
  }

  public static Map<String, List<KeyValueString>> getMap() {
    Map<String, List<KeyValueString>> res = new HashMap<>();
    for (EHeaderMetadataLpbptkjht eEnum : EHeaderMetadataLpbptkjht.values()) {
      res.put(eEnum.getFileName(), eEnum.references);
    }
    return res;
  }
}
