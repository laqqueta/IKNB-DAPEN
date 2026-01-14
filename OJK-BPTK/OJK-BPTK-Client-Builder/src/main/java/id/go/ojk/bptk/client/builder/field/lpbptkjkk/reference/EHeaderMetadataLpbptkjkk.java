package id.go.ojk.bptk.client.builder.field.lpbptkjkk.reference;

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
public enum EHeaderMetadataLpbptkjkk implements IObject<ReferenceMetadata> {
  R5901RKPST(ER5901RKPST.getRefNumber(), ER5901RKPST.getName(), ER5901RKPST.getObjects()),
  R5902RPIU(ER5902RPIU.getRefNumber(), ER5902RPIU.getName(), ER5902RPIU.getObjects()),
  R5903RPMF(ER5903RPMF.getRefNumber(), ER5903RPMF.getName(), ER5903RPMF.getObjects()),
  R5904RKPIU(ER5904RKPIU.getRefNumber(), ER5904RKPIU.getName(), ER5904RKPIU.getObjects()),
  R5905RKPMF(ER5905RKPMF.getRefNumber(), ER5905RKPMF.getName(), ER5905RKPMF.getObjects()),;

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
    for (EHeaderMetadataLpbptkjkk eEnum : EHeaderMetadataLpbptkjkk.values()) {
      res.add(eEnum.getObject());
    }
    return res;
  }

  public static Map<String, List<KeyValueString>> getMap() {
    Map<String, List<KeyValueString>> res = new HashMap<>();
    for (EHeaderMetadataLpbptkjkk eEnum : EHeaderMetadataLpbptkjkk.values()) {
      res.put(eEnum.getFileName(), eEnum.references);
    }
    return res;
  }
}
