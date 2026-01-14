package id.go.ojk.bpks.client.builder.field.lbbpksdjs.reference;

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
public enum EHeaderMetadataLbbpksdjs implements IObject<ReferenceMetadata> {
  R5100LPK(ER5100LPK.getRefNumber(), ER5100LPK.getName(), ER5100LPK.getObjects()),
  R5101LAV(ER5101LAV.getRefNumber(), ER5101LAV.getName(), ER5101LAV.getObjects()),
  R5102LAK(ER5102LAK.getRefNumber(), ER5102LAK.getName(), ER5102LAK.getObjects()),
  R5103LPAN(ER5103LPAN.getRefNumber(), ER5103LPAN.getName(), ER5103LPAN.getObjects()),
  R5104AIN(ER5104AIN.getRefNumber(), ER5104AIN.getName(), ER5104AIN.getObjects()),
  R5105HIN(ER5105HIN.getRefNumber(), ER5105HIN.getName(), ER5105HIN.getObjects()),
  R5106RKU(ER5106RKU.getRefNumber(), ER5106RKU.getName(), ER5106RKU.getObjects()),
  R5107ALM(ER5107ALM.getRefNumber(), ER5107ALM.getName(), ER5107ALM.getObjects()),
  // FORM INV menggunakan LBBPKSLK karena kesamaan metadata
  R5109RPI(ER5109RPI.getRefNumber(), ER5109RPI.getName(), ER5109RPI.getObjects()),
  R5110LAKD(ER5110LAKD.getRefNumber(), ER5110LAKD.getName(), ER5110LAKD.getObjects()),
  R5111LKPS(ER5111LKPS.getRefNumber(), ER5111LKPS.getName(), ER5111LKPS.getObjects()),
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
    return "Form " + name;
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
    for (EHeaderMetadataLbbpksdjs eEnum : EHeaderMetadataLbbpksdjs.values()) {
      res.add(eEnum.getObject());
    }
    return res;
  }

  public static Map<String, List<KeyValueString>> getMap() {
    Map<String, List<KeyValueString>> res = new HashMap<>();
    for (EHeaderMetadataLbbpksdjs eEnum : EHeaderMetadataLbbpksdjs.values()) {
      res.put(eEnum.getFileName(), eEnum.references);
    }
    return res;
  }
}
