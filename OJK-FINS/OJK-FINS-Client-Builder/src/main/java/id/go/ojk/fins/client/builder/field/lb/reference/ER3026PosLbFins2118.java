package id.go.ojk.fins.client.builder.field.lb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.fins.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3026PosLbFins2118 implements IObject<KeyValueString> {
	R_211801010000("211801010000", "Detail"),
	R_211801000000("211801000000", "Total"),
	;

	@Getter
	private String key;
	@Getter
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3026PosLbFins2118 eEnum : ER3026PosLbFins2118.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static String getName() {
		return ER3026PosLbFins2118.class.getSimpleName().substring(6);
	}

	public static int getRefNumber() {
		return Integer.parseInt(ER3026PosLbFins2118.class.getSimpleName().substring(2, 6));
	}

	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects(), new int[] { 1 });
	}

	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("3", getObjects());
	}
	
	public static ConditionalRequired genConditional() {
		return UtilFieldConditional.genExistPos("N", "M", UtilMetadata.genPipeRow(getObjects(), new int[] { 1 }));
	}
	
	public static SegmentValidation genRowValidation2A() {
		return UtilSegmentValidation.genEqualsFormula("3", R_211801000000.key, R_211801010000.key,
				UtilMetadata.genMessage(R_211801000000.value, "Penjumlahan rincian"));
	}

	public static SegmentValidation genRowValidation2B() {
		return UtilSegmentValidation.genEqualsForm("3", R_211801000000.key, EFormLaporanBulanan.LB_1200.getCode(), "2",
				ER3005PosLbFins1200.R_120003040000.getKey(),
				UtilMetadata.genMessage(R_211801000000.getValue() + " Jumlah", "Beban Pemasaran dan Periklanan pada Laporan Laba/Rugi (form 1200) sandi 120003040000"));
	}
}
