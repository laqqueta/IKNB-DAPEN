package id.go.ojk.dplks.client.builder.field.tl.metadata;

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
import id.go.ojk.dplks.client.builder.field.EFormTindakLanjut;
import id.go.ojk.dplks.client.builder.field.tl.reference.EHeaderMetadataTl;
import id.go.ojk.dplks.client.builder.field.tl.reference.ER9000PosTlDplks0100;
import id.go.ojk.lib.client.model.config.DataType;

public class Tl0100 extends BaseMetadata {

	public Tl0100(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormTindakLanjut eEnum = EFormTindakLanjut.TL_0100;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(), extension, 1, null);

		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 10, 10, refTable)
				.confReference(EHeaderMetadataTl.R9000_TL0100.getObject())
				.confRegex(SimpleValidation.patternNumeric)));
		fs.add(sf(2, null, "ID Bukti", sv(M, 1, 35, all)));
		fs.add(sf(3, null, "Ringkasan Rekomendasi OJK", sv(C, 1, 5000, all)
				.confConditionalRequired(ER9000PosTlDplks0100.genConditionalExist03())));
		fs.add(sf(4, null, "Ringkasan Tindak Lanjut Dana Pensiun", sv(C, 1, 5000, all)
				.confConditionalRequired(ER9000PosTlDplks0100.genConditionalExist04())));
		fs.add(sf(5, null, "Tanggal Jatuh Tempo Rekomendasi", sv(C, 8, 8, DataType.date)
				.confConditionalRequired(ER9000PosTlDplks0100.genConditionalExist05())));
		return res;
	}
}
