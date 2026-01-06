package id.go.ojk.pnmk.client.builder.field.lb.uus.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.pnmk.client.builder.field.EFormLaporanBulananUus;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3102PosLbPnmu0030 implements IObject<KeyValueString> {
	R_0030010000 ("0030010000", "Pegawai Tetap"),
	R_0030020000 ("0030020000", "Pegawai Kontrak"),
	R_0030030000 ("0030030000", "Tenaga Kerja Alih Daya"),
	R_0030040000 ("0030040000", "Jumlah"),
	;

	@Getter
	private String key;
	private String value;
	
	public String getFormKey() {
		return EFormLaporanBulananUus.LB_0030.getCode() + key;
	}

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3102PosLbPnmu0030 eEnum : ER3102PosLbPnmu0030.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static String getName() {
		return ER3102PosLbPnmu0030.class.getSimpleName().substring(6);
	}

	public static int getRefNumber() {
		return Integer.parseInt(ER3102PosLbPnmu0030.class.getSimpleName().substring(2, 6));
	}

	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}

	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|3", getObjects());
	}
	
	public static SegmentValidation genRowValidation5() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_0030040000.key, UtilMetadata.genPlusRow(getObjects(), 0, 2), 
				UtilMetadata.genMessage(R_0030040000.value, UtilMetadata.genPlusDesc(getObjects(), 0, 2)));
	}
}
