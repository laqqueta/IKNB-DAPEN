package id.go.ojk.lpei.client.builder.field.lb.uus.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.patternNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numericDotNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.lpei.client.builder.field.EFormLaporanBulananUus;
import id.go.ojk.lpei.client.builder.field.lb.uus.reference.EHeaderMetadataLbUus;
import id.go.ojk.lpei.client.builder.field.lb.uus.reference.ER7029PosLbLpeiu5310;

public class Lb5310 extends BaseMetadata {

	public Lb5310(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulananUus eEnum = EFormLaporanBulananUus.LB_5310;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 22, 22);

		res.setRequiredPos(ER7029PosLbLpeiu5310.getRequiredPos());
		res.setUniquePos(ER7029PosLbLpeiu5310.getUniquePos());
		res.setSavePos(ER7029PosLbLpeiu5310.genFieldSave());

		res.addSegmentValidations(ER7029PosLbLpeiu5310.genRowValidation02());
		res.addSegmentValidations(ER7029PosLbLpeiu5310.genRowValidation03());
		res.addSegmentValidations(ER7029PosLbLpeiu5310.genRowValidation04());
		res.addSegmentValidations(ER7029PosLbLpeiu5310.genRowValidation17());
//		res.addSegmentValidations(ER7029PosLbLpeiu5310.genRowValidation21A());
//		res.addSegmentValidations(ER7029PosLbLpeiu5310.genRowValidation21B());
		res.addSegmentValidations(ER7029PosLbLpeiu5310.genRowValidation22A());
		res.addSegmentValidations(ER7029PosLbLpeiu5310.genRowValidation22B());
		res.addSegmentValidations(ER7029PosLbLpeiu5310.genRowValidation23A());
		res.addSegmentValidations(ER7029PosLbLpeiu5310.genRowValidation23B());

		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 14, 14, refTable)
				.confReference(EHeaderMetadataLbUus.R7029_LB5310.getObject()).confRegex(patternNumeric)).confUnique(U));
		fs.add(sf(2, null, "Rupiah, Jatuh Tempo Sampai Dengan  <=1 Tahun", sv(M, 1, 20, numericDotNegatif)));
		fs.add(sf(3, null, "Rupiah, Jatuh Tempo Sampai Dengan >1-<=5 Tahun", sv(M, 1, 20, numericDotNegatif)));
		fs.add(sf(4, null, "Rupiah, Jatuh Tempo Sampai Dengan >5-<=10 Tahun", sv(M, 1, 20, numericDotNegatif)));
		fs.add(sf(5, null, "Rupiah, Jatuh Tempo Sampai Dengan >10 Tahun", sv(M, 1, 20, numericDotNegatif)));
		fs.add(sf(6, null, "Rupiah, Jatuh Tempo Sampai Dengan, Jumlah", sv(M, 1, 20, numericDotNegatif))
				.addFieldValidations(ER7029PosLbLpeiu5310.genFieldValidation6()));
		fs.add(sf(7, null, "Valas, Jatuh Tempo Sampai Dengan  <=1 Tahun", sv(M, 1, 20, numericDotNegatif)));
		fs.add(sf(8, null, "Valas, Jatuh Tempo Sampai Dengan >1-<=5 Tahun", sv(M, 1, 20, numericDotNegatif)));
		fs.add(sf(9, null, "Valas, Jatuh Tempo Sampai Dengan >5-<=10 Tahun", sv(M, 1, 20, numericDotNegatif)));
		fs.add(sf(10, null, "Valas, Jatuh Tempo Sampai Dengan >10 Tahun", sv(M, 1, 20, numericDotNegatif)));
		fs.add(sf(11, null, "Valas, Jatuh Tempo Sampai Dengan, Jumlah", sv(M, 1, 20, numericDotNegatif))
				.addFieldValidations(ER7029PosLbLpeiu5310.genFieldValidation11()));
		fs.add(sf(12, null, "TOTAL, Jatuh Tempo Sampai Dengan  <=1 Tahun", sv(M, 1, 20, numericDotNegatif))
				.addFieldValidations(ER7029PosLbLpeiu5310.genFieldValidation12()));
		fs.add(sf(13, null, "TOTAL, Jatuh Tempo Sampai Dengan >1-<=5 Tahun", sv(M, 1, 20, numericDotNegatif))
				.addFieldValidations(ER7029PosLbLpeiu5310.genFieldValidation13()));
		fs.add(sf(14, null, "TOTAL, Jatuh Tempo Sampai Dengan >5-<=10 Tahun", sv(M, 1, 20, numericDotNegatif))
				.addFieldValidations(ER7029PosLbLpeiu5310.genFieldValidation14()));
		fs.add(sf(15, null, "TOTAL, Jatuh Tempo Sampai Dengan >10 Tahun", sv(M, 1, 20, numericDotNegatif))
				.addFieldValidations(ER7029PosLbLpeiu5310.genFieldValidation15()));
		fs.add(sf(16, null, "TOTAL, Jatuh Tempo Sampai Dengan, Jumlah", sv(M, 1, 20, numericDotNegatif))
				.addFieldValidations(ER7029PosLbLpeiu5310.genFieldValidation16()));
		return res;
	}
}
