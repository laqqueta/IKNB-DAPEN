package id.go.ojk.lpei.client.builder.field.lb.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.patternAlfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.lib.client.model.config.DataType;
import id.go.ojk.lpei.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.lpei.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.lpei.client.builder.field.lb.reference.ER5030PosLbLpeigDHE01;
import id.go.ojk.lpei.client.builder.field.reference.EHeaderMetadataShared;

public class LbDhe01 extends BaseMetadata {

	public LbDhe01(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_DHE01;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 1, null);

		res.setSavePos(ER5030PosLbLpeigDHE01.genFieldSave());

		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 10, 10, refTable)
				.confReference(EHeaderMetadataLb.R5030_LBDHE01.getObject()).confRegex(patternAlfaNumeric)));
		fs.add(sf(2, null, "Total Nilai PPE - Nama Debitur", sv(M, 1, 100, all)));
		fs.add(sf(3, null, "Total Nilai PPE - Nomor Rekening Debitur", sv(M, 1, 100, DataType.numeric)));
		fs.add(sf(4, null, "Total Nilai PPE - Jenis Valuta Asal",
				sv(M, 1, 10, refTable).confReference(EHeaderMetadataShared.R020.getObject())
				.confRegex(SimpleValidation.PATTERN_REFERENCE_3.c())));
		fs.add(sf(5, null, "Total Nilai PPE - Nilai PPE Awal Dalam Valuta Asal",
				sv(M, 1, 20, DataType.numericDot)));
		fs.add(sf(6, null, "Total Nilai PPE - Nilai USD", sv(M, 1, 20, DataType.numericDot)));
		fs.add(sf(7, null, "Jenis Pembiayaan",
				sv(M, 1, 10, refTable).confReference(EHeaderMetadataShared.R063.getObject())
				.confRegex(SimpleValidation.PATTERN_REFERENCE_1.c())));
		fs.add(sf(8, null, "Sektor Ekonomi",
				sv(M, 1, 10, refTable).confReference(EHeaderMetadataShared.R022.getObject())
				.confRegex(SimpleValidation.PATTERN_REFERENCE_1.c())));
		fs.add(sf(9, null, "Penerimaan DHE SDA Oleh PPI - Tanggal", sv(M, 8, 8, DataType.date)));
		fs.add(sf(10, null, "Penerimaan DHE SDA Oleh PPI - Jumlah Dalam USD", sv(M, 1, 20, DataType.numericDot)));
		fs.add(sf(11, null, "Penerimaan DHE SDA Oleh PPI - Kurs Dalam Rupiah", sv(M, 1, 20, DataType.numeric)));
		fs.add(sf(12, null, "Penerimaan DHE SDA Oleh PPI - Nilai Rupiah", sv(M, 1, 20, DataType.numeric))
				.addFieldValidations(ER5030PosLbLpeigDHE01.genFieldValidation12()));		
		fs.add(sf(13, null, "Retensi 30% - Rekening Khusus", sv(C, 1, 20, DataType.numericDot)
				.confConditionalRequired(ER5030PosLbLpeigDHE01.genConditionalValidation13()))
				.addFieldValidations(ER5030PosLbLpeigDHE01.genFieldValidation13and14()));
		fs.add(sf(14, null, "Retensi 30% - Bentuk Lainnya", sv(C, 1, 20, DataType.numericDot)
				.confConditionalRequired(ER5030PosLbLpeigDHE01.genConditionalValidation14()))
				.addFieldValidations(ER5030PosLbLpeigDHE01.genFieldValidation13and14()));
		fs.add(sf(15, null, "Jangka Waktu - Awal", sv(M, 8, 8, DataType.date)));
		fs.add(sf(16, null, "Jangka Waktu - Jatuh Tempo", sv(M, 8, 8, DataType.date)));
		fs.add(sf(17, null, "Persentase Imbal Hasil Dari Penempatan Retensi Dalam Bentuk Lain",
				sv(M, 1, 10, DataType.numericDotNegatif)));
		fs.add(sf(18, null, "Dana Yang Disimpan Dalam Rekening Debitur di LPEI (Escrow Account)",
				sv(M, 1, 20, DataType.numeric)));
		fs.add(sf(19, null, "Sisa Dana DHE yang Ditransfer ke Rekening Debitur di Bank Lain",
				sv(M, 1, 20, DataType.numeric)).addFieldValidations(ER5030PosLbLpeigDHE01.genFieldValidation19()));
		return res;
	}
}
