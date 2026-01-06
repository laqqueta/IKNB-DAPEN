package id.go.ojk.pnjk.client.builder.field.lb.uus.metadata;

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
import id.go.ojk.pnjk.client.builder.field.EFormLaporanBulananUus;
import id.go.ojk.pnjk.client.builder.field.lb.uus.reference.EHeaderMetadataLbUus;
import id.go.ojk.pnjk.client.builder.field.lb.uus.reference.ER3128PosLbPnju3300A;
import id.go.ojk.pnjk.client.builder.field.reference.EHeaderMetadataShared;

public class Lb3300A extends BaseMetadata {

	public Lb3300A(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulananUus eEnum = EFormLaporanBulananUus.LB_3300A;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 0, null);
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLbUus.R3128_LB3300A.getObject())));
		fs.add(sf(2, null, "Lokasi Penerima Jaminan (Dati II)", sv(M, 1, 10, refTable).confRegex(PATTERN_REFERENCE_1)
				.confReference(EHeaderMetadataShared.R033.getObject())));
		fs.add(sf(3, null,
				"Kafalah Pembiayaan Produktif – Kafalah Pembiayaan UMKM (Non KUR)-Jumlah Terjamin (Makfuul Lahu)-(Satuan)",
				sv(M, 1, 8, numeric)));
		fs.add(sf(4, null, "Kafalah Pembiayaan Produktif – Kafalah Pembiayaan UMKM (Non KUR)-Nilai Kafalah (Rp)",
				sv(M, 1, 16, numeric)));
		fs.add(sf(5, null, "Kafalah Pembiayaan Produktif – Kafalah Pembiayaan UMKM (Non KUR)-Nilai Klaim (Rp)",
				sv(M, 1, 16, numeric)));
		fs.add(sf(6, null,
				"Kafalah Pembiayaan Produktif – Kafalah Pembiayaan Usaha Mikro Non UMKM-Jumlah Terjamin (Makfuul Lahu)-(Satuan)",
				sv(M, 1, 8, numeric)));
		fs.add(sf(7, null, "Kafalah Pembiayaan Produktif – Kafalah Pembiayaan Usaha Mikro Non UMKM-Nilai Kafalah (Rp)",
				sv(M, 1, 16, numeric)));
		fs.add(sf(8, null, "Kafalah Pembiayaan Produktif – Kafalah Pembiayaan Usaha Mikro Non UMKM-Nilai Klaim (Rp)",
				sv(M, 1, 16, numeric)));
		fs.add(sf(9, null, "Kafalah Pembiayaan Non Produktif-Jumlah Terjamin (Makfuul Lahu)-(Satuan)",
				sv(M, 1, 8, numeric)));
		fs.add(sf(10, null, "Kafalah Pembiayaan Non Produktif-Nilai Kafalah (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(11, null, "Kafalah Pembiayaan Non Produktif-Nilai Klaim (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(12, null, "Kafalah KUR - Mikro-Jumlah Terjamin (Makfuul Lahu)-(Satuan)", sv(M, 1, 8, numeric)));
		fs.add(sf(13, null, "Kafalah KUR - Mikro-Nilai Kafalah (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(14, null, "Kafalah KUR - Mikro-Nilai Klaim (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(15, null, "Kafalah KUR - Non Mikro-Jumlah Terjamin (Makfuul Lahu)-(Satuan)", sv(M, 1, 8, numeric)));
		fs.add(sf(16, null, "Kafalah KUR - Non Mikro-Nilai Kafalah (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(17, null, "Kafalah KUR - Non Mikro-Nilai Klaim (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(18, null, "Total-Jumlah Terjamin (Makfuul Lahu)-(Satuan)", sv(M, 1, 8, numeric))
				.addFieldValidations(ER3128PosLbPnju3300A.genFieldValidation18()));
		fs.add(sf(19, null, "Total-Nilai Kafalah (Rp)", sv(M, 1, 16, numeric))
				.addFieldValidations(ER3128PosLbPnju3300A.genFieldValidation19()));
		fs.add(sf(20, null, "Total-Nilai Klaim (Rp)", sv(M, 1, 16, numeric))
				.addFieldValidations(ER3128PosLbPnju3300A.genFieldValidation20()));
		return res;
	}
}
