package id.go.ojk.ppk.client.builder.field.apu.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.ppk.client.builder.field.EFormApuPenilaian;
import id.go.ojk.ppk.client.builder.field.apu.reference.EHeaderMetadataPenilaian;
import id.go.ojk.ppk.client.builder.field.apu.reference.ER5002PosApuPpk03;

public class Tapu03 extends BaseMetadata {

	public Tapu03(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormApuPenilaian eEnum = EFormApuPenilaian.APU_03;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 2, 2, null, null, ER5002PosApuPpk03.getRequiredPos());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataPenilaian.R002.getObject())).confUnique(U));
		fs.add(sf(2, null, "Jawaban", sv(M, 1, 1, numeric))
				.addFieldValidations(ER5002PosApuPpk03.genValidationKepemilikan())
				.addFieldValidations(ER5002PosApuPpk03.genValidationPerusahaan()));
		return res;
	}
}
