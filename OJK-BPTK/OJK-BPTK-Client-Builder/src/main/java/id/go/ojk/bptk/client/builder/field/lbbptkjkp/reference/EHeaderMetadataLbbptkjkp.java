package id.go.ojk.bptk.client.builder.field.lbbptkjkp.reference;

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
public enum EHeaderMetadataLbbptkjkp implements IObject<ReferenceMetadata> {
  R5701LPK (ER5701LPK.getRefNumber(), ER5701LPK.getName(), ER5701LPK.getObjects()),
  R5702LPKOMP (ER5702LPKOMP.getRefNumber(), ER5702LPKOMP.getName(), ER5702LPKOMP.getObjects()),
  R5703LPAN (ER5703LPAN.getRefNumber(), ER5703LPAN.getName(), ER5703LPAN.getObjects()),
  R5704LAK (ER5704LAK.getRefNumber(), ER5704LAK.getName(), ER5704LAK.getObjects()),
  R5705AI (ER5705AI.getRefNumber(), ER5705AI.getName(), ER5705AI.getObjects()),
  R5706HAI (ER5706HAI.getRefNumber(), ER5706HAI.getName(), ER5706HAI.getObjects()),
  R5707RAS (ER5707RAS.getRefNumber(), ER5707RAS.getName(), ER5707RAS.getObjects()),
  R5708RASL (ER5708RASL.getRefNumber(), ER5708RASL.getName(), ER5708RASL.getObjects()),
  R5709INVDEP (ER5709INVDEP.getRefNumber(), ER5709INVDEP.getName(), ER5709INVDEP.getObjects()),
  R5710INVSB (ER5710INVSB.getRefNumber(), ER5710INVSB.getName(), ER5710INVSB.getObjects()), 
  R5711PROP (ER5711PROP.getRefNumber(), ER5711PROP.getName(), ER5711PROP.getObjects()),
  R5712SBN (ER5712SBN.getRefNumber(), ER5712SBN.getName(), ER5712SBN.getObjects()),
  R5713PIUT (ER5713PIUT.getRefNumber(), ER5713PIUT.getName(), ER5713PIUT.getObjects()),
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
    for (EHeaderMetadataLbbptkjkp eEnum : EHeaderMetadataLbbptkjkp.values()) {
      res.add(eEnum.getObject());
    }
    return res;
  }

  public static Map<String, List<KeyValueString>> getMap() {
    Map<String, List<KeyValueString>> res = new HashMap<>();
    for (EHeaderMetadataLbbptkjkp eEnum : EHeaderMetadataLbbptkjkp.values()) {
      res.put(eEnum.getFileName(), eEnum.references);
    }
    return res;
  }
}
