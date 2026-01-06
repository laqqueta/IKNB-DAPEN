package id.go.ojk.pnjs.client.builder.field.lb.reference;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3036PosLbPnjs6100 implements IObject<KeyValueString> {
	R_6100010000 ("6100010000", "Saldo Awal"),
//	R_6100020000 ("6100020000", "Ditambah/(Dikurangi):"),
	R_6100020100 ("6100020100", "Pembayaran Klaim"),
	R_6100020200 ("6100020200", "Angsuran Subrogasi"),
	R_6100030000 ("6100030000", "Saldo Akhir"),
	;

	@Getter
	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3036PosLbPnjs6100 eEnum : ER3036PosLbPnjs6100.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static String getName() {
		return ER3036PosLbPnjs6100.class.getSimpleName().substring(6);
	}

	public static int getRefNumber() {
		return Integer.parseInt(ER3036PosLbPnjs6100.class.getSimpleName().substring(2, 6));
	}

	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2", getObjects());
	}
	
	public static SegmentValidation genValidation6() {
		int[] field = new int[] { 0, 1 };
		return UtilSegmentValidation.genEqualsFormula("2", R_6100030000.key,
				UtilMetadata.genPlusRow(getObjects(), field) + "-" + R_6100020200.key,
				UtilMetadata.genMessage(R_6100030000.value, UtilMetadata.genPlusDesc(getObjects(), field) + "-"
						+ StringUtils.wrap(R_6100020200.value, "'")));
	}
}
