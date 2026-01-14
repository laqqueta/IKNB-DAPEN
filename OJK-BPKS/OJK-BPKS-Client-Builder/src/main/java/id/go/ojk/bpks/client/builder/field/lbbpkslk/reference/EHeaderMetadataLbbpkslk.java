package id.go.ojk.bpks.client.builder.field.lbbpkslk.reference;

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
public enum EHeaderMetadataLbbpkslk implements IObject<ReferenceMetadata> {
  R5000LPK(ER5000LPK.getRefNumber(), ER5000LPK.getName(), ER5000LPK.getObjects()),
  R5001LKK(ER5001LKK.getRefNumber(), ER5001LKK.getName(), ER5001LKK.getObjects()),
  R5002LPE(ER5002LPE.getRefNumber(), ER5002LPE.getName(), ER5002LPE.getObjects()),
  R5003LAK(ER5003LAK.getRefNumber(), ER5003LAK.getName(), ER5003LAK.getObjects()),
  R5004AI(ER5004AI.getRefNumber(), ER5004AI.getName(), ER5004AI.getObjects()),
  R5005HIN(ER5005HIN.getRefNumber(), ER5005HIN.getName(), ER5005HIN.getObjects()),
  R5006ALM(ER5006ALM.getRefNumber(), ER5006ALM.getName(), ER5006ALM.getObjects()),
  R5007RKE(ER5007RKE.getRefNumber(), ER5007RKE.getName(), ER5007RKE.getObjects()),
  R5008IPL(ER5008IPL.getRefNumber(), ER5008IPL.getName(), ER5008IPL.getObjects()),
  R5009INV(ER5009INV.getRefNumber(), ER5009INV.getName(), ER5009INV.getObjects()),
  R5010RPRI(ER5010RPRI.getRefNumber(), ER5010RPRI.getName(), ER5010RPRI.getObjects()),
  R5011SBN(ER5011SBN.getRefNumber(), ER5011SBN.getName(), ER5011SBN.getObjects()),
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
    for (EHeaderMetadataLbbpkslk eEnum : EHeaderMetadataLbbpkslk.values()) {
      res.add(eEnum.getObject());
    }
    return res;
  }

  public static Map<String, List<KeyValueString>> getMap() {
    Map<String, List<KeyValueString>> res = new HashMap<>();
    for (EHeaderMetadataLbbpkslk eEnum : EHeaderMetadataLbbpkslk.values()) {
      res.put(eEnum.getFileName(), eEnum.references);
    }
    return res;
  }
}
