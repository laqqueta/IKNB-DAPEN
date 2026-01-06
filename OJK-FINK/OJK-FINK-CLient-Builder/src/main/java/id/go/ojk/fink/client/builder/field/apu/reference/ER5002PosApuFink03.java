package id.go.ojk.fink.client.builder.field.apu.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER5002PosApuFink03 implements IObject<KeyValueString> {
	R_0301000000 ("0301000000", "I. TOTAL ASET (full amount dalam satuan Rupiah)"),
	R_0302000000 ("0302000000", "II. PROVINSI KEDUDUKAN KANTOR PUSAT P2P"),
	R_0303000000 ("0303000000", "III.STRUKTUR PERUSAHAAN"),
	R_0304000000 ("0304000000", "IV.STRUKTUR KEPEMILIKAN"),
	;

	@Getter
	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER5002PosApuFink03 eEnum : ER5002PosApuFink03.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER5002PosApuFink03.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER5002PosApuFink03.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static SegmentValidation genValidationLen1() {
		return UtilSegmentValidation.genMaxLength("2", UtilMetadata.genPipeRow(getObjects(), new int[] { 1, 2, 3 }),
				1);
	}

	public static SegmentValidation genValidationJawaban1() {
		return UtilSegmentValidation.genFixedValue("2", UtilMetadata.genPipeRow(getObjects(), new int[] { 1, 2 }), "1|2|3|4|5");
	}

	public static SegmentValidation genValidationJawaban2() {
		return UtilSegmentValidation.genFixedValue("2", UtilMetadata.genPipeRow(getObjects(), new int[] { 3 }), "1|2|3|4|5|6|7|8");
	}
}
