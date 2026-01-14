package id.go.ojk.bptk.client.builder.field.lbbptkjp.reference;

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
public enum EHeaderMetadataLbbptkjp implements IObject<ReferenceMetadata> {
  R5801LAN (ER5801LAN.getRefNumber(), ER5801LAN.getName(), ER5801LAN.getObjects()),
  R5802LPAN (ER5802LPAN.getRefNumber(), ER5802LPAN.getName(), ER5802LPAN.getObjects()),
  R5803AI (ER5803AI.getRefNumber(), ER5803AI.getName(), ER5803AI.getObjects()),
  R5804HAI (ER5804HAI.getRefNumber(), ER5804HAI.getName(), ER5804HAI.getObjects()),
  R5809PROP (ER5809PROP.getRefNumber(), ER5809PROP.getName(), ER5809PROP.getObjects()),
  R5811PIUT (ER5811PIUT.getRefNumber(), ER5811PIUT.getName(), ER5811PIUT.getObjects()),
  R5812NKA (ER5812NKA.getRefNumber(), ER5812NKA.getName(), ER5812NKA.getObjects()),
  R5807INVDEP (ER5807INVDEP.getRefNumber(), ER5807INVDEP.getName(), ER5807INVDEP.getObjects()),
  R5808INVSB (ER5808INVSB.getRefNumber(), ER5808INVSB.getName(), ER5808INVSB.getObjects()),
  R5805RAS (ER5805RAS.getRefNumber(), ER5805RAS.getName(), ER5805RAS.getObjects()),
  R5806RASL (ER5806RASL.getRefNumber(), ER5806RASL.getName(), ER5806RASL.getObjects()), 
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
    for (EHeaderMetadataLbbptkjp eEnum : EHeaderMetadataLbbptkjp.values()) {
      res.add(eEnum.getObject());
    }
    return res;
  }

  public static Map<String, List<KeyValueString>> getMap() {
    Map<String, List<KeyValueString>> res = new HashMap<>();
    for (EHeaderMetadataLbbptkjp eEnum : EHeaderMetadataLbbptkjp.values()) {
      res.put(eEnum.getFileName(), eEnum.references);
    }
    return res;
  }
}
