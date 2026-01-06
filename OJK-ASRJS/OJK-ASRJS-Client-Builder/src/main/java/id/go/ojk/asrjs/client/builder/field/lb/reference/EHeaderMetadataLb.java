package id.go.ojk.asrjs.client.builder.field.lb.reference;

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
	R3000_LB000 (3000, "PosLbAsrjs000", ReferenceType.keyValue, "", null, false, null, ER3000PosLbAsrjs000.getObjects()),
	R3001_LB001 (3001, "PosLbAsrjs001", ReferenceType.keyValue, "", null, false, null, ER3001PosLbAsrjs001.getObjects()),
	R3002_LB002 (3002, "PosLbAsrjs002", ReferenceType.keyValue, "", null, false, null, ER3002PosLbAsrjs002.getObjects()),
	R3003_LB003 (3003, "PosLbAsrjs003", ReferenceType.keyValue, "", null, false, null, ER3003PosLbAsrjs003.getObjects()),
	R3004_LB004 (3004, "PosLbAsrjs004", ReferenceType.keyValue, "", null, false, null, ER3004PosLbAsrjs004.getObjects()),
//	R3005_LB910 (3005, "PosLbAsrjs910", ReferenceType.keyValue, "", null, false, null, ER3005PosLbAsrjs910.getObjects()),
	R3006_LB100 (3006, "PosLbAsrjs100", ReferenceType.keyValue, "", null, false, null, ER3006PosLbAsrjs100.getObjects()),
	R3007_LB200 (3007, "PosLbAsrjs200", ReferenceType.keyValue, "", null, false, null, ER3007PosLbAsrjs200.getObjects()),
	R3008_LB300 (3008, "PosLbAsrjs300", ReferenceType.keyValue, "", null, false, null, ER3008PosLbAsrjs300.getObjects()),
	R3009_LB400 (3009, "PosLbAsrjs400", ReferenceType.keyValue, "", null, false, null, ER3009PosLbAsrjs400.getObjects()),
	R3010_LB500 (3010, "PosLbAsrjs500", ReferenceType.keyValue, "", null, false, null, ER3010PosLbAsrjs500.getObjects()),
	R3011_LB501 (3011, "PosLbAsrjs501", ReferenceType.keyValue, "", null, false, null, ER3011PosLbAsrjs501.getObjects()),
	R3012_LB600 (3012, "PosLbAsrjs600", ReferenceType.keyValue, "", null, false, null, ER3012PosLbAsrjs600.getObjects()),
	R3013_LB601 (3013, "PosLbAsrjs601", ReferenceType.keyValue, "", null, false, null, ER3013PosLbAsrjs601.getObjects()),
	R3014_LB700 (3014, "PosLbAsrjs700", ReferenceType.keyValue, "", null, false, null, ER3014PosLbAsrjs700.getObjects()),
	R3015_LB701 (3015, "PosLbAsrjs701", ReferenceType.keyValue, "", null, false, null, ER3015PosLbAsrjs701.getObjects()),
	R3016_LB110 (3016, "PosLbAsrjs110", ReferenceType.keyValue, "", null, false, null, ER3016PosLbAsrjs110.getObjects()),
	R3017_LB111 (3017, "PosLbAsrjs111", ReferenceType.keyValue, "", null, false, null, ER3017PosLbAsrjs111.getObjects()),
	R3018_LB210 (3018, "PosLbAsrjs210", ReferenceType.keyValue, "", null, false, null, ER3018PosLbAsrjs210.getObjects()),
	R3019_LB211 (3019, "PosLbAsrjs211", ReferenceType.keyValue, "", null, false, null, ER3019PosLbAsrjs211.getObjects()),
	R3020_LB212 (3020, "PosLbAsrjs212", ReferenceType.keyValue, "", null, false, null, ER3020PosLbAsrjs212.getObjects()),
	R3021_LB213 (3021, "PosLbAsrjs213", ReferenceType.keyValue, "", null, false, null, ER3021PosLbAsrjs213.getObjects()),
	R3022_LB214 (3022, "PosLbAsrjs214", ReferenceType.keyValue, "", null, false, null, ER3022PosLbAsrjs214.getObjects()),
	R3023_LB215 (3023, "PosLbAsrjs215", ReferenceType.keyValue, "", null, false, null, ER3023PosLbAsrjs215.getObjects()),
	R3024_LB216 (3024, "PosLbAsrjs216", ReferenceType.keyValue, "", null, false, null, ER3024PosLbAsrjs216.getObjects()),
	R3025_LB217 (3025, "PosLbAsrjs217", ReferenceType.keyValue, "", null, false, null, ER3025PosLbAsrjs217.getObjects()),
	R3026_LB218 (3026, "PosLbAsrjs218", ReferenceType.keyValue, "", null, false, null, ER3026PosLbAsrjs218.getObjects()),
	R3027_LB219 (3027, "PosLbAsrjs219", ReferenceType.keyValue, "", null, false, null, ER3027PosLbAsrjs219.getObjects()),
	R3028_LB220 (3028, "PosLbAsrjs220", ReferenceType.keyValue, "", null, false, null, ER3028PosLbAsrjs220.getObjects()),
	R3029_LB221 (3029, "PosLbAsrjs221", ReferenceType.keyValue, "", null, false, null, ER3029PosLbAsrjs221.getObjects()),
	R3030_LB222 (3030, "PosLbAsrjs222", ReferenceType.keyValue, "", null, false, null, ER3030PosLbAsrjs222.getObjects()),
	R3031_LB223 (3031, "PosLbAsrjs223", ReferenceType.keyValue, "", null, false, null, ER3031PosLbAsrjs223.getObjects()),
	R3032_LB224 (3032, "PosLbAsrjs224", ReferenceType.keyValue, "", null, false, null, ER3032PosLbAsrjs224.getObjects()),
	R3033_LB225 (3033, "PosLbAsrjs225", ReferenceType.keyValue, "", null, false, null, ER3033PosLbAsrjs225.getObjects()),
	R3034_LB226 (3034, "PosLbAsrjs226", ReferenceType.keyValue, "", null, false, null, ER3034PosLbAsrjs226.getObjects()),
	R3035_LB227 (3035, "PosLbAsrjs227", ReferenceType.keyValue, "", null, false, null, ER3035PosLbAsrjs227.getObjects()),
	R3036_LB228 (3036, "PosLbAsrjs228", ReferenceType.keyValue, "", null, false, null, ER3036PosLbAsrjs228.getObjects()),
	R3037_LB232 (3037, "PosLbAsrjs232", ReferenceType.keyValue, "", null, false, null, ER3037PosLbAsrjs232.getObjects()),
	R3038_LB229 (3038, "PosLbAsrjs229", ReferenceType.keyValue, "", null, false, null, ER3038PosLbAsrjs229.getObjects()),
	R3039_LB230 (3039, "PosLbAsrjs230", ReferenceType.keyValue, "", null, false, null, ER3039PosLbAsrjs230.getObjects()),
	R3040_LB231 (3040, "PosLbAsrjs231", ReferenceType.keyValue, "", null, false, null, ER3040PosLbAsrjs231.getObjects()),
	R3041_LB233 (3041, "PosLbAsrjs233", ReferenceType.keyValue, "", null, false, null, ER3041PosLbAsrjs233.getObjects()),
	R3042_LB234 (3042, "PosLbAsrjs234", ReferenceType.keyValue, "", null, false, null, ER3042PosLbAsrjs234.getObjects()),
	R3043_LB604 (3043, "PosLbAsrjs604", ReferenceType.keyValue, "", null, false, null, ER3043PosLbAsrjs604.getObjects()),
	R3044_LB605 (3044, "PosLbAsrjs605", ReferenceType.keyValue, "", null, false, null, ER3044PosLbAsrjs605.getObjects()),
	R3045_LB606 (3045, "PosLbAsrjs606", ReferenceType.keyValue, "", null, false, null, ER3045PosLbAsrjs606.getObjects()),
	R3046_LB607 (3046, "PosLbAsrjs607", ReferenceType.keyValue, "", null, false, null, ER3046PosLbAsrjs607.getObjects()),
	R3047_LB608 (3047, "PosLbAsrjs608", ReferenceType.keyValue, "", null, false, null, ER3047PosLbAsrjs608.getObjects()),
	R3048_LB609 (3048, "PosLbAsrjs609", ReferenceType.keyValue, "", null, false, null, ER3048PosLbAsrjs609.getObjects()),
	R3049_LB610 (3049, "PosLbAsrjs610", ReferenceType.keyValue, "", null, false, null, ER3049PosLbAsrjs610.getObjects()),
	R3050_LB616 (3050, "PosLbAsrjs616", ReferenceType.keyValue, "", null, false, null, ER3050PosLbAsrjs616.getObjects()),
	R3051_LB235 (3051, "PosLbAsrjs235", ReferenceType.keyValue, "", null, false, null, ER3051PosLbAsrjs235.getObjects()),
	R3052_LB236 (3052, "PosLbAsrjs236", ReferenceType.keyValue, "", null, false, null, ER3052PosLbAsrjs236.getObjects()),
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
