package id.go.ojk.bpks.client.builder.field.lbbpkslpp.reference;

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
public enum EHeaderMetadataLbbpkslpp implements IObject<ReferenceMetadata> {
  R5200PRUM(ER5200PRUM.getRefNumber(), ER5200PRUM.getName(), ER5200PRUM.getObjects()),
  R5201DWAS(ER5201DWAS.getRefNumber(), ER5201DWAS.getName(), ER5201DWAS.getObjects()),
  R5202DIR(ER5202DIR.getRefNumber(), ER5202DIR.getName(), ER5202DIR.getObjects()),
  R5203ORG(ER5203ORG.getRefNumber(), ER5203ORG.getName(), ER5203ORG.getObjects()),
  R5204KWKC(ER5204KWKC.getRefNumber(), ER5204KWKC.getName(), ER5204KWKC.getObjects()),
  R5205PDK(ER5205PDK.getRefNumber(), ER5205PDK.getName(), ER5205PDK.getObjects()),
  R5206STR(ER5206STR.getRefNumber(), ER5206STR.getName(), ER5206STR.getObjects()),
  R5207RKPS(ER5207RKPS.getRefNumber(), ER5207RKPS.getName(), ER5207RKPS.getObjects()),
  R5208RKPI(ER5208RKPI.getRefNumber(), ER5208RKPI.getName(), ER5208RKPI.getObjects()),
  R5209RKLM(ER5209RKLM.getRefNumber(), ER5209RKLM.getName(), ER5209RKLM.getObjects()),
  R5210RFASK(ER5210RFASK.getRefNumber(), ER5210RFASK.getName(), ER5210RFASK.getObjects()),
  R5211RKPNG(ER5211RKPNG.getRefNumber(), ER5211RKPNG.getName(), ER5211RKPNG.getObjects()),
  R5212RPKAP(ER5212RPKAP.getRefNumber(), ER5212RPKAP.getName(), ER5212RPKAP.getObjects()),
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
    for (EHeaderMetadataLbbpkslpp eEnum : EHeaderMetadataLbbpkslpp.values()) {
      res.add(eEnum.getObject());
    }
    return res;
  }

  public static Map<String, List<KeyValueString>> getMap() {
    Map<String, List<KeyValueString>> res = new HashMap<>();
    for (EHeaderMetadataLbbpkslpp eEnum : EHeaderMetadataLbbpkslpp.values()) {
      res.put(eEnum.getFileName(), eEnum.references);
    }
    return res;
  }
}
