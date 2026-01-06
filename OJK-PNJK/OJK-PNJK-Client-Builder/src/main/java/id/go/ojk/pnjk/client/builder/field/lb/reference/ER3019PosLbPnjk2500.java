package id.go.ojk.pnjk.client.builder.field.lb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.pnjk.client.builder.field.EFormLaporanBulanan;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3019PosLbPnjk2500 implements IObject<KeyValueString> {
	R_2500010000 ("2500010000", "Detail"),
    R_2500000000 ("2500000000", "Total")
	;

	@Getter
	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3019PosLbPnjk2500 eEnum : ER3019PosLbPnjk2500.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

    public static String genFieldSave() {
        return UtilMetadata.genFieldSave("3", getObjects());
    }

	public static String getName() {
		return ER3019PosLbPnjk2500.class.getSimpleName().substring(6);
	}

	public static int getRefNumber() {
		return Integer.parseInt(ER3019PosLbPnjk2500.class.getSimpleName().substring(2, 6));
	}

	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects(), new int[] { 1 });
	}

    public static ConditionalRequired genConditionForTotal() {
        return UtilFieldConditional.genExistPos("N", "M", R_2500000000.key);
    }

    public static SegmentValidation genValidation1() {
        return UtilSegmentValidation.genEqualsFormula("3", R_2500000000.key, R_2500010000.key,
                UtilMetadata.genMessageTotal(R_2500000000.value, R_2500010000.value));
    }

    public static SegmentValidation genValidation2() {
        return UtilSegmentValidation.genEqualsFormAdd("3", R_2500000000.key, "2|2",
                ER3004PosLbPnjk1100.R_11000101110000.getKeyForm() + "|" + ER3004PosLbPnjk1100.R_11000102090000.getKeyForm(),
                UtilMetadata.genMessage(R_2500000000.value,
                        "\"Total Penjumlahan Aset Tetap - Netto (Lancar + Tidak Lancar)\" yang dilaporkan pada form \"Laporan Posisi Keuangan\" (form 1100)"));
    }
}
