package id.go.ojk.pnjk.client.builder.field.lb.metadata;

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
import id.go.ojk.pnjk.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.pnjk.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.pnjk.client.builder.field.lb.reference.ER3026PosLbPnjk3200A;
import id.go.ojk.pnjk.client.builder.field.reference.EHeaderMetadataShared;

public class Lb3200A extends BaseMetadata {

	public Lb3200A(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_3200A;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 0, null);
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3026_LB3200A.getObject())));
		fs.add(sf(2, null, "Lokasi Terjamin (Dati II)", sv(M, 1, 10, refTable).confRegex(PATTERN_REFERENCE_1)
				.confReference(EHeaderMetadataShared.R033.getObject())));
		fs.add(sf(3, null, "Penjaminan Kredit Produktif – Penjaminan Kredit UMKM (Non KUR)-Jumlah Terjamin (Satuan)",
				sv(M, 1, 8, numeric)));
		fs.add(sf(4, null, "Penjaminan Kredit Produktif – Penjaminan Kredit UMKM (Non KUR)-Nilai Jaminan (Rp)",
				sv(M, 1, 16, numeric)));
		fs.add(sf(5, null, "Penjaminan Kredit Produktif – Penjaminan Kredit UMKM (Non KUR)-Nilai Klaim (Rp)",
				sv(M, 1, 16, numeric)));
		fs.add(sf(6, null,
				"Penjaminan Kredit Produktif – Penjaminan Kredit Usaha Mikro Non UMKM-Jumlah Terjamin (Satuan)",
				sv(M, 1, 8, numeric)));
		fs.add(sf(7, null, "Penjaminan Kredit Produktif – Penjaminan Kredit Usaha Mikro Non UMKM-Nilai Jaminan (Rp)",
				sv(M, 1, 16, numeric)));
		fs.add(sf(8, null, "Penjaminan Kredit Produktif – Penjaminan Kredit Usaha Mikro Non UMKM-Nilai Klaim (Rp)",
				sv(M, 1, 16, numeric)));
		fs.add(sf(9, null, "Penjaminan Kredit Non Produktif-Jumlah Terjamin (Satuan)", sv(M, 1, 8, numeric)));
		fs.add(sf(10, null, "Penjaminan Kredit Non Produktif-Nilai Jaminan (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(11, null, "Penjaminan Kredit Non Produktif-Nilai Klaim (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(12, null, "Penjaminan KUR - Mikro-Jumlah Terjamin (Satuan)", sv(M, 1, 8, numeric)));
		fs.add(sf(13, null, "Penjaminan KUR - Mikro-Nilai Jaminan (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(14, null, "Penjaminan KUR - Mikro-Nilai Klaim (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(15, null, "Penjaminan KUR - Non Mikro-Jumlah Terjamin (Satuan)", sv(M, 1, 8, numeric)));
		fs.add(sf(16, null, "Penjaminan KUR - Non Mikro-Nilai Jaminan (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(17, null, "Penjaminan KUR - Non Mikro-Nilai Klaim (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(18, null, "Total-Jumlah Terjamin (Satuan)", sv(M, 1, 8, numeric))
				.addFieldValidations(ER3026PosLbPnjk3200A.genFieldValidation18()));
		fs.add(sf(19, null, "Total-Nilai Jaminan (Rp)", sv(M, 1, 16, numeric))
				.addFieldValidations(ER3026PosLbPnjk3200A.genFieldValidation19()));
		fs.add(sf(20, null, "Total-Nilai Klaim (Rp)", sv(M, 1, 16, numeric))
				.addFieldValidations(ER3026PosLbPnjk3200A.genFieldValidation20()));
		return res;
	}
}
