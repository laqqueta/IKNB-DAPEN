package id.go.ojk.bptk.client.builder.field.lpbptkjp.reference;

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
public enum EHeaderMetadataLpbptkjp implements IObject<ReferenceMetadata> {
  R6301RKPST(ER6301RKPST.getRefNumber(), ER6301RKPST.getName(), ER6301RKPST.getObjects()),
  R6303RDJP(ER6303RDJP.getRefNumber(), ER6303RDJP.getName(), ER6303RDJP.getObjects()),
  R6304RPMF(ER6304RPMF.getRefNumber(), ER6304RPMF.getName(), ER6304RPMF.getObjects()),
  R6305RKPIU(ER6305RKPIU.getRefNumber(), ER6305RKPIU.getName(), ER6305RKPIU.getObjects()),
  R6306RKPMF(ER6306RKPMF.getRefNumber(), ER6306RKPMF.getName(), ER6306RKPMF.getObjects()),
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
    for (EHeaderMetadataLpbptkjp eEnum : EHeaderMetadataLpbptkjp.values()) {
      res.add(eEnum.getObject());
    }
    return res;
  }

  public static Map<String, List<KeyValueString>> getMap() {
    Map<String, List<KeyValueString>> res = new HashMap<>();
    for (EHeaderMetadataLpbptkjp eEnum : EHeaderMetadataLpbptkjp.values()) {
      res.put(eEnum.getFileName(), eEnum.references);
    }
    return res;
  }
}
