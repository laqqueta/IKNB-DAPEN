package id.go.ojk.reass.client.builder.field.lb.reference;

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
	R3000_LB000 (3000, "PosLbReass000", ReferenceType.keyValue, "", null, false, null, ER3000PosLbReass000.getObjects()),
	R3001_LB001 (3001, "PosLbReass001", ReferenceType.keyValue, "", null, false, null, ER3001PosLbReass001.getObjects()),
	R3002_LB002 (3002, "PosLbReass002", ReferenceType.keyValue, "", null, false, null, ER3002PosLbReass002.getObjects()),
	R3003_LB003 (3003, "PosLbReass003", ReferenceType.keyValue, "", null, false, null, ER3003PosLbReass003.getObjects()),
	R3004_LB004 (3004, "PosLbReass004", ReferenceType.keyValue, "", null, false, null, ER3004PosLbReass004.getObjects()),
//	R3005_LB910 (3005, "PosLbReass910", ReferenceType.keyValue, "", null, false, null, ER3005PosLbReass910.getObjects()),
	R3006_LB100 (3006, "PosLbReass100", ReferenceType.keyValue, "", null, false, null, ER3006PosLbReass100.getObjects()),
	R3007_LB200 (3007, "PosLbReass200", ReferenceType.keyValue, "", null, false, null, ER3007PosLbReass200.getObjects()),
	R3008_LB300 (3008, "PosLbReass300", ReferenceType.keyValue, "", null, false, null, ER3008PosLbReass300.getObjects()),
	R3009_LB400 (3009, "PosLbReass400", ReferenceType.keyValue, "", null, false, null, ER3009PosLbReass400.getObjects()),
	R3010_LB500 (3010, "PosLbReass500", ReferenceType.keyValue, "", null, false, null, ER3010PosLbReass500.getObjects()),
	R3011_LB501 (3011, "PosLbReass501", ReferenceType.keyValue, "", null, false, null, ER3011PosLbReass501.getObjects()),
	R3012_LB600 (3012, "PosLbReass600", ReferenceType.keyValue, "", null, false, null, ER3012PosLbReass600.getObjects()),
	R3013_LB601 (3013, "PosLbReass601", ReferenceType.keyValue, "", null, false, null, ER3013PosLbReass601.getObjects()),
	R3014_LB700 (3014, "PosLbReass700", ReferenceType.keyValue, "", null, false, null, ER3014PosLbReass700.getObjects()),
	R3015_LB701 (3015, "PosLbReass701", ReferenceType.keyValue, "", null, false, null, ER3015PosLbReass701.getObjects()),
	R3016_LB110 (3016, "PosLbReass110", ReferenceType.keyValue, "", null, false, null, ER3016PosLbReass110.getObjects()),
	R3017_LB111 (3017, "PosLbReass111", ReferenceType.keyValue, "", null, false, null, ER3017PosLbReass111.getObjects()),
	R3018_LB210 (3018, "PosLbReass210", ReferenceType.keyValue, "", null, false, null, ER3018PosLbReass210.getObjects()),
	R3019_LB211 (3019, "PosLbReass211", ReferenceType.keyValue, "", null, false, null, ER3019PosLbReass211.getObjects()),
	R3020_LB212 (3020, "PosLbReass212", ReferenceType.keyValue, "", null, false, null, ER3020PosLbReass212.getObjects()),
	R3021_LB213 (3021, "PosLbReass213", ReferenceType.keyValue, "", null, false, null, ER3021PosLbReass213.getObjects()),
	R3022_LB214 (3022, "PosLbReass214", ReferenceType.keyValue, "", null, false, null, ER3022PosLbReass214.getObjects()),
	R3023_LB215 (3023, "PosLbReass215", ReferenceType.keyValue, "", null, false, null, ER3023PosLbReass215.getObjects()),
	R3024_LB216 (3024, "PosLbReass216", ReferenceType.keyValue, "", null, false, null, ER3024PosLbReass216.getObjects()),
	R3025_LB217 (3025, "PosLbReass217", ReferenceType.keyValue, "", null, false, null, ER3025PosLbReass217.getObjects()),
	R3026_LB218 (3026, "PosLbReass218", ReferenceType.keyValue, "", null, false, null, ER3026PosLbReass218.getObjects()),
	R3027_LB219 (3027, "PosLbReass219", ReferenceType.keyValue, "", null, false, null, ER3027PosLbReass219.getObjects()),
	R3028_LB220 (3028, "PosLbReass220", ReferenceType.keyValue, "", null, false, null, ER3028PosLbReass220.getObjects()),
	R3029_LB221 (3029, "PosLbReass221", ReferenceType.keyValue, "", null, false, null, ER3029PosLbReass221.getObjects()),
	R3030_LB222 (3030, "PosLbReass222", ReferenceType.keyValue, "", null, false, null, ER3030PosLbReass222.getObjects()),
	R3031_LB223 (3031, "PosLbReass223", ReferenceType.keyValue, "", null, false, null, ER3031PosLbReass223.getObjects()),
	R3032_LB224 (3032, "PosLbReass224", ReferenceType.keyValue, "", null, false, null, ER3032PosLbReass224.getObjects()),
	R3033_LB225 (3033, "PosLbReass225", ReferenceType.keyValue, "", null, false, null, ER3033PosLbReass225.getObjects()),
	R3034_LB226 (3034, "PosLbReass226", ReferenceType.keyValue, "", null, false, null, ER3034PosLbReass226.getObjects()),
	R3035_LB227 (3035, "PosLbReass227", ReferenceType.keyValue, "", null, false, null, ER3035PosLbReass227.getObjects()),
	R3036_LB228 (3036, "PosLbReass228", ReferenceType.keyValue, "", null, false, null, ER3036PosLbReass228.getObjects()),
	R3037_LB229 (3037, "PosLbReass229", ReferenceType.keyValue, "", null, false, null, ER3037PosLbReass229.getObjects()),
	R3038_LB230 (3038, "PosLbReass230", ReferenceType.keyValue, "", null, false, null, ER3038PosLbReass230.getObjects()),
	R3039_LB231 (3039, "PosLbReass231", ReferenceType.keyValue, "", null, false, null, ER3039PosLbReass231.getObjects()),
	R3040_LB232 (3040, "PosLbReass232", ReferenceType.keyValue, "", null, false, null, ER3040PosLbReass232.getObjects()),
	R3041_LB233 (3041, "PosLbReass233", ReferenceType.keyValue, "", null, false, null, ER3041PosLbReass233.getObjects()),
	R3042_LB234 (3042, "PosLbReass234", ReferenceType.keyValue, "", null, false, null, ER3042PosLbReass234.getObjects()),
	R3043_LB235 (3043, "PosLbReass235", ReferenceType.keyValue, "", null, false, null, ER3043PosLbReass235.getObjects()),
	R3044_LB236 (3044, "PosLbReass236", ReferenceType.keyValue, "", null, false, null, ER3044PosLbReass236.getObjects()),
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
