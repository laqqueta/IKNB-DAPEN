package id.go.ojk.asruk.client.builder.field.lb.reference;

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
	R3000_LB000 (3000, "PosLbAsruk000", ReferenceType.keyValue, "", null, false, null, ER3000PosLbAsruk000.getObjects()),
	R3001_LB001 (3001, "PosLbAsruk001", ReferenceType.keyValue, "", null, false, null, ER3001PosLbAsruk001.getObjects()),
	R3002_LB002 (3002, "PosLbAsruk002", ReferenceType.keyValue, "", null, false, null, ER3002PosLbAsruk002.getObjects()),
	R3003_LB003 (3003, "PosLbAsruk003", ReferenceType.keyValue, "", null, false, null, ER3003PosLbAsruk003.getObjects()),
//	R3004_LB910 (3004, "PosLbAsruk910", ReferenceType.keyValue, "", null, false, null, ER3004PosLbAsruk910.getObjects()),
	R3005_LB100 (3005, "PosLbAsruk100", ReferenceType.keyValue, "", null, false, null, ER3005PosLbAsruk100.getObjects()),
	R3006_LB200 (3006, "PosLbAsruk200", ReferenceType.keyValue, "", null, false, null, ER3006PosLbAsruk200.getObjects()),
	R3007_LB300 (3007, "PosLbAsruk300", ReferenceType.keyValue, "", null, false, null, ER3007PosLbAsruk300.getObjects()),
	R3008_LB400 (3008, "PosLbAsruk400", ReferenceType.keyValue, "", null, false, null, ER3008PosLbAsruk400.getObjects()),
	R3009_LB500 (3009, "PosLbAsruk500", ReferenceType.keyValue, "", null, false, null, ER3009PosLbAsruk500.getObjects()),
	R3010_LB501 (3010, "PosLbAsruk501", ReferenceType.keyValue, "", null, false, null, ER3010PosLbAsruk501.getObjects()),
	R3011_LB502 (3011, "PosLbAsruk502", ReferenceType.keyValue, "", null, false, null, ER3011PosLbAsruk502.getObjects()),
	R3012_LB503 (3012, "PosLbAsruk503", ReferenceType.keyValue, "", null, false, null, ER3012PosLbAsruk503.getObjects()),
	R3013_LB504 (3013, "PosLbAsruk504", ReferenceType.keyValue, "", null, false, null, ER3013PosLbAsruk504.getObjects()),
	R3014_LB505 (3014, "PosLbAsruk505", ReferenceType.keyValue, "", null, false, null, ER3014PosLbAsruk505.getObjects()),
	R3015_LB506 (3015, "PosLbAsruk506", ReferenceType.keyValue, "", null, false, null, ER3015PosLbAsruk506.getObjects()),
	R3016_LB507 (3016, "PosLbAsruk507", ReferenceType.keyValue, "", null, false, null, ER3016PosLbAsruk507.getObjects()),
	R3017_LB508 (3017, "PosLbAsruk508", ReferenceType.keyValue, "", null, false, null, ER3017PosLbAsruk508.getObjects()),
	R3018_LB101 (3018, "PosLbAsruk101", ReferenceType.keyValue, "", null, false, null, ER3018PosLbAsruk101.getObjects()),
	R3019_LB102 (3019, "PosLbAsruk102", ReferenceType.keyValue, "", null, false, null, ER3019PosLbAsruk102.getObjects()),
	R3020_LB103 (3020, "PosLbAsruk103", ReferenceType.keyValue, "", null, false, null, ER3020PosLbAsruk103.getObjects()),
	R3021_LB104 (3021, "PosLbAsruk104", ReferenceType.keyValue, "", null, false, null, ER3021PosLbAsruk104.getObjects()),
	R3022_LB105 (3022, "PosLbAsruk105", ReferenceType.keyValue, "", null, false, null, ER3022PosLbAsruk105.getObjects()),
	R3023_LB106 (3023, "PosLbAsruk106", ReferenceType.keyValue, "", null, false, null, ER3023PosLbAsruk106.getObjects()),
	R3024_LB107 (3024, "PosLbAsruk107", ReferenceType.keyValue, "", null, false, null, ER3024PosLbAsruk107.getObjects()),
	R3025_LB108 (3025, "PosLbAsruk108", ReferenceType.keyValue, "", null, false, null, ER3025PosLbAsruk108.getObjects()),
	R3026_LB109 (3026, "PosLbAsruk109", ReferenceType.keyValue, "", null, false, null, ER3026PosLbAsruk109.getObjects()),
	R3027_LB110 (3027, "PosLbAsruk110", ReferenceType.keyValue, "", null, false, null, ER3027PosLbAsruk110.getObjects()),
	R3028_LB111 (3028, "PosLbAsruk111", ReferenceType.keyValue, "", null, false, null, ER3028PosLbAsruk111.getObjects()),
	R3029_LB113 (3029, "PosLbAsruk113", ReferenceType.keyValue, "", null, false, null, ER3029PosLbAsruk113.getObjects()),
	R3030_LB114 (3030, "PosLbAsruk114", ReferenceType.keyValue, "", null, false, null, ER3030PosLbAsruk114.getObjects()),
	R3031_LB201 (3031, "PosLbAsruk201", ReferenceType.keyValue, "", null, false, null, ER3031PosLbAsruk201.getObjects()),
	R3032_LB123 (3032, "PosLbAsruk123", ReferenceType.keyValue, "", null, false, null, ER3032PosLbAsruk123.getObjects()),
	R3033_LB202 (3033, "PosLbAsruk202", ReferenceType.keyValue, "", null, false, null, ER3033PosLbAsruk202.getObjects()),
	R3034_LB203 (3034, "PosLbAsruk203", ReferenceType.keyValue, "", null, false, null, ER3034PosLbAsruk203.getObjects()),
	R3035_LB204 (3035, "PosLbAsruk204", ReferenceType.keyValue, "", null, false, null, ER3035PosLbAsruk204.getObjects()),
	R3036_LB205 (3036, "PosLbAsruk205", ReferenceType.keyValue, "", null, false, null, ER3036PosLbAsruk205.getObjects()),
	R3037_LB206 (3037, "PosLbAsruk206", ReferenceType.keyValue, "", null, false, null, ER3037PosLbAsruk206.getObjects()),
	R3038_LB207 (3038, "PosLbAsruk207", ReferenceType.keyValue, "", null, false, null, ER3038PosLbAsruk207.getObjects()),
	R3039_LB208 (3039, "PosLbAsruk208", ReferenceType.keyValue, "", null, false, null, ER3039PosLbAsruk208.getObjects()),
	R3040_LB115 (3040, "PosLbAsruk115", ReferenceType.keyValue, "", null, false, null, ER3040PosLbAsruk115.getObjects()),
	R3041_LB116 (3041, "PosLbAsruk116", ReferenceType.keyValue, "", null, false, null, ER3041PosLbAsruk116.getObjects()),
	R3042_LB209 (3042, "PosLbAsruk209", ReferenceType.keyValue, "", null, false, null, ER3042PosLbAsruk209.getObjects()),
	R3043_LB117 (3043, "PosLbAsruk117", ReferenceType.keyValue, "", null, false, null, ER3043PosLbAsruk117.getObjects()),
	R3044_LB118 (3044, "PosLbAsruk118", ReferenceType.keyValue, "", null, false, null, ER3044PosLbAsruk118.getObjects()),
	R3045_LB210 (3045, "PosLbAsruk210", ReferenceType.keyValue, "", null, false, null, ER3045PosLbAsruk210.getObjects()),
	R3046_LB211 (3046, "PosLbAsruk211", ReferenceType.keyValue, "", null, false, null, ER3046PosLbAsruk211.getObjects()),
	R3047_LB220 (3047, "PosLbAsruk220", ReferenceType.keyValue, "", null, false, null, ER3047PosLbAsruk220.getObjects()),
	R3048_LB212 (3048, "PosLbAsruk212", ReferenceType.keyValue, "", null, false, null, ER3048PosLbAsruk212.getObjects()),
	R3049_LB213 (3049, "PosLbAsruk213", ReferenceType.keyValue, "", null, false, null, ER3049PosLbAsruk213.getObjects()),
	R3050_LB601 (3050, "PosLbAsruk601", ReferenceType.keyValue, "", null, false, null, ER3050PosLbAsruk601.getObjects()),
	R3051_LB214 (3051, "PosLbAsruk214", ReferenceType.keyValue, "", null, false, null, ER3051PosLbAsruk214.getObjects()),
	R3052_LB215 (3052, "PosLbAsruk215", ReferenceType.keyValue, "", null, false, null, ER3052PosLbAsruk215.getObjects()),
	R3053_LB216 (3053, "PosLbAsruk216", ReferenceType.keyValue, "", null, false, null, ER3053PosLbAsruk216.getObjects()),
	R3054_LB602 (3054, "PosLbAsruk602", ReferenceType.keyValue, "", null, false, null, ER3054PosLbAsruk602.getObjects()),
	R3055_LB603 (3055, "PosLbAsruk603", ReferenceType.keyValue, "", null, false, null, ER3055PosLbAsruk603.getObjects()),
	R3056_LB604 (3056, "PosLbAsruk604", ReferenceType.keyValue, "", null, false, null, ER3056PosLbAsruk604.getObjects()),
	R3057_LB619 (3057, "PosLbAsruk619", ReferenceType.keyValue, "", null, false, null, ER3057PosLbAsruk619.getObjects()),
	R3058_LB119 (3058, "PosLbAsruk119", ReferenceType.keyValue, "", null, false, null, ER3058PosLbAsruk119.getObjects()),
	R3059_LB620 (3059, "PosLbAsruk620", ReferenceType.keyValue, "", null, false, null, ER3059PosLbAsruk620.getObjects()),
	R3060_LB120 (3060, "PosLbAsruk120", ReferenceType.keyValue, "", null, false, null, ER3060PosLbAsruk120.getObjects()),
	R3061_LB121 (3061, "PosLbAsruk121", ReferenceType.keyValue, "", null, false, null, ER3061PosLbAsruk121.getObjects()),
	R3062_LB122 (3062, "PosLbAsruk122", ReferenceType.keyValue, "", null, false, null, ER3062PosLbAsruk122.getObjects()),
	R3063_LB621 (3063, "PosLbAsruk621", ReferenceType.keyValue, "", null, false, null, ER3063PosLbAsruk621.getObjects()),
	R3064_LB622 (3064, "PosLbAsruk622", ReferenceType.keyValue, "", null, false, null, ER3064PosLbAsruk622.getObjects()),
	R3065_LB623 (3065, "PosLbAsruk623", ReferenceType.keyValue, "", null, false, null, ER3065PosLbAsruk623.getObjects()),
	R3066_LB624 (3066, "PosLbAsruk624", ReferenceType.keyValue, "", null, false, null, ER3066PosLbAsruk624.getObjects()),
	R3067_LB625 (3067, "PosLbAsruk625", ReferenceType.keyValue, "", null, false, null, ER3067PosLbAsruk625.getObjects()),
	;

	private int number;
	private String name;
	private ReferenceType type;
	private String description;
	private String errorDescription;
	private boolean perSegment;
	private String label1Map;
	private List<KeyValueString> references;
	
	public String getDescription() {
		return StringUtils.isEmpty(description) ? ("R" + number + name) : description; 
	}

	public String getFileName() {
		StringBuilder res = new StringBuilder("R");
		res.append(number);
		res.append(name);
		res.append(".xml");
		return res.toString();
	}
	
	@Override
	public ReferenceMetadata getObject() {
		ReferenceMetadata res = new ReferenceMetadata(number, name, type, getDescription(), errorDescription);
		res.setPerSegment(perSegment);
		res.setLabel1Map(StringUtils.isNotBlank(label1Map) ? CollectionUtil.toMap(label1Map) : null);
		return res;
	}

	public static Map<String, List<KeyValueString>> getMap() {
		Map<String, List<KeyValueString>> res = new HashMap<>();
		for (EHeaderMetadataLb eEnum : EHeaderMetadataLb.values()) {
			res.put(eEnum.getFileName(), eEnum.references);
		}
		return res;
	}
	public static List<ReferenceMetadata> getObjects() {
		List<ReferenceMetadata> res = new ArrayList<>();
		for (EHeaderMetadataLb eEnum : EHeaderMetadataLb.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
}
