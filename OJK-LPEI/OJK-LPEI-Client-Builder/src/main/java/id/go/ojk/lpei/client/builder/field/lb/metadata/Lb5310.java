package id.go.ojk.lpei.client.builder.field.lb.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.patternNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.lib.client.model.config.DataType;
import id.go.ojk.lib.client.model.constant.RequiredCondition;
import id.go.ojk.lpei.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.lpei.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.lpei.client.builder.field.lb.reference.ER5029PosLbLpeig5310;

public class Lb5310 extends BaseMetadata {

	public Lb5310(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_5310;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(), extension, 16, 16);
		List<SubmissionField> fs = res.getFields();

		res.setRequiredPos(ER5029PosLbLpeig5310.getRequiredPos());
		res.setUniquePos(ER5029PosLbLpeig5310.getUniquePos());
		res.setSavePos(ER5029PosLbLpeig5310.genFieldSave());

		res.addSegmentValidations(ER5029PosLbLpeig5310.genRowValidation02());
		res.addSegmentValidations(ER5029PosLbLpeig5310.genRowValidation03());
		res.addSegmentValidations(ER5029PosLbLpeig5310.genRowValidation09());

		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 12, 12, refTable)
				.confReference(EHeaderMetadataLb.R5029_LB5310.getObject()).confRegex(patternNumeric)));
		fs.add(sf(2, null, "Rupiah - Jatuh Tempo Sampai Dengan <=1 Tahun", sv(M, 1, 20, DataType.numericDotNegatif)));
		fs.add(sf(3, null, "Rupiah - Jatuh Tempo Sampai Dengan >1-<=5 Tahun",
				sv(M, 1, 20, DataType.numericDotNegatif)));
		fs.add(sf(4, null, "Rupiah - Jatuh Tempo Sampai Dengan >5-<=10 Tahun",
				sv(RequiredCondition.M, 1, 20, DataType.numericDotNegatif)));
		fs.add(sf(5, null, "Rupiah - Jatuh Tempo Sampai Dengan >10 Tahun", sv(M, 1, 20, DataType.numericDotNegatif)));
		fs.add(sf(6, null, "Rupiah - Jatuh Tempo Sampai Dengan - Jumlah", sv(M, 1, 20, DataType.numericDotNegatif))
				.addFieldValidations(ER5029PosLbLpeig5310.genFieldValidation6()));
		fs.add(sf(7, null, "Valas - Jatuh Tempo Sampai Dengan <=1 Tahun", sv(M, 1, 20, DataType.numericDotNegatif)));
		fs.add(sf(8, null, "Valas - Jatuh Tempo Sampai Dengan >1-<=5 Tahun", sv(M, 1, 20, DataType.numericDotNegatif)));
		fs.add(sf(9, null, "Valas - Jatuh Tempo Sampai Dengan >5-<=10 Tahun",
				sv(M, 1, 20, DataType.numericDotNegatif)));
		fs.add(sf(10, null, "Valas - Jatuh Tempo Sampai Dengan >10 Tahun", sv(M, 1, 20, DataType.numericDotNegatif)));
		fs.add(sf(11, null, "Valas - Jatuh Tempo Sampai Dengan - Jumlah", sv(M, 1, 20, DataType.numericDotNegatif))
				.addFieldValidations(ER5029PosLbLpeig5310.genFieldValidation11()));
		fs.add(sf(12, null, "Total", sv(RequiredCondition.C, 1, 20, DataType.numericDotNegatif)
				.confConditionalRequired(ER5029PosLbLpeig5310.genConditionalExist()))
				.addFieldValidations(ER5029PosLbLpeig5310.genFieldValidation12()));
		return res;
	}
}
