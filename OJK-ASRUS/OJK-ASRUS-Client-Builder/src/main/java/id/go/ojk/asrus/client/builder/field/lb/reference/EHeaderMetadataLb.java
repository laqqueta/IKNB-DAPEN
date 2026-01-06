package id.go.ojk.asrus.client.builder.field.lb.reference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import id.go.ojk.lib.client.CollectionUtil;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.lib.client.model.reference.ReferenceMetadata;
import id.go.ojk.lib.client.model.reference.ReferenceType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EHeaderMetadataLb implements IObject<ReferenceMetadata> {
	R3000_LB000 (3000, "PosLbAsrus000", ReferenceType.keyValue, "", null, false, null, ER3000PosLbAsrus000.getObjects()),
	R3001_LB001 (3001, "PosLbAsrus001", ReferenceType.keyValue, "", null, false, null, ER3001PosLbAsrus001.getObjects()),
	R3002_LB002 (3002, "PosLbAsrus002", ReferenceType.keyValue, "", null, false, null, ER3002PosLbAsrus002.getObjects()),
	R3003_LB003 (3003, "PosLbAsrus003", ReferenceType.keyValue, "", null, false, null, ER3003PosLbAsrus003.getObjects()),
	R3004_LB004 (3004, "PosLbAsrus004", ReferenceType.keyValue, "", null, false, null, ER3004PosLbAsrus004.getObjects()),
//	R3005_LB910 (3005, "PosLbAsrus910", ReferenceType.keyValue, "", null, false, null, ER3005PosLbAsrus910.getObjects()),
	R3006_LB100 (3006, "PosLbAsrus100", ReferenceType.keyValue, "", null, false, null, ER3006PosLbAsrus100.getObjects()),
	R3007_LB200 (3007, "PosLbAsrus200", ReferenceType.keyValue, "", null, false, null, ER3007PosLbAsrus200.getObjects()),
	R3008_LB300 (3008, "PosLbAsrus300", ReferenceType.keyValue, "", null, false, null, ER3008PosLbAsrus300.getObjects()),
	R3009_LB400 (3009, "PosLbAsrus400", ReferenceType.keyValue, "", null, false, null, ER3009PosLbAsrus400.getObjects()),
	R3010_LB500 (3010, "PosLbAsrus500", ReferenceType.keyValue, "", null, false, null, ER3010PosLbAsrus500.getObjects()),
	R3011_LB501 (3011, "PosLbAsrus501", ReferenceType.keyValue, "", null, false, null, ER3011PosLbAsrus501.getObjects()),
	R3012_LB600 (3012, "PosLbAsrus600", ReferenceType.keyValue, "", null, false, null, ER3012PosLbAsrus600.getObjects()),
	R3013_LB601 (3013, "PosLbAsrus601", ReferenceType.keyValue, "", null, false, null, ER3013PosLbAsrus601.getObjects()),
	R3014_LB700 (3014, "PosLbAsrus700", ReferenceType.keyValue, "", null, false, null, ER3014PosLbAsrus700.getObjects()),
	R3015_LB701 (3015, "PosLbAsrus701", ReferenceType.keyValue, "", null, false, null, ER3015PosLbAsrus701.getObjects()),
	R3016_LB110 (3016, "PosLbAsrus110", ReferenceType.keyValue, "", null, false, null, ER3016PosLbAsrus110.getObjects()),
	R3017_LB111 (3017, "PosLbAsrus111", ReferenceType.keyValue, "", null, false, null, ER3017PosLbAsrus111.getObjects()),
	R3018_LB210 (3018, "PosLbAsrus210", ReferenceType.keyValue, "", null, false, null, ER3018PosLbAsrus210.getObjects()),
	R3019_LB211 (3019, "PosLbAsrus211", ReferenceType.keyValue, "", null, false, null, ER3019PosLbAsrus211.getObjects()),
	R3020_LB212 (3020, "PosLbAsrus212", ReferenceType.keyValue, "", null, false, null, ER3020PosLbAsrus212.getObjects()),
	R3021_LB213 (3021, "PosLbAsrus213", ReferenceType.keyValue, "", null, false, null, ER3021PosLbAsrus213.getObjects()),
	R3022_LB214 (3022, "PosLbAsrus214", ReferenceType.keyValue, "", null, false, null, ER3022PosLbAsrus214.getObjects()),
	R3023_LB215 (3023, "PosLbAsrus215", ReferenceType.keyValue, "", null, false, null, ER3023PosLbAsrus215.getObjects()),
	R3024_LB216 (3024, "PosLbAsrus216", ReferenceType.keyValue, "", null, false, null, ER3024PosLbAsrus216.getObjects()),
	R3025_LB217 (3025, "PosLbAsrus217", ReferenceType.keyValue, "", null, false, null, ER3025PosLbAsrus217.getObjects()),
	R3026_LB218 (3026, "PosLbAsrus218", ReferenceType.keyValue, "", null, false, null, ER3026PosLbAsrus218.getObjects()),
	R3027_LB219 (3027, "PosLbAsrus219", ReferenceType.keyValue, "", null, false, null, ER3027PosLbAsrus219.getObjects()),
	R3028_LB220 (3028, "PosLbAsrus220", ReferenceType.keyValue, "", null, false, null, ER3028PosLbAsrus220.getObjects()),
	R3029_LB221 (3029, "PosLbAsrus221", ReferenceType.keyValue, "", null, false, null, ER3029PosLbAsrus221.getObjects()),
	R3030_LB222 (3030, "PosLbAsrus222", ReferenceType.keyValue, "", null, false, null, ER3030PosLbAsrus222.getObjects()),
	R3031_LB223 (3031, "PosLbAsrus223", ReferenceType.keyValue, "", null, false, null, ER3031PosLbAsrus223.getObjects()),
	R3032_LB224 (3032, "PosLbAsrus224", ReferenceType.keyValue, "", null, false, null, ER3032PosLbAsrus224.getObjects()),
	R3033_LB225 (3033, "PosLbAsrus225", ReferenceType.keyValue, "", null, false, null, ER3033PosLbAsrus225.getObjects()),
	R3034_LB226 (3034, "PosLbAsrus226", ReferenceType.keyValue, "", null, false, null, ER3034PosLbAsrus226.getObjects()),
	R3035_LB227 (3035, "PosLbAsrus227", ReferenceType.keyValue, "", null, false, null, ER3035PosLbAsrus227.getObjects()),
	R3036_LB228 (3036, "PosLbAsrus228", ReferenceType.keyValue, "", null, false, null, ER3036PosLbAsrus228.getObjects()),
	R3037_LB229 (3037, "PosLbAsrus229", ReferenceType.keyValue, "", null, false, null, ER3037PosLbAsrus229.getObjects()),
	R3038_LB230 (3038, "PosLbAsrus230", ReferenceType.keyValue, "", null, false, null, ER3038PosLbAsrus230.getObjects()),
	R3039_LB231 (3039, "PosLbAsrus231", ReferenceType.keyValue, "", null, false, null, ER3039PosLbAsrus231.getObjects()),
	R3040_LB232 (3040, "PosLbAsrus232", ReferenceType.keyValue, "", null, false, null, ER3040PosLbAsrus232.getObjects()),
	R3041_LB233 (3041, "PosLbAsrus233", ReferenceType.keyValue, "", null, false, null, ER3041PosLbAsrus233.getObjects()),
	R3042_LB234 (3042, "PosLbAsrus234", ReferenceType.keyValue, "", null, false, null, ER3042PosLbAsrus234.getObjects()),
	R3043_LB235 (3043, "PosLbAsrus235", ReferenceType.keyValue, "", null, false, null, ER3043PosLbAsrus235.getObjects()),
	R3044_LB236 (3044, "PosLbAsrus236", ReferenceType.keyValue, "", null, false, null, ER3044PosLbAsrus236.getObjects()),
	;

	private int number;
	private String name;
	private ReferenceType type;
	private String description;
	private String errorDescription;
	private boolean perSegment;
	private String label1Map;
	private List<KeyValueString> references;

	public String getFileName() {
		StringBuilder res = new StringBuilder("R");
		res.append(number);
		res.append(name);
		res.append(".xml");
		return res.toString();
	}
	
	public String getDescription() {
		return StringUtils.isEmpty(description) ? ("R" + number + name) : description; 
	}
	
	@Override
	public ReferenceMetadata getObject() {
		ReferenceMetadata res = new ReferenceMetadata(number, name, type, getDescription(), errorDescription);
		res.setPerSegment(perSegment);
		res.setLabel1Map(StringUtils.isNotBlank(label1Map) ? CollectionUtil.toMap(label1Map) : null);
		return res;
	}

	public static List<ReferenceMetadata> getObjects() {
		List<ReferenceMetadata> res = new ArrayList<>();
		for (EHeaderMetadataLb eEnum : EHeaderMetadataLb.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static Map<String, List<KeyValueString>> getMap() {
		Map<String, List<KeyValueString>> res = new HashMap<>();
		for (EHeaderMetadataLb eEnum : EHeaderMetadataLb.values()) {
			res.put(eEnum.getFileName(), eEnum.references);
		}
		return res;
	}
}
