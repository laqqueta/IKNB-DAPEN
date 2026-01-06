package id.go.ojk.fink.client.builder.field.lb.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.PATTERN_ALL_1;
import static id.go.ojk.client.model.config.SimpleValidation.patternNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.fink.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.fink.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.fink.client.builder.field.lb.reference.ER3018PosLbFink2116;

public class Lb2116 extends BaseMetadata {

	public Lb2116(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_2116;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 1, null, ER3018PosLbFink2116.genFieldSave(), ER3018PosLbFink2116.genFieldSaveForm(),
				ER3018PosLbFink2116.getRequiredPos());
		res.addSegmentValidations(ER3018PosLbFink2116.genRowValidation2());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 12, 12, refTable)
				.confReference(EHeaderMetadataLb.R3018_LB2116.getObject()).confRegex(patternNumeric)));
		fs.add(sf(2, null, "Nama Aset Tak Berwujud", sv(C, 1, 1000, all).confRegex(PATTERN_ALL_1)
				.confConditionalRequired(ER3018PosLbFink2116.genConditional())));
		fs.add(sf(3, null, "Saldo Awal", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Penambahan", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(5, null, "Pengurangan", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(6, null, "Saldo Akhir", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER3018PosLbFink2116.genFieldValidation6()));
		fs.add(sf(7, null, "Keterangan (Tujuan Penggunaan)", sv(C, 1, 1000, all).confRegex(PATTERN_ALL_1)
				.confConditionalRequired(ER3018PosLbFink2116.genConditional())));
		return res;
	}
}
