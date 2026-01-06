package id.go.ojk.pnmk.client.builder.field.lb.uus.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.PATTERN_NAME;
import static id.go.ojk.client.model.config.SimpleValidation.PATTERN_REFERENCE_1;
import static id.go.ojk.client.model.config.SimpleValidation.patternNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.date;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.config.DataType.numericDotNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.pnmk.client.builder.field.EFormLaporanBulananUus;
import id.go.ojk.pnmk.client.builder.field.lb.uus.reference.EHeaderMetadataLbUus;
import id.go.ojk.pnmk.client.builder.field.lb.uus.reference.ER3109PosLbPnmu2300;
import id.go.ojk.pnmk.client.builder.field.reference.EHeaderMetadataShared;

public class Lb2300 extends BaseMetadata {

	public Lb2300(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulananUus eEnum = EFormLaporanBulananUus.LB_2300;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 0, null);
		res.setSavePosForm(ER3109PosLbPnmu2300.genFieldSave());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 10, 10, refTable)
				.confReference(EHeaderMetadataLbUus.R3109_LB2300.getObject()).confRegex(patternNumeric)));
		fs.add(sf(2, null, "Nomor Surat Berharga", sv(M, 1, 20, all)));
		fs.add(sf(3, null, "Jenis Surat Berharga", sv(M, 1, 15, refTable)
				.confReference(EHeaderMetadataShared.R015.getObject()).confRegex(PATTERN_REFERENCE_1.c())));
		fs.add(sf(4, null, "Nama Penerbit", sv(M, 1, 100, all).confRegex(PATTERN_NAME.c())));
		fs.add(sf(5, null, "Peringkat Surat Berharga", sv(M, 1, 15, refTable)
				.confReference(EHeaderMetadataShared.R004.getObject()).confRegex(PATTERN_REFERENCE_1.c())));
		fs.add(sf(6, null, "Lembaga Pemeringkat", sv(M, 1, 15, refTable)
				.confReference(EHeaderMetadataShared.R005.getObject()).confRegex(PATTERN_REFERENCE_1.c())));
		fs.add(sf(7, null, "Jangka Waktu, Tanggal Mulai", sv(M, 8, 8, date))
				.addFieldValidations(ER3109PosLbPnmu2300.genValidation7()));
		fs.add(sf(8, null, "Jangka Waktu, Tanggal Jatuh Tempo", sv(M, 8, 8, date))
				.addFieldValidations(ER3109PosLbPnmu2300.genValidation8()));
		fs.add(sf(9, null, "Tingkat Imbal Hasil (%)", sv(M, 1, 6, numericDotNegatif)));
		fs.add(sf(10, null, "Nominal", sv(M, 1, 16, numeric)));
		fs.add(sf(11, null, "Harga Perolehan", sv(M, 1, 16, numeric)));
		fs.add(sf(12, null, "Premium/Diskonto", sv(M, 1, 16, numeric)));
		fs.add(sf(13, null, "CKPN", sv(M, 1, 16, numeric)));
		fs.add(sf(14, null, "Jumlah", sv(M, 1, 16, numeric)));
		return res;
	}
}
