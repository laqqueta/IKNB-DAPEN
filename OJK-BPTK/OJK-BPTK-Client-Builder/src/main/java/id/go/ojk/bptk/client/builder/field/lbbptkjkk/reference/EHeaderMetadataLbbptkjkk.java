package id.go.ojk.bptk.client.builder.field.lbbptkjkk.reference;

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
public enum EHeaderMetadataLbbptkjkk implements IObject<ReferenceMetadata> {
  R5401LPK (ER5401LPK.getRefNumber(), ER5401LPK.getName(), ER5401LPK.getObjects()),
  R5402LPKOMP (ER5402LPKOMP.getRefNumber(), ER5402LPKOMP.getName(), ER5402LPKOMP.getObjects()),
  R5403LPAN (ER5403LPAN.getRefNumber(), ER5403LPAN.getName(), ER5403LPAN.getObjects()),
  R5404LAK (ER5404LAK.getRefNumber(), ER5404LAK.getName(), ER5404LAK.getObjects()),
  R5405AI (ER5405AI.getRefNumber(), ER5405AI.getName(), ER5405AI.getObjects()),
  R5406HAI (ER5406HAI.getRefNumber(), ER5406HAI.getName(), ER5406HAI.getObjects()),
  R5407RAS (ER5407RAS.getRefNumber(), ER5407RAS.getName(), ER5407RAS.getObjects()),
  R5408RASL (ER5408RASL.getRefNumber(), ER5408RASL.getName(), ER5408RASL.getObjects()),
  R5413PIUT (ER5413PIUT.getRefNumber(), ER5413PIUT.getName(), ER5413PIUT.getObjects()),
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
//    return "R" + number + name;
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
    for (EHeaderMetadataLbbptkjkk eEnum : EHeaderMetadataLbbptkjkk.values()) {
      res.add(eEnum.getObject());
    }
    return res;
  }

  public static Map<String, List<KeyValueString>> getMap() {
    Map<String, List<KeyValueString>> res = new HashMap<>();
    for (EHeaderMetadataLbbptkjkk eEnum : EHeaderMetadataLbbptkjkk.values()) {
      res.put(eEnum.getFileName(), eEnum.references);
    }
    return res;
  }
}
