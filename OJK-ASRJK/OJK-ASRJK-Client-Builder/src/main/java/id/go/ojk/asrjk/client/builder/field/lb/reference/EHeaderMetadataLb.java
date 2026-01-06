package id.go.ojk.asrjk.client.builder.field.lb.reference;

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
public enum EHeaderMetadataLb implements IObject<ReferenceMetadata> {
	R3000_LB000 (ER3000PosLbAsrjk000.getRefNumber(), ER3000PosLbAsrjk000.getName(), ER3000PosLbAsrjk000.getObjects()),
	R3001_LB001 (ER3001PosLbAsrjk001.getRefNumber(), ER3001PosLbAsrjk001.getName(), ER3001PosLbAsrjk001.getObjects()),
	R3002_LB002 (ER3002PosLbAsrjk002.getRefNumber(), ER3002PosLbAsrjk002.getName(), ER3002PosLbAsrjk002.getObjects()),
	R3003_LB003 (ER3003PosLbAsrjk003.getRefNumber(), ER3003PosLbAsrjk003.getName(), ER3003PosLbAsrjk003.getObjects()),
//	R3004_LB910 (ER3004PosLbAsrjk910.getRefNumber(), ER3004PosLbAsrjk910.getName(), ER3004PosLbAsrjk910.getObjects()),
	R3005_LB100 (ER3005PosLbAsrjk100.getRefNumber(), ER3005PosLbAsrjk100.getName(), ER3005PosLbAsrjk100.getObjects()),
	R3006_LB200 (ER3006PosLbAsrjk200.getRefNumber(), ER3006PosLbAsrjk200.getName(), ER3006PosLbAsrjk200.getObjects()),
	R3007_LB300 (ER3007PosLbAsrjk300.getRefNumber(), ER3007PosLbAsrjk300.getName(), ER3007PosLbAsrjk300.getObjects()),
	R3008_LB400 (ER3008PosLbAsrjk400.getRefNumber(), ER3008PosLbAsrjk400.getName(), ER3008PosLbAsrjk400.getObjects()),
	R3009_LB500 (ER3009PosLbAsrjk500.getRefNumber(), ER3009PosLbAsrjk500.getName(), ER3009PosLbAsrjk500.getObjects()),
	R3010_LB501 (ER3010PosLbAsrjk501.getRefNumber(), ER3010PosLbAsrjk501.getName(), ER3010PosLbAsrjk501.getObjects()),
	R3011_LB502 (ER3011PosLbAsrjk502.getRefNumber(), ER3011PosLbAsrjk502.getName(), ER3011PosLbAsrjk502.getObjects()),
	R3012_LB503 (ER3012PosLbAsrjk503.getRefNumber(), ER3012PosLbAsrjk503.getName(), ER3012PosLbAsrjk503.getObjects()),
	R3013_LB504 (ER3013PosLbAsrjk504.getRefNumber(), ER3013PosLbAsrjk504.getName(), ER3013PosLbAsrjk504.getObjects()),
	R3014_LB505 (ER3014PosLbAsrjk505.getRefNumber(), ER3014PosLbAsrjk505.getName(), ER3014PosLbAsrjk505.getObjects()),
	R3015_LB506 (ER3015PosLbAsrjk506.getRefNumber(), ER3015PosLbAsrjk506.getName(), ER3015PosLbAsrjk506.getObjects()),
	R3016_LB507 (ER3016PosLbAsrjk507.getRefNumber(), ER3016PosLbAsrjk507.getName(), ER3016PosLbAsrjk507.getObjects()),
	R3017_LB508 (ER3017PosLbAsrjk508.getRefNumber(), ER3017PosLbAsrjk508.getName(), ER3017PosLbAsrjk508.getObjects()),
	R3018_LB101 (ER3018PosLbAsrjk101.getRefNumber(), ER3018PosLbAsrjk101.getName(), ER3018PosLbAsrjk101.getObjects()),
	R3019_LB102 (ER3019PosLbAsrjk102.getRefNumber(), ER3019PosLbAsrjk102.getName(), ER3019PosLbAsrjk102.getObjects()),
	R3020_LB103 (ER3020PosLbAsrjk103.getRefNumber(), ER3020PosLbAsrjk103.getName(), ER3020PosLbAsrjk103.getObjects()),
	R3021_LB104 (ER3021PosLbAsrjk104.getRefNumber(), ER3021PosLbAsrjk104.getName(), ER3021PosLbAsrjk104.getObjects()),
	R3022_LB105 (ER3022PosLbAsrjk105.getRefNumber(), ER3022PosLbAsrjk105.getName(), ER3022PosLbAsrjk105.getObjects()),
	R3023_LB106 (ER3023PosLbAsrjk106.getRefNumber(), ER3023PosLbAsrjk106.getName(), ER3023PosLbAsrjk106.getObjects()),
	R3024_LB107 (ER3024PosLbAsrjk107.getRefNumber(), ER3024PosLbAsrjk107.getName(), ER3024PosLbAsrjk107.getObjects()),
	R3025_LB108 (ER3025PosLbAsrjk108.getRefNumber(), ER3025PosLbAsrjk108.getName(), ER3025PosLbAsrjk108.getObjects()),
	R3026_LB109 (ER3026PosLbAsrjk109.getRefNumber(), ER3026PosLbAsrjk109.getName(), ER3026PosLbAsrjk109.getObjects()),
	R3027_LB110 (ER3027PosLbAsrjk110.getRefNumber(), ER3027PosLbAsrjk110.getName(), ER3027PosLbAsrjk110.getObjects()),
	R3028_LB111 (ER3028PosLbAsrjk111.getRefNumber(), ER3028PosLbAsrjk111.getName(), ER3028PosLbAsrjk111.getObjects()),
	R3029_LB112 (ER3029PosLbAsrjk112.getRefNumber(), ER3029PosLbAsrjk112.getName(), ER3029PosLbAsrjk112.getObjects()),
	R3030_LB113 (ER3030PosLbAsrjk113.getRefNumber(), ER3030PosLbAsrjk113.getName(), ER3030PosLbAsrjk113.getObjects()),
	R3031_LB114 (ER3031PosLbAsrjk114.getRefNumber(), ER3031PosLbAsrjk114.getName(), ER3031PosLbAsrjk114.getObjects()),
	R3032_LB201 (ER3032PosLbAsrjk201.getRefNumber(), ER3032PosLbAsrjk201.getName(), ER3032PosLbAsrjk201.getObjects()),
	R3033_LB202 (ER3033PosLbAsrjk202.getRefNumber(), ER3033PosLbAsrjk202.getName(), ER3033PosLbAsrjk202.getObjects()),
	R3034_LB203 (ER3034PosLbAsrjk203.getRefNumber(), ER3034PosLbAsrjk203.getName(), ER3034PosLbAsrjk203.getObjects()),
	R3035_LB204 (ER3035PosLbAsrjk204.getRefNumber(), ER3035PosLbAsrjk204.getName(), ER3035PosLbAsrjk204.getObjects()),
	R3036_LB205 (ER3036PosLbAsrjk205.getRefNumber(), ER3036PosLbAsrjk205.getName(), ER3036PosLbAsrjk205.getObjects()),
	R3037_LB206 (ER3037PosLbAsrjk206.getRefNumber(), ER3037PosLbAsrjk206.getName(), ER3037PosLbAsrjk206.getObjects()),
	R3038_LB115 (ER3038PosLbAsrjk115.getRefNumber(), ER3038PosLbAsrjk115.getName(), ER3038PosLbAsrjk115.getObjects()),
	R3039_LB117 (ER3039PosLbAsrjk117.getRefNumber(), ER3039PosLbAsrjk117.getName(), ER3039PosLbAsrjk117.getObjects()),
	R3040_LB118 (ER3040PosLbAsrjk118.getRefNumber(), ER3040PosLbAsrjk118.getName(), ER3040PosLbAsrjk118.getObjects()),
	R3041_LB207 (ER3041PosLbAsrjk207.getRefNumber(), ER3041PosLbAsrjk207.getName(), ER3041PosLbAsrjk207.getObjects()),
	R3042_LB208 (ER3042PosLbAsrjk208.getRefNumber(), ER3042PosLbAsrjk208.getName(), ER3042PosLbAsrjk208.getObjects()),
	R3043_LB209 (ER3043PosLbAsrjk209.getRefNumber(), ER3043PosLbAsrjk209.getName(), ER3043PosLbAsrjk209.getObjects()),
	R3044_LB210 (ER3044PosLbAsrjk210.getRefNumber(), ER3044PosLbAsrjk210.getName(), ER3044PosLbAsrjk210.getObjects()),
	R3045_LB220 (ER3045PosLbAsrjk220.getRefNumber(), ER3045PosLbAsrjk220.getName(), ER3045PosLbAsrjk220.getObjects()),
	R3046_LB601 (ER3046PosLbAsrjk601.getRefNumber(), ER3046PosLbAsrjk601.getName(), ER3046PosLbAsrjk601.getObjects()),
	R3047_LB211 (ER3047PosLbAsrjk211.getRefNumber(), ER3047PosLbAsrjk211.getName(), ER3047PosLbAsrjk211.getObjects()),
	R3048_LB212 (ER3048PosLbAsrjk212.getRefNumber(), ER3048PosLbAsrjk212.getName(), ER3048PosLbAsrjk212.getObjects()),
	R3049_LB213 (ER3049PosLbAsrjk213.getRefNumber(), ER3049PosLbAsrjk213.getName(), ER3049PosLbAsrjk213.getObjects()),
	R3050_LB602 (ER3050PosLbAsrjk602.getRefNumber(), ER3050PosLbAsrjk602.getName(), ER3050PosLbAsrjk602.getObjects()),
	R3051_LB603 (ER3051PosLbAsrjk603.getRefNumber(), ER3051PosLbAsrjk603.getName(), ER3051PosLbAsrjk603.getObjects()),
	R3052_LB604 (ER3052PosLbAsrjk604.getRefNumber(), ER3052PosLbAsrjk604.getName(), ER3052PosLbAsrjk604.getObjects()),
	R3053_LB605 (ER3053PosLbAsrjk605.getRefNumber(), ER3053PosLbAsrjk605.getName(), ER3053PosLbAsrjk605.getObjects()),
	R3054_LB606 (ER3054PosLbAsrjk606.getRefNumber(), ER3054PosLbAsrjk606.getName(), ER3054PosLbAsrjk606.getObjects()),
	R3055_LB607 (ER3055PosLbAsrjk607.getRefNumber(), ER3055PosLbAsrjk607.getName(), ER3055PosLbAsrjk607.getObjects()),
	R3056_LB608 (ER3056PosLbAsrjk608.getRefNumber(), ER3056PosLbAsrjk608.getName(), ER3056PosLbAsrjk608.getObjects()),
	R3057_LB614 (ER3057PosLbAsrjk614.getRefNumber(), ER3057PosLbAsrjk614.getName(), ER3057PosLbAsrjk614.getObjects()),
	R3058_LB615 (ER3058PosLbAsrjk615.getRefNumber(), ER3058PosLbAsrjk615.getName(), ER3058PosLbAsrjk615.getObjects()),
	R3059_LB616 (ER3059PosLbAsrjk616.getRefNumber(), ER3059PosLbAsrjk616.getName(), ER3059PosLbAsrjk616.getObjects()),
	R3060_LB119 (ER3060PosLbAsrjk119.getRefNumber(), ER3060PosLbAsrjk119.getName(), ER3060PosLbAsrjk119.getObjects()),
	R3061_LB617 (ER3061PosLbAsrjk617.getRefNumber(), ER3061PosLbAsrjk617.getName(), ER3061PosLbAsrjk617.getObjects()),
	R3062_LB120 (ER3062PosLbAsrjk120.getRefNumber(), ER3062PosLbAsrjk120.getName(), ER3062PosLbAsrjk120.getObjects()),
	R3063_LB121 (ER3063PosLbAsrjk121.getRefNumber(), ER3063PosLbAsrjk121.getName(), ER3063PosLbAsrjk121.getObjects()),
	R3064_LB122 (ER3064PosLbAsrjk122.getRefNumber(), ER3064PosLbAsrjk122.getName(), ER3064PosLbAsrjk122.getObjects()),
	R3065_LB618 (ER3065PosLbAsrjk618.getRefNumber(), ER3065PosLbAsrjk618.getName(), ER3065PosLbAsrjk618.getObjects()),
	R3066_LB619 (ER3066PosLbAsrjk619.getRefNumber(), ER3066PosLbAsrjk619.getName(), ER3066PosLbAsrjk619.getObjects()),
	R3067_LB620 (ER3067PosLbAsrjk620.getRefNumber(), ER3067PosLbAsrjk620.getName(), ER3067PosLbAsrjk620.getObjects()),
	R3068_LB621 (ER3068PosLbAsrjk621.getRefNumber(), ER3068PosLbAsrjk621.getName(), ER3068PosLbAsrjk621.getObjects()),
	R3069_LB622 (ER3069PosLbAsrjk622.getRefNumber(), ER3069PosLbAsrjk622.getName(), ER3069PosLbAsrjk622.getObjects()),
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
