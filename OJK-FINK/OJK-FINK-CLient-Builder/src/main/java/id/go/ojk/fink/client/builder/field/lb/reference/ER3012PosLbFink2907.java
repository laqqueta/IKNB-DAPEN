package id.go.ojk.fink.client.builder.field.lb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3012PosLbFink2907 implements IObject<KeyValueString> {
	R_290701000000("290701000000", "Lender"),
	R_290701010000("290701010000", "1 Dalam Negeri"),
	R_290701010100("290701010100", "A Perorangan"),
	R_290701010200("290701010200", "B Institusi – Perbankan"),
	R_290701010201("290701010201", "1 Bank Umum (tidak termasuk BPD)"),
	R_290701010202("290701010202", "2 BPD"),
	R_290701010203("290701010203", "3 BPR"),
	R_290701030300("290701030300", "C Institusi - Industri Keuangan Non-Bank (IKNB)"),
	R_290701030301("290701030301", "1 Perusahaan Pembiayaan"),
	R_290701030302("290701030302", "2 Perusahaan Modal Ventura"),
	R_290701030303("290701030303", "3 Perusahaan Dana Pensiun"),
	R_290701030304("290701030304", "4 Perusahaan Perasuransian"),
	R_290701030305("290701030305", "5 Lembaga Keuangan Mikro"),
	R_290701030306("290701030306", "6 LJKNB Lainnya"),
	R_290701040400("290701040400", "D Institusi – Koperasi"),
	R_290701050500("290701050500", "E Institusi - Badan Hukum Lainnya"),
	R_290701020000("290701020000", "2 Luar Negeri"),
	R_290701020100("290701020100", "A Perorangan"),
	R_290701020200("290701020200", "B Institusi - Perbankan"),
	R_290701020300("290701020300", "C Institusi - Industri Keuangan Non-Bank (IKNB)"),
	R_290701020301("290701020301", "1 Perusahaan Pembiayaan"),
	R_290701020302("290701020302", "2 Perusahaan Modal Ventura"),
	R_290701020303("290701020303", "3 Perusahaan Dana Pensiun"),
	R_290701020304("290701020304", "4 Perusahaan Perasuransian"),
	R_290701020305("290701020305", "5 LJKNB Lainnya"),
	R_290701020400("290701020400", "D Institusi - Badan Hukum Lainnya"),
	R_290702000000("290702000000", "Borrower"),
	R_290702010000("290702010000", "1 Perorangan"),
	R_290702010100("290702010100", "A UMKM"),
	R_290702010200("290702010200", "B NON UMKM"),
	R_290702020000("290702020000", "2 Institusi (Badan Hukum)"),
	R_290702020100("290702020100", "A UMKM"),
	R_290702020200("290702020200", "B NON UMKM"),
	;

	private String key;
	private String value;
	
	public String getValue() {
		int idx = value.indexOf(" ");
		if (idx > -1 && idx < 2) {
			return value.substring(idx).trim();
		}
		return value;
	}

	public KeyValueString getObject() {
		return new KeyValueString(key, getValue(), new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3012PosLbFink2907 eEnum : ER3012PosLbFink2907.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static String getName() {
		return ER3012PosLbFink2907.class.getSimpleName().substring(6);
	}

	public static int getRefNumber() {
		return Integer.parseInt(ER3012PosLbFink2907.class.getSimpleName().substring(2, 6));
	}

	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}

	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|3", getObjects());
	}
	
	public static SegmentValidation genRowValidation01() {
		int[] rows = new int[] { 1, 16 };
		return UtilSegmentValidation.genEqualsFormula("2|3", R_290701000000.key,
				UtilMetadata.genPlusRow(getObjects(), rows),
				UtilMetadata.genMessage(R_290701000000.getValue(), UtilMetadata.genPlusDesc(getObjects(), rows)));
	}
	
	public static SegmentValidation genRowValidation02() {
		int[] rows = new int[] { 2, 3, 7, 14, 15 };
		return UtilSegmentValidation.genEqualsFormula("2|3", R_290701010000.key,
				UtilMetadata.genPlusRow(getObjects(), rows),
				UtilMetadata.genMessage(R_290701010000.getValue(), UtilMetadata.genPlusDesc(getObjects(), rows)));
	}
	
	public static SegmentValidation genRowValidation04() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_290701010200.key,
				UtilMetadata.genPlusRow(getObjects(), 4, 6),
				UtilMetadata.genMessage(R_290701010200.getValue(), UtilMetadata.genPlusDesc(getObjects(), 4, 6)));
	}
	
	public static SegmentValidation genRowValidation08() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_290701030300.key,
				UtilMetadata.genPlusRow(getObjects(), 8, 13),
				UtilMetadata.genMessage(R_290701030300.getValue(), UtilMetadata.genPlusDesc(getObjects(), 8, 13)));
	}
	
	public static SegmentValidation genRowValidation17() {
		int[] rows = new int[] { 17, 18, 19, 25 };
		return UtilSegmentValidation.genEqualsFormula("2|3", R_290701020000.key,
				UtilMetadata.genPlusRow(getObjects(), rows),
				UtilMetadata.genMessage(R_290701020000.getValue(), UtilMetadata.genPlusDesc(getObjects(), rows)));
	}
	
	public static SegmentValidation genRowValidation20() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_290701020300.key,
				UtilMetadata.genPlusRow(getObjects(), 20, 24),
				UtilMetadata.genMessage(R_290701020300.getValue(), UtilMetadata.genPlusDesc(getObjects(), 20, 24)));
	}
	
	public static SegmentValidation genRowValidation27A() {
		int[] rows = new int[] { 27, 30 };
		return UtilSegmentValidation.genEqualsFormula("2|3", R_290702000000.key,
				UtilMetadata.genPlusRow(getObjects(), rows),
				UtilMetadata.genMessage(R_290702000000.getValue(), UtilMetadata.genPlusDesc(getObjects(), rows)));
	}
	
	public static SegmentValidation genRowValidation27B() {
		int[] rows = new int[] { 40, 88, 136, 184, 232 };
		return UtilSegmentValidation.genEqualsFormulaForm("2", R_290702000000.key, "3",
				UtilMetadata.genPlusRow(ER3013PosLbFink6908.getObjectsForm(), rows),
				UtilMetadata.genMessage(R_290702000000.getValue(),
						UtilMetadata.genPlusDesc(ER3013PosLbFink6908.getObjects(), rows) + " pada form 6908"));
	}
	
	public static SegmentValidation genRowValidation27C() {
		int[] rows = new int[] { 40, 88, 136, 184, 232 };
		return UtilSegmentValidation.genEqualsFormulaForm("3", R_290702000000.key, "4",
				UtilMetadata.genPlusRow(ER3013PosLbFink6908.getObjectsForm(), rows),
				UtilMetadata.genMessage(R_290702000000.getValue(),
						UtilMetadata.genPlusDesc(ER3013PosLbFink6908.getObjects(), rows) + " pada form 6908"));
	}
	
	public static SegmentValidation genRowValidation28() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_290702010000.key,
				UtilMetadata.genPlusRow(getObjects(), 28, 29),
				UtilMetadata.genMessage(R_290702010000.getValue(), UtilMetadata.genPlusDesc(getObjects(), 28, 29)));
	}
	
	public static SegmentValidation genRowValidation31() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_290702020000.key,
				UtilMetadata.genPlusRow(getObjects(), 31, 32),
				UtilMetadata.genMessage(R_290702020000.getValue(), UtilMetadata.genPlusDesc(getObjects(), 31, 32)));
	}
}
