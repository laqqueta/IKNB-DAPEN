package id.go.ojk.pnjs.client.builder.field.lb.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.PATTERN_REFERENCE_1;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.pnjs.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.pnjs.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.pnjs.client.builder.field.lb.reference.ER3030PosLbPnjs3400A;
import id.go.ojk.pnjs.client.builder.field.reference.EHeaderMetadataShared;

public class Lb3400A extends BaseMetadata {

	public Lb3400A(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_3400A;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 0, null);
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3030_LB3400A.getObject())));
		fs.add(sf(2, null, "Sektor Ekonomi", sv(M, 1, 10, refTable).confRegex(PATTERN_REFERENCE_1)
				.confReference(EHeaderMetadataShared.R022.getObject())));
		fs.add(sf(3, null,
				"Kafalah Pembiayaan Produktif – Kafalah Pembiayaan UMKM (Non KUR)-Jumlah Terjamin (Makfuul 'Anhu)-(Satuan)",
				sv(M, 1, 8, numeric)));
		fs.add(sf(4, null, "Kafalah Pembiayaan Produktif – Kafalah Pembiayaan UMKM (Non KUR)-Nilai Kafalah (Rp)",
				sv(M, 1, 16, numeric)));
		fs.add(sf(5, null, "Kafalah Pembiayaan Produktif – Kafalah Pembiayaan UMKM (Non KUR)-Nilai Klaim (Rp)",
				sv(M, 1, 16, numeric)));
		fs.add(sf(6, null,
				"Kafalah Pembiayaan Produktif – Kafalah Pembiayaan Usaha Mikro Non UMKM-Jumlah Terjamin (Makfuul 'Anhu)-(Satuan)",
				sv(M, 1, 8, numeric)));
		fs.add(sf(7, null, "Kafalah Pembiayaan Produktif – Kafalah Pembiayaan Usaha Mikro Non UMKM-Nilai Kafalah (Rp)",
				sv(M, 1, 16, numeric)));
		fs.add(sf(8, null, "Kafalah Pembiayaan Produktif – Kafalah Pembiayaan Usaha Mikro Non UMKM-Nilai Klaim (Rp)",
				sv(M, 1, 16, numeric)));
		fs.add(sf(9, null, "Kafalah Pembiayaan Non Produktif-Jumlah Terjamin (Makfuul 'Anhu)-(Satuan)",
				sv(M, 1, 8, numeric)));
		fs.add(sf(10, null, "Kafalah Pembiayaan Non Produktif-Nilai Kafalah (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(11, null, "Kafalah Pembiayaan Non Produktif-Nilai Klaim (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(12, null, "Kafalah KUR - Mikro-Jumlah Terjamin (Makfuul 'Anhu)-(Satuan)", sv(M, 1, 8, numeric)));
		fs.add(sf(13, null, "Kafalah KUR - Mikro-Nilai Kafalah (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(14, null, "Kafalah KUR - Mikro-Nilai Klaim (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(15, null, "Kafalah KUR - Non Mikro-Jumlah Terjamin (Makfuul 'Anhu)-(Satuan)", sv(M, 1, 8, numeric)));
		fs.add(sf(16, null, "Kafalah KUR - Non Mikro-Nilai Kafalah (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(17, null, "Kafalah KUR - Non Mikro-Nilai Klaim (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(18, null, "Total-Jumlah Terjamin (Makfuul 'Anhu)-(Satuan)", sv(M, 1, 8, numeric))
				.addFieldValidations(ER3030PosLbPnjs3400A.genFieldValidation18()));
		fs.add(sf(19, null, "Total-Nilai Kafalah (Rp)", sv(M, 1, 16, numeric))
				.addFieldValidations(ER3030PosLbPnjs3400A.genFieldValidation19()));
		fs.add(sf(20, null, "Total-Nilai Klaim (Rp)", sv(M, 1, 16, numeric))
				.addFieldValidations(ER3030PosLbPnjs3400A.genFieldValidation20()));
		return res;
	}
}
