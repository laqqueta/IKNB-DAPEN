package id.go.ojk.bptk.client.builder.field.lbbptkjht.reference;

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
public enum EHeaderMetadataLbbptkjht implements IObject<ReferenceMetadata> {
  R5601LAN (ER5601LAN.getRefNumber(), ER5601LAN.getName(), ER5601LAN.getObjects()),
  R5602LPAN (ER5602LPAN.getRefNumber(), ER5602LPAN.getName(), ER5602LPAN.getObjects()),
  R5603AI (ER5603AI.getRefNumber(), ER5603AI.getName(), ER5603AI.getObjects()),
  R5604HAI (ER5604HAI.getRefNumber(), ER5604HAI.getName(), ER5604HAI.getObjects()),
  R5605RAS (ER5605RAS.getRefNumber(), ER5605RAS.getName(), ER5605RAS.getObjects()),
  R5606RASL (ER5606RASL.getRefNumber(), ER5606RASL.getName(), ER5606RASL.getObjects()),
  R5611PIUT (ER5611PIUT.getRefNumber(), ER5611PIUT.getName(), ER5611PIUT.getObjects()),
  R5612ANT (ER5612ANT.getRefNumber(), ER5612ANT.getName(), ER5612ANT.getObjects()),
  R5607INVDEP (ER5607INVDEP.getRefNumber(), ER5607INVDEP.getName(), ER5607INVDEP.getObjects()),
  R5608INVSB (ER5608INVSB.getRefNumber(), ER5608INVSB.getName(), ER5608INVSB.getObjects()),
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
    for (EHeaderMetadataLbbptkjht eEnum : EHeaderMetadataLbbptkjht.values()) {
      res.add(eEnum.getObject());
    }
    return res;
  }

  public static Map<String, List<KeyValueString>> getMap() {
    Map<String, List<KeyValueString>> res = new HashMap<>();
    for (EHeaderMetadataLbbptkjht eEnum : EHeaderMetadataLbbptkjht.values()) {
      res.put(eEnum.getFileName(), eEnum.references);
    }
    return res;
  }
}
