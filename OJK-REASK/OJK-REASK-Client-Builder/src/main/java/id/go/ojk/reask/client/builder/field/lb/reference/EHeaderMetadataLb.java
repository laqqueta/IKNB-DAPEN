package id.go.ojk.reask.client.builder.field.lb.reference;

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
	R3000_LB000 (3000, "PosLbReask000", ReferenceType.keyValue, "", null, false, null, ER3000PosLbReask000.getObjects()),
	R3001_LB001 (3001, "PosLbReask001", ReferenceType.keyValue, "", null, false, null, ER3001PosLbReask001.getObjects()),
	R3002_LB002 (3002, "PosLbReask002", ReferenceType.keyValue, "", null, false, null, ER3002PosLbReask002.getObjects()),
	R3003_LB003 (3003, "PosLbReask003", ReferenceType.keyValue, "", null, false, null, ER3003PosLbReask003.getObjects()),
//	R3004_LB910 (3004, "PosLbReask910", ReferenceType.keyValue, "", null, false, null, ER3004PosLbReask910.getObjects()),
	R3005_LB100 (3005, "PosLbReask100", ReferenceType.keyValue, "", null, false, null, ER3005PosLbReask100.getObjects()),
	R3006_LB200 (3006, "PosLbReask200", ReferenceType.keyValue, "", null, false, null, ER3006PosLbReask200.getObjects()),
	R3007_LB300 (3007, "PosLbReask300", ReferenceType.keyValue, "", null, false, null, ER3007PosLbReask300.getObjects()),
	R3008_LB400 (3008, "PosLbReask400", ReferenceType.keyValue, "", null, false, null, ER3008PosLbReask400.getObjects()),
	R3009_LB500 (3009, "PosLbReask500", ReferenceType.keyValue, "", null, false, null, ER3009PosLbReask500.getObjects()),
	R3010_LB501 (3010, "PosLbReask501", ReferenceType.keyValue, "", null, false, null, ER3010PosLbReask501.getObjects()),
	R3011_LB502 (3011, "PosLbReask502", ReferenceType.keyValue, "", null, false, null, ER3011PosLbReask502.getObjects()),
	R3012_LB503 (3012, "PosLbReask503", ReferenceType.keyValue, "", null, false, null, ER3012PosLbReask503.getObjects()),
	R3013_LB504 (3013, "PosLbReask504", ReferenceType.keyValue, "", null, false, null, ER3013PosLbReask504.getObjects()),
	R3014_LB505 (3014, "PosLbReask505", ReferenceType.keyValue, "", null, false, null, ER3014PosLbReask505.getObjects()),
	R3015_LB506 (3015, "PosLbReask506", ReferenceType.keyValue, "", null, false, null, ER3015PosLbReask506.getObjects()),
	R3016_LB507 (3016, "PosLbReask507", ReferenceType.keyValue, "", null, false, null, ER3016PosLbReask507.getObjects()),
	R3017_LB508 (3017, "PosLbReask508", ReferenceType.keyValue, "", null, false, null, ER3017PosLbReask508.getObjects()),
	R3018_LB101 (3018, "PosLbReask101", ReferenceType.keyValue, "", null, false, null, ER3018PosLbReask101.getObjects()),
	R3019_LB102 (3019, "PosLbReask102", ReferenceType.keyValue, "", null, false, null, ER3019PosLbReask102.getObjects()),
	R3020_LB103 (3020, "PosLbReask103", ReferenceType.keyValue, "", null, false, null, ER3020PosLbReask103.getObjects()),
	R3021_LB104 (3021, "PosLbReask104", ReferenceType.keyValue, "", null, false, null, ER3021PosLbReask104.getObjects()),
	R3022_LB105 (3022, "PosLbReask105", ReferenceType.keyValue, "", null, false, null, ER3022PosLbReask105.getObjects()),
	R3023_LB106 (3023, "PosLbReask106", ReferenceType.keyValue, "", null, false, null, ER3023PosLbReask106.getObjects()),
	R3024_LB107 (3024, "PosLbReask107", ReferenceType.keyValue, "", null, false, null, ER3024PosLbReask107.getObjects()),
	R3025_LB108 (3025, "PosLbReask108", ReferenceType.keyValue, "", null, false, null, ER3025PosLbReask108.getObjects()),
	R3026_LB109 (3026, "PosLbReask109", ReferenceType.keyValue, "", null, false, null, ER3026PosLbReask109.getObjects()),
	R3027_LB110 (3027, "PosLbReask110", ReferenceType.keyValue, "", null, false, null, ER3027PosLbReask110.getObjects()),
	R3028_LB111 (3028, "PosLbReask111", ReferenceType.keyValue, "", null, false, null, ER3028PosLbReask111.getObjects()),
	R3029_LB113 (3029, "PosLbReask113", ReferenceType.keyValue, "", null, false, null, ER3029PosLbReask113.getObjects()),
	R3030_LB114 (3030, "PosLbReask114", ReferenceType.keyValue, "", null, false, null, ER3030PosLbReask114.getObjects()),
	R3031_LB201 (3031, "PosLbReask201", ReferenceType.keyValue, "", null, false, null, ER3031PosLbReask201.getObjects()),
	R3032_LB123 (3032, "PosLbReask123", ReferenceType.keyValue, "", null, false, null, ER3032PosLbReask123.getObjects()),
	R3033_LB202 (3033, "PosLbReask202", ReferenceType.keyValue, "", null, false, null, ER3033PosLbReask202.getObjects()),
	R3034_LB203 (3034, "PosLbReask203", ReferenceType.keyValue, "", null, false, null, ER3034PosLbReask203.getObjects()),
	R3035_LB204 (3035, "PosLbReask204", ReferenceType.keyValue, "", null, false, null, ER3035PosLbReask204.getObjects()),
	R3036_LB205 (3036, "PosLbReask205", ReferenceType.keyValue, "", null, false, null, ER3036PosLbReask205.getObjects()),
	R3037_LB206 (3037, "PosLbReask206", ReferenceType.keyValue, "", null, false, null, ER3037PosLbReask206.getObjects()),
	R3038_LB207 (3038, "PosLbReask207", ReferenceType.keyValue, "", null, false, null, ER3038PosLbReask207.getObjects()),
	R3039_LB208 (3039, "PosLbReask208", ReferenceType.keyValue, "", null, false, null, ER3039PosLbReask208.getObjects()),
	R3040_LB115 (3040, "PosLbReask115", ReferenceType.keyValue, "", null, false, null, ER3040PosLbReask115.getObjects()),
	R3041_LB116 (3041, "PosLbReask116", ReferenceType.keyValue, "", null, false, null, ER3041PosLbReask116.getObjects()),
	R3042_LB209 (3042, "PosLbReask209", ReferenceType.keyValue, "", null, false, null, ER3042PosLbReask209.getObjects()),
	R3043_LB117 (3043, "PosLbReask117", ReferenceType.keyValue, "", null, false, null, ER3043PosLbReask117.getObjects()),
	R3044_LB118 (3044, "PosLbReask118", ReferenceType.keyValue, "", null, false, null, ER3044PosLbReask118.getObjects()),
	R3045_LB210 (3045, "PosLbReask210", ReferenceType.keyValue, "", null, false, null, ER3045PosLbReask210.getObjects()),
	R3046_LB211 (3046, "PosLbReask211", ReferenceType.keyValue, "", null, false, null, ER3046PosLbReask211.getObjects()),
	R3047_LB220 (3047, "PosLbReask220", ReferenceType.keyValue, "", null, false, null, ER3047PosLbReask220.getObjects()),
	R3048_LB212 (3048, "PosLbReask212", ReferenceType.keyValue, "", null, false, null, ER3048PosLbReask212.getObjects()),
	R3049_LB213 (3049, "PosLbReask213", ReferenceType.keyValue, "", null, false, null, ER3049PosLbReask213.getObjects()),
	R3050_LB601 (3050, "PosLbReask601", ReferenceType.keyValue, "", null, false, null, ER3050PosLbReask601.getObjects()),
	R3051_LB214 (3051, "PosLbReask214", ReferenceType.keyValue, "", null, false, null, ER3051PosLbReask214.getObjects()),
	R3052_LB215 (3052, "PosLbReask215", ReferenceType.keyValue, "", null, false, null, ER3052PosLbReask215.getObjects()),
	R3053_LB216 (3053, "PosLbReask216", ReferenceType.keyValue, "", null, false, null, ER3053PosLbReask216.getObjects()),
	R3054_LB602 (3054, "PosLbReask602", ReferenceType.keyValue, "", null, false, null, ER3054PosLbReask602.getObjects()),
	R3055_LB603 (3055, "PosLbReask603", ReferenceType.keyValue, "", null, false, null, ER3055PosLbReask603.getObjects()),
	R3056_LB604 (3056, "PosLbReask604", ReferenceType.keyValue, "", null, false, null, ER3056PosLbReask604.getObjects()),
	R3057_LB619 (3057, "PosLbReask619", ReferenceType.keyValue, "", null, false, null, ER3057PosLbReask619.getObjects()),
	R3058_LB119 (3058, "PosLbReask119", ReferenceType.keyValue, "", null, false, null, ER3058PosLbReask119.getObjects()),
	R3059_LB620 (3059, "PosLbReask620", ReferenceType.keyValue, "", null, false, null, ER3059PosLbReask620.getObjects()),
	R3060_LB120 (3060, "PosLbReask120", ReferenceType.keyValue, "", null, false, null, ER3060PosLbReask120.getObjects()),
	R3061_LB121 (3061, "PosLbReask121", ReferenceType.keyValue, "", null, false, null, ER3061PosLbReask121.getObjects()),
	R3062_LB122 (3062, "PosLbReask122", ReferenceType.keyValue, "", null, false, null, ER3062PosLbReask122.getObjects()),
	R3063_LB621 (3063, "PosLbReask621", ReferenceType.keyValue, "", null, false, null, ER3063PosLbReask621.getObjects()),
	R3064_LB622 (3064, "PosLbReask622", ReferenceType.keyValue, "", null, false, null, ER3064PosLbReask622.getObjects()),
	R3065_LB623 (3065, "PosLbReask623", ReferenceType.keyValue, "", null, false, null, ER3065PosLbReask623.getObjects()),
	R3066_LB624 (3066, "PosLbReask624", ReferenceType.keyValue, "", null, false, null, ER3066PosLbReask624.getObjects()),
	R3067_LB625 (3067, "PosLbReask625", ReferenceType.keyValue, "", null, false, null, ER3067PosLbReask625.getObjects()),
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
