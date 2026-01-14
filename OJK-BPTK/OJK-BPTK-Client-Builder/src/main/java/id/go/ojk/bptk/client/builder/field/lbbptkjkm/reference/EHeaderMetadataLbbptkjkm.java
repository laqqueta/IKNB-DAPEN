package id.go.ojk.bptk.client.builder.field.lbbptkjkm.reference;

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
public enum EHeaderMetadataLbbptkjkm implements IObject<ReferenceMetadata> {
  R5501LPK (ER5501LPK.getRefNumber(), ER5501LPK.getName(), ER5501LPK.getObjects()),
  R5502LPKOMP (ER5502LPKOMP.getRefNumber(), ER5502LPKOMP.getName(), ER5502LPKOMP.getObjects()),
  R5503LPAN (ER5503LPAN.getRefNumber(), ER5503LPAN.getName(), ER5503LPAN.getObjects()),
  R5507RAS (ER5507RAS.getRefNumber(), ER5507RAS.getName(), ER5507RAS.getObjects()),
  R5508RASL (ER5508RASL.getRefNumber(), ER5508RASL.getName(), ER5508RASL.getObjects()),
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
    for (EHeaderMetadataLbbptkjkm eEnum : EHeaderMetadataLbbptkjkm.values()) {
      res.add(eEnum.getObject());
    }
    return res;
  }

  public static Map<String, List<KeyValueString>> getMap() {
    Map<String, List<KeyValueString>> res = new HashMap<>();
    for (EHeaderMetadataLbbptkjkm eEnum : EHeaderMetadataLbbptkjkm.values()) {
      res.put(eEnum.getFileName(), eEnum.references);
    }
    return res;
  }
}
