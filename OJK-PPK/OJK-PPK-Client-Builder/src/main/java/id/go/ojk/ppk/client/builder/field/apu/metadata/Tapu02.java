package id.go.ojk.ppk.client.builder.field.apu.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
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
import id.go.ojk.ppk.client.builder.field.apu.reference.ER5001PosApuPpk02;

public class Tapu02 extends BaseMetadata {

	public Tapu02(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormApuPenilaian eEnum = EFormApuPenilaian.APU_02;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 35, 35, null, null, ER5001PosApuPpk02.getRequiredPos());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataPenilaian.R001.getObject())).confUnique(U));
		fs.add(sf(2, null, "Penilaian", sv(M, 1, 1, numeric))
				.addFieldValidations(ER5001PosApuPpk02.genValidationPenilaian()));
		fs.add(sf(3, null, "Penjelasan / Keterangan", sv(M, 1, 4000, all)));
		return res;
	}
}
