package id.go.ojk.lpei.client.builder.field.lb.uus.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.lib.client.model.config.DataType;
import id.go.ojk.lib.client.model.config.UniqueType;
import id.go.ojk.lpei.client.builder.field.EFormLaporanBulananUus;
import id.go.ojk.lpei.client.builder.field.lb.uus.reference.EHeaderMetadataLbUus;
import id.go.ojk.lpei.client.builder.field.lb.uus.reference.ER7003PosLbLpeiu0041;

public class Lb0041 extends BaseMetadata {

	public Lb0041(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulananUus eEnum = EFormLaporanBulananUus.LB_0041;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 13, 13);

		res.setRequiredPos(ER7003PosLbLpeiu0041.getRequiredPos());
		res.setUniquePos(ER7003PosLbLpeiu0041.getUniquePos());
		res.setSavePos(ER7003PosLbLpeiu0041.genFieldSave());
		res.setSavePosForm(ER7003PosLbLpeiu0041.genFieldSave());

		res.addSegmentValidations(ER7003PosLbLpeiu0041.genRowValidation07());
		res.addSegmentValidations(ER7003PosLbLpeiu0041.genRowValidation13());
		res.addSegmentValidations(ER7003PosLbLpeiu0041.genRowValidation14());
		res.addSegmentValidations(ER7003PosLbLpeiu0041.genRowValidation13B());
		res.addSegmentValidations(ER7003PosLbLpeiu0041.genRowValidation13C());

		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 10, 10, DataType.refTable)
				.confReference(EHeaderMetadataLbUus.R7003_LB0041.getObject())
				.confRegex(SimpleValidation.patternNumeric))
				.confUniqueType(UniqueType.U));
		fs.add(sf(2, null, "Tenaga Kerja Tetap - Laki-Laki", sv(M, 1, 5, DataType.numeric)));
		fs.add(sf(3, null, "Tenaga Kerja Tetap - Perempuan", sv(M, 1, 5, DataType.numeric)));
		fs.add(sf(4, null, "Tenaga Kerja Tetap - Total", sv(M, 1, 5, DataType.numeric))
				.addFieldValidations(ER7003PosLbLpeiu0041.genFieldValidation4()));
		fs.add(sf(5, null, "Tenaga Kerja Kontrak - Laki-Laki", sv(M, 1, 5, DataType.numeric)));
		fs.add(sf(6, null, "Tenaga Kerja Kontrak - Perempuan", sv(M, 1, 5, DataType.numeric)));
		fs.add(sf(7, null, "Tenaga Kerja Kontrak - Total", sv(M, 1, 5, DataType.numeric))
				.addFieldValidations(ER7003PosLbLpeiu0041.genFieldValidation7()));
		fs.add(sf(8, null, "Tenaga Kerja Alih Daya  - Laki-Laki", sv(M, 1, 5, DataType.numeric)));
		fs.add(sf(9, null, "Tenaga Kerja Alih Daya - Perempuan", sv(M, 1, 5, DataType.numeric)));
		fs.add(sf(10, null, "Tenaga Kerja Alih Daya - Total", sv(M, 1, 5, DataType.numeric))
				.addFieldValidations(ER7003PosLbLpeiu0041.genFieldValidation10()));
		fs.add(sf(11, null, "Total Tenaga Kerja  - Laki-Laki", sv(M, 1, 5, DataType.numeric))
				.addFieldValidations(ER7003PosLbLpeiu0041.genFieldValidation11()));
		fs.add(sf(12, null, "Total Tenaga Kerja  - Perempuan", sv(M, 1, 5, DataType.numeric))
				.addFieldValidations(ER7003PosLbLpeiu0041.genFieldValidation12()));
		fs.add(sf(13, null, "Total Tenaga Kerja - Total", sv(M, 1, 5, DataType.numeric))
				.addFieldValidations(ER7003PosLbLpeiu0041.genFieldValidation13()));
		return res;
	}
}
