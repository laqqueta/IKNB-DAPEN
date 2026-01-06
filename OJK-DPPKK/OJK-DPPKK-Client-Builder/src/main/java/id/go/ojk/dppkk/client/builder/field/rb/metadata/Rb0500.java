package id.go.ojk.dppkk.client.builder.field.rb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.dppkk.client.builder.field.EFormRencanaBisnis;
import id.go.ojk.dppkk.client.builder.field.rb.reference.EHeaderMetadataRb;
import id.go.ojk.dppkk.client.builder.field.rb.reference.ER2004PosRbDppkk0500;

public class Rb0500 extends BaseMetadata {

	public Rb0500(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRencanaBisnis eEnum = EFormRencanaBisnis.RB_0500;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 22, 22, ER2004PosRbDppkk0500.genFieldSave(), null, ER2004PosRbDppkk0500.getRequiredPos());
		res.addSegmentValidations(ER2004PosRbDppkk0500.genValidationInvestasi());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataRb.R2004_RB0500.getObject())).confUnique(U));
		fs.add(sf(2, null, "Hasil Investasi Real", sv(M, 1, 20, numericNegatif)));
		fs.add(sf(3, null, "Hasil Investasi Unreal", sv(M, 1, 20, numericNegatif)));
		fs.add(sf(4, null, "Beban Investasi", sv(M, 1, 20, numericNegatif)));
		fs.add(sf(5, null, "Hasil Investasi Bersih", sv(M, 1, 20, numericNegatif))
				.addFieldValidations(ER2004PosRbDppkk0500.genValidationSumEqual5()));
		fs.add(sf(6, null, "Hasil Investasi Real", sv(M, 1, 20, numericNegatif)));
		fs.add(sf(7, null, "Hasil Investasi Unreal", sv(M, 1, 20, numericNegatif)));
		fs.add(sf(8, null, "Beban Investasi", sv(M, 1, 20, numericNegatif)));
		fs.add(sf(9, null, "Hasil Investasi Bersih", sv(M, 1, 20, numericNegatif))
				.addFieldValidations(ER2004PosRbDppkk0500.genValidationSumEqual9()));
		fs.add(sf(10, null, "Hasil Investasi Real", sv(M, 1, 20, numericNegatif)));
		fs.add(sf(11, null, "Hasil Investasi Unreal", sv(M, 1, 20, numericNegatif)));
		fs.add(sf(12, null, "Beban Investasi", sv(M, 1, 20, numericNegatif)));
		fs.add(sf(13, null, "Hasil Investasi Bersih", sv(M, 1, 20, numericNegatif))
				.addFieldValidations(ER2004PosRbDppkk0500.genValidationSumEqual13()));
		fs.add(sf(14, null, "Hasil Investasi Real", sv(M, 1, 20, numericNegatif)));
		fs.add(sf(15, null, "Hasil Investasi Unreal", sv(M, 1, 20, numericNegatif)));
		fs.add(sf(16, null, "Beban Investasi", sv(M, 1, 20, numericNegatif)));
		fs.add(sf(17, null, "Hasil Investasi Bersih", sv(M, 1, 20, numericNegatif))
				.addFieldValidations(ER2004PosRbDppkk0500.genValidationSumEqual17()));
		return res;
	}
}
