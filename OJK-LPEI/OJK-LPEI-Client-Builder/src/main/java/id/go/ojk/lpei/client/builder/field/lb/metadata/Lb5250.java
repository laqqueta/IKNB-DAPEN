package id.go.ojk.lpei.client.builder.field.lb.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.patternNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.lpei.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.lpei.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.lpei.client.builder.field.lb.reference.ER5028PosLbLpeig5250;

public class Lb5250 extends BaseMetadata {

	public Lb5250(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_5250;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(), extension, 74, 74);

		res.setRequiredPos(ER5028PosLbLpeig5250.getRequiredPos());
		res.setUniquePos(ER5028PosLbLpeig5250.getUniquePos());
		res.setSavePos(ER5028PosLbLpeig5250.genFieldSave());
		res.setSavePosForm(ER5028PosLbLpeig5250.genFieldSave());

		res.addSegmentValidations(ER5028PosLbLpeig5250.genRowValidation02());
		res.addSegmentValidations(ER5028PosLbLpeig5250.genRowValidation03());
		res.addSegmentValidations(ER5028PosLbLpeig5250.genRowValidation04());
		res.addSegmentValidations(ER5028PosLbLpeig5250.genRowValidation05());
		res.addSegmentValidations(ER5028PosLbLpeig5250.genRowValidation06());
		res.addSegmentValidations(ER5028PosLbLpeig5250.genRowValidation07());
		res.addSegmentValidations(ER5028PosLbLpeig5250.genRowValidation08());
		res.addSegmentValidations(ER5028PosLbLpeig5250.genRowValidation09());
		res.addSegmentValidations(ER5028PosLbLpeig5250.genRowValidation10());
		res.addSegmentValidations(ER5028PosLbLpeig5250.genRowValidation11());
		res.addSegmentValidations(ER5028PosLbLpeig5250.genRowValidation12A());
		res.addSegmentValidations(ER5028PosLbLpeig5250.genRowValidation12B());
		res.addSegmentValidations(ER5028PosLbLpeig5250.genRowValidation15());
		res.addSegmentValidations(ER5028PosLbLpeig5250.genRowValidation16());
		res.addSegmentValidations(ER5028PosLbLpeig5250.genRowValidation17());
		res.addSegmentValidations(ER5028PosLbLpeig5250.genRowValidation18());
		res.addSegmentValidations(ER5028PosLbLpeig5250.genRowValidation21());
		res.addSegmentValidations(ER5028PosLbLpeig5250.genRowValidation22());
		res.addSegmentValidations(ER5028PosLbLpeig5250.genRowValidation25());
		res.addSegmentValidations(ER5028PosLbLpeig5250.genRowValidation26());
		res.addSegmentValidations(ER5028PosLbLpeig5250.genRowValidation27());
		res.addSegmentValidations(ER5028PosLbLpeig5250.genRowValidation28());
		res.addSegmentValidations(ER5028PosLbLpeig5250.genRowValidation29());
		res.addSegmentValidations(ER5028PosLbLpeig5250.genRowValidation30());
		res.addSegmentValidations(ER5028PosLbLpeig5250.genRowValidation33());
		res.addSegmentValidations(ER5028PosLbLpeig5250.genRowValidation34());
		res.addSegmentValidations(ER5028PosLbLpeig5250.genRowValidation38A());
		res.addSegmentValidations(ER5028PosLbLpeig5250.genRowValidation38B());
		res.addSegmentValidations(ER5028PosLbLpeig5250.genRowValidation44());
		res.addSegmentValidations(ER5028PosLbLpeig5250.genRowValidation50());
		res.addSegmentValidations(ER5028PosLbLpeig5250.genRowValidation56());
		res.addSegmentValidations(ER5028PosLbLpeig5250.genRowValidation61());

		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 14, 14, refTable)
				.confReference(EHeaderMetadataLb.R5028_LB5250.getObject())
				.confRegex(patternNumeric)));
		fs.add(sf(2, null, "USD - Dalam Mata Uang Asal", sv(M, 1, 20, numericNegatif)
				.confRegex(SimpleValidation.patternNumericDotNegatif)));
		fs.add(sf(3, null, "USD - Dalam Ekuivalen Rupiah", sv(M, 1, 20, numericNegatif)));
		fs.add(sf(4, null, "EUR - Dalam Mata Uang Asal", sv(M, 1, 20, numericNegatif)
				.confRegex(SimpleValidation.patternNumericDotNegatif)));
		fs.add(sf(5, null, "EUR - Dalam Ekuivalen Rupiah", sv(M, 1, 20, numericNegatif)));
		fs.add(sf(6, null, "JYP - Dalam Mata Uang Asal", sv(M, 1, 20, numericNegatif)
				.confRegex(SimpleValidation.patternNumericDotNegatif)));
		fs.add(sf(7, null, "JYP - Dalam Ekuivalen Rupiah", sv(M, 1, 20, numericNegatif)));
		fs.add(sf(8, null, "SGD - Dalam Mata Uang Asal", sv(M, 1, 20, numericNegatif)
				.confRegex(SimpleValidation.patternNumericDotNegatif)));
		fs.add(sf(9, null, "SGD - Dalam Ekuivalen Rupiah", sv(M, 1, 20, numericNegatif)));
		fs.add(sf(10, null, "Total Dalam Ekuivalen", sv(M, 1, 20, numericNegatif))
				.addFieldValidations(ER5028PosLbLpeig5250.genFieldValidation10()));
		return res;
	}
}
