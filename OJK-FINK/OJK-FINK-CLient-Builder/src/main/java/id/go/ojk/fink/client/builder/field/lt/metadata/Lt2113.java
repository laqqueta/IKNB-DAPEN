package id.go.ojk.fink.client.builder.field.lt.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.patternLJKName;
import static id.go.ojk.client.model.config.SimpleValidation.patternNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.date;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.fink.client.builder.field.EFormLaporanTahunan;
import id.go.ojk.fink.client.builder.field.lt.reference.EHeaderMetadataLt;
import id.go.ojk.fink.client.builder.field.lt.reference.ER6009PosLtFink2113;

public class Lt2113 extends BaseMetadata {

	public Lt2113(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanTahunan eEnum = EFormLaporanTahunan.LT_2113;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 1, null, ER6009PosLtFink2113.genFieldSave(), ER6009PosLtFink2113.genFieldSave(),
				ER6009PosLtFink2113.getRequiredPos());
		res.addSegmentValidations(ER6009PosLtFink2113.genRowValidation2());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 12, 12, refTable)
				.confReference(EHeaderMetadataLt.R6009_LT2113.getObject()).confRegex(patternNumeric)));
		fs.add(sf(2, null, "Nama Debitur", sv(C, 1, 100, all).confRegex(patternLJKName)
				.confConditionalRequired(ER6009PosLtFink2113.genConditional())));
		fs.add(sf(3, null, "Pihak Berelasi", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Pihak Ketiga", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(5, null, "Jumlah Piutang Tidak Lancar Lainnya", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER6009PosLtFink2113.genFieldValidation5()));
		fs.add(sf(6, null, "Tanggal Pencairan",
				sv(C, 1, 8, date).confConditionalRequired(ER6009PosLtFink2113.genConditional())));
		fs.add(sf(7, null, "Tanggal Jatuh Tempo",
				sv(C, 1, 8, date).confConditionalRequired(ER6009PosLtFink2113.genConditional())));
		fs.add(sf(8, null, "Keterangan (Tujuan penggunaan)", sv(C, 1, 100, all).confRegex(patternLJKName)
				.confConditionalRequired(ER6009PosLtFink2113.genConditional())));
		return res;
	}
}
