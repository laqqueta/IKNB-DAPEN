package id.go.ojk.asrjk.client.builder.field.sa.reference;

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
public enum EHeaderMetadataSa implements IObject<ReferenceMetadata> {
	R4000_SA0100 (ER4000PosSaAsrjk0100.getRefNumber(), ER4000PosSaAsrjk0100.getName(), ER4000PosSaAsrjk0100.getObjects()),
	R4001_SA0201 (ER4001PosSaAsrjk0201.getRefNumber(), ER4001PosSaAsrjk0201.getName(), ER4001PosSaAsrjk0201.getObjects()),
	R4002_SA0202 (ER4002PosSaAsrjk0202.getRefNumber(), ER4002PosSaAsrjk0202.getName(), ER4002PosSaAsrjk0202.getObjects()),
	R4003_SA0203 (ER4003PosSaAsrjk0203.getRefNumber(), ER4003PosSaAsrjk0203.getName(), ER4003PosSaAsrjk0203.getObjects()),
	R4004_SA0204 (ER4004PosSaAsrjk0204.getRefNumber(), ER4004PosSaAsrjk0204.getName(), ER4004PosSaAsrjk0204.getObjects()),
	R4005_SA0205 (ER4005PosSaAsrjk0205.getRefNumber(), ER4005PosSaAsrjk0205.getName(), ER4005PosSaAsrjk0205.getObjects()),
	R4006_SA0206 (ER4006PosSaAsrjk0206.getRefNumber(), ER4006PosSaAsrjk0206.getName(), ER4006PosSaAsrjk0206.getObjects()),
	R4007_SA0207 (ER4007PosSaAsrjk0207.getRefNumber(), ER4007PosSaAsrjk0207.getName(), ER4007PosSaAsrjk0207.getObjects()),
	R4008_SA0208 (ER4008PosSaAsrjk0208.getRefNumber(), ER4008PosSaAsrjk0208.getName(), ER4008PosSaAsrjk0208.getObjects()),
	R4009_SA0209 (ER4009PosSaAsrjk0209.getRefNumber(), ER4009PosSaAsrjk0209.getName(), ER4009PosSaAsrjk0209.getObjects()),
	R4010_SA0210 (ER4010PosSaAsrjk0210.getRefNumber(), ER4010PosSaAsrjk0210.getName(), ER4010PosSaAsrjk0210.getObjects()),
	R4011_SA0211 (ER4011PosSaAsrjk0211.getRefNumber(), ER4011PosSaAsrjk0211.getName(), ER4011PosSaAsrjk0211.getObjects()),
	R4012_SA0300 (ER4012PosSaAsrjk0300.getRefNumber(), ER4012PosSaAsrjk0300.getName(), ER4012PosSaAsrjk0300.getObjects()),
	R4013_SA0400 (ER4013PosSaAsrjk0400.getRefNumber(), ER4013PosSaAsrjk0400.getName(), ER4013PosSaAsrjk0400.getObjects()),
	R4014_SA0501 (ER4014PosSaAsrjk0501.getRefNumber(), ER4014PosSaAsrjk0501.getName(), ER4014PosSaAsrjk0501.getObjects()),
	R4015_SA0502 (ER4015PosSaAsrjk0502.getRefNumber(), ER4015PosSaAsrjk0502.getName(), ER4015PosSaAsrjk0502.getObjects()),
	R4016_SA0503 (ER4016PosSaAsrjk0503.getRefNumber(), ER4016PosSaAsrjk0503.getName(), ER4016PosSaAsrjk0503.getObjects()),
//	R4017_SA8888 (ER4017PosSaAsrjk8888.getRefNumber(), ER4017PosSaAsrjk8888.getName(), ER4017PosSaAsrjk8888.getObjects()),
//	R4018_SA9999 (ER4018PosSaAsrjk9999.getRefNumber(), ER4018PosSaAsrjk9999.getName(), ER4018PosSaAsrjk9999.getObjects()),
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
		return "R" + number + name; 
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
		for (EHeaderMetadataSa eEnum : EHeaderMetadataSa.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static Map<String, List<KeyValueString>> getMap() {
		Map<String, List<KeyValueString>> res = new HashMap<>();
		for (EHeaderMetadataSa eEnum : EHeaderMetadataSa.values()) {
			res.put(eEnum.getFileName(), eEnum.references);
		}
		return res;
	}
}
