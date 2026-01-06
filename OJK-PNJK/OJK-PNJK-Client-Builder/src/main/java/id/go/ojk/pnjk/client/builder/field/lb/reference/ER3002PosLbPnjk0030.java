package id.go.ojk.pnjk.client.builder.field.lb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.pnjk.client.builder.field.EFormLaporanBulanan;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3002PosLbPnjk0030 implements IObject<KeyValueString> {
	R_0030010100("0030010100", "Pegawai Tetap"), 
	R_0030010200("0030010200", "Pegawai Kontrak"),
	R_0030010300("0030010300", "Pegawai Alih Daya"), 
	R_0030010000("0030010000", "Jumlah"),;

	@Getter
	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3002PosLbPnjk0030 eEnum : ER3002PosLbPnjk0030.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public String getKeyForm() {
		return EFormLaporanBulanan.LB_0030.getCode() + key;
	}

	public static String getName() {
		return ER3002PosLbPnjk0030.class.getSimpleName().substring(6);
	}

	public static int getRefNumber() {
		return Integer.parseInt(ER3002PosLbPnjk0030.class.getSimpleName().substring(2, 6));
	}

	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 5), getObjects());
	}

	public static SegmentValidation genValidation5() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 5), R_0030010000.key,
				UtilMetadata.genPlusRow(getObjects(), 0, 2),
				UtilMetadata.genMessage(R_0030010000.value, UtilMetadata.genPlusDesc(getObjects(), 0, 2)));
	}
}
