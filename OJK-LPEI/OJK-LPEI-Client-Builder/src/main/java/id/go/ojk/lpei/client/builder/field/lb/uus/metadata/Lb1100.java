package id.go.ojk.lpei.client.builder.field.lb.uus.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.patternNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.lpei.client.builder.field.EFormLaporanBulananUus;
import id.go.ojk.lpei.client.builder.field.lb.uus.reference.EHeaderMetadataLbUus;
import id.go.ojk.lpei.client.builder.field.lb.uus.reference.ER7007PosLbLpeiu1100;

public class Lb1100 extends BaseMetadata {

	public Lb1100(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulananUus eEnum = EFormLaporanBulananUus.LB_1100;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 75, 75);

		res.setRequiredPos(ER7007PosLbLpeiu1100.getRequiredPos());
		res.setUniquePos(ER7007PosLbLpeiu1100.getUniquePos());
		res.setSavePos(ER7007PosLbLpeiu1100.genFieldSave());
		res.setSavePosForm(ER7007PosLbLpeiu1100.genFieldSave());

		res.addSegmentValidations(ER7007PosLbLpeiu1100.genRowValidation04());
		res.addSegmentValidations(ER7007PosLbLpeiu1100.genRowValidation05());
		res.addSegmentValidations(ER7007PosLbLpeiu1100.genRowValidation07());
		res.addSegmentValidations(ER7007PosLbLpeiu1100.genRowValidation07B());
		res.addSegmentValidations(ER7007PosLbLpeiu1100.genRowValidation08());
		res.addSegmentValidations(ER7007PosLbLpeiu1100.genRowValidation09());
		res.addSegmentValidations(ER7007PosLbLpeiu1100.genRowValidation10());
		res.addSegmentValidations(ER7007PosLbLpeiu1100.genRowValidation11());
		res.addSegmentValidations(ER7007PosLbLpeiu1100.genRowValidation12());
		res.addSegmentValidations(ER7007PosLbLpeiu1100.genRowValidation13());
		res.addSegmentValidations(ER7007PosLbLpeiu1100.genRowValidation14());
		res.addSegmentValidations(ER7007PosLbLpeiu1100.genRowValidation15());
		res.addSegmentValidations(ER7007PosLbLpeiu1100.genRowValidation16());
		res.addSegmentValidations(ER7007PosLbLpeiu1100.genRowValidation17());
		res.addSegmentValidations(ER7007PosLbLpeiu1100.genRowValidation20());
		res.addSegmentValidations(ER7007PosLbLpeiu1100.genRowValidation22());
		res.addSegmentValidations(ER7007PosLbLpeiu1100.genRowValidation26());
		res.addSegmentValidations(ER7007PosLbLpeiu1100.genRowValidation28());
		res.addSegmentValidations(ER7007PosLbLpeiu1100.genRowValidation30());
		res.addSegmentValidations(ER7007PosLbLpeiu1100.genRowValidation33());
		res.addSegmentValidations(ER7007PosLbLpeiu1100.genRowValidation41());
		res.addSegmentValidations(ER7007PosLbLpeiu1100.genRowValidation42());
//		res.addSegmentValidations(ER7007PosLbLpeiu1100.genRowValidation42B());
		res.addSegmentValidations(ER7007PosLbLpeiu1100.genRowValidation44());
		res.addSegmentValidations(ER7007PosLbLpeiu1100.genRowValidation45());
		res.addSegmentValidations(ER7007PosLbLpeiu1100.genRowValidation46());
		res.addSegmentValidations(ER7007PosLbLpeiu1100.genRowValidation48());
		res.addSegmentValidations(ER7007PosLbLpeiu1100.genRowValidation50());
		res.addSegmentValidations(ER7007PosLbLpeiu1100.genRowValidation56());
		res.addSegmentValidations(ER7007PosLbLpeiu1100.genRowValidation57());
		res.addSegmentValidations(ER7007PosLbLpeiu1100.genRowValidation60());
		res.addSegmentValidations(ER7007PosLbLpeiu1100.genRowValidation61());
		res.addSegmentValidations(ER7007PosLbLpeiu1100.genRowValidation65A());
		res.addSegmentValidations(ER7007PosLbLpeiu1100.genRowValidation65B());
		res.addSegmentValidations(ER7007PosLbLpeiu1100.genRowValidation67());
		res.addSegmentValidations(ER7007PosLbLpeiu1100.genRowValidation68());
		res.addSegmentValidations(ER7007PosLbLpeiu1100.genRowValidation74A());
		res.addSegmentValidations(ER7007PosLbLpeiu1100.genRowValidation74B());
		res.addSegmentValidations(ER7007PosLbLpeiu1100.genRowValidation75());
		res.addSegmentValidations(ER7007PosLbLpeiu1100.genRowValidation76());

		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 14, 14, refTable)
				.confReference(EHeaderMetadataLbUus.R7007_LB1100.getObject()).confRegex(patternNumeric)));
		fs.add(sf(2, null, "Rupiah", sv(M, 1, 20, numericNegatif)));
		fs.add(sf(3, null, "Valas", sv(M, 1, 20, numericNegatif)));
		fs.add(sf(4, null, "Jumlah", sv(M, 1, 20, numericNegatif))
				.addFieldValidations(ER7007PosLbLpeiu1100.genFieldValidation04()));
		return res;
	}
}
