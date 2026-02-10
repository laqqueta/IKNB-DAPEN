package id.go.ojk.bptk.client.builder.field.lbbptkbdn.reference;

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
public enum EHeaderMetadataLbbptkbdn implements IObject<ReferenceMetadata> {
  R5300DTUM(ER5300DTUM.getRefNumber(), ER5300DTUM.getName(), ER5300DTUM.getObjects()),
  R5301LPK(ER5301LPK.getRefNumber(), ER5301LPK.getName(), ER5301LPK.getObjects()),
  R5302LKK(ER5302LKK.getRefNumber(), ER5302LKK.getName(), ER5302LKK.getObjects()),
  R5303LPE(ER5303LPE.getRefNumber(), ER5303LPE.getName(), ER5303LPE.getObjects()),
  R5304LAK(ER5304LAK.getRefNumber(), ER5304LAK.getName(), ER5304LAK.getObjects()),
  R5305AI (ER5305AI.getRefNumber(), ER5305AI.getName(), ER5305AI.getObjects()),
  R5306HAI (ER5306HAI.getRefNumber(), ER5306HAI.getName(), ER5306HAI.getObjects()),
  R5307RAS (ER5307RAS.getRefNumber(), ER5307RAS.getName(), ER5307RAS.getObjects()),
  R5308RASL (ER5308RASL.getRefNumber(), ER5308RASL.getName(), ER5308RASL.getObjects()),
  R5309INVDEP (ER5309INVDEP.getRefNumber(), ER5309INVDEP.getName(), ER5309INVDEP.getObjects()),
  R5310INVSB (ER5310INVSB.getRefNumber(), ER5310INVSB.getName(), ER5310INVSB.getObjects()),
  R5311PROP (ER5311PROP.getRefNumber(), ER5311PROP.getName(), ER5311PROP.getObjects()),
  R5312SBN (ER5312SBN.getRefNumber(), ER5312SBN.getName(), ER5312SBN.getObjects()),
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
//    return "R" + number + name;
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
    for (EHeaderMetadataLbbptkbdn eEnum : EHeaderMetadataLbbptkbdn.values()) {
      res.add(eEnum.getObject());
    }
    return res;
  }

  public static Map<String, List<KeyValueString>> getMap() {
    Map<String, List<KeyValueString>> res = new HashMap<>();
    for (EHeaderMetadataLbbptkbdn eEnum : EHeaderMetadataLbbptkbdn.values()) {
      res.put(eEnum.getFileName(), eEnum.references);
    }
    return res;
  }
}
