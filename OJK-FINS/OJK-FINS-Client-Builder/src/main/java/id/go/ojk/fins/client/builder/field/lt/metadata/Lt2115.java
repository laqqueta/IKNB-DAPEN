package id.go.ojk.fins.client.builder.field.lt.metadata;

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
import id.go.ojk.fins.client.builder.field.EFormLaporanTahunan;
import id.go.ojk.fins.client.builder.field.lt.reference.EHeaderMetadataLt;
import id.go.ojk.fins.client.builder.field.lt.reference.ER6012PosLtFins2115;

public class Lt2115 extends BaseMetadata {

	public Lt2115(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanTahunan eEnum = EFormLaporanTahunan.LT_2115;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 1, null, ER6012PosLtFins2115.genFieldSave(), ER6012PosLtFins2115.genFieldSave(),
				ER6012PosLtFins2115.getRequiredPos());
		res.addSegmentValidations(ER6012PosLtFins2115.genRowValidation2());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 12, 12, refTable)
				.confReference(EHeaderMetadataLt.R6012_LT2115.getObject()).confRegex(patternNumeric)));
		fs.add(sf(2, null, "Nama Kreditur", sv(C, 1, 100, all).confRegex(patternLJKName)
				.confConditionalRequired(ER6012PosLtFins2115.genConditional())));
		fs.add(sf(3, null, "Pihak Berelasi", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Pihak Ketiga", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(5, null, "Jumlah Utang Jangka Panjang Lainnya", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER6012PosLtFins2115.genFieldValidation5()));
		fs.add(sf(6, null, "Tanggal Pencairan",
				sv(C, 1, 8, date).confConditionalRequired(ER6012PosLtFins2115.genConditional())));
		fs.add(sf(7, null, "Tanggal Jatuh Tempo",
				sv(C, 1, 8, date).confConditionalRequired(ER6012PosLtFins2115.genConditional())));
		fs.add(sf(8, null, "Keterangan (Tujuan penggunaan)", sv(C, 1, 100, all).confRegex(patternLJKName)
				.confConditionalRequired(ER6012PosLtFins2115.genConditional())));
		return res;
	}
}
