package id.go.ojk.ppik.client.builder.field.lb.uus.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.patternNumeric;
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
import id.go.ojk.ppik.client.builder.field.EFormLaporanBulananUus;
import id.go.ojk.ppik.client.builder.field.lb.uus.reference.EHeaderMetadataLbUus;
import id.go.ojk.ppik.client.builder.field.lb.uus.reference.ER3109PosLbPpiu1110;

public class Lb1110 extends BaseMetadata {

	public Lb1110(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulananUus eEnum = EFormLaporanBulananUus.LB_1110;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 27, 27, ER3109PosLbPpiu1110.genFieldSave(), null, ER3109PosLbPpiu1110.getRequiredPos());
		res.addSegmentValidations(ER3109PosLbPpiu1110.genRowValidation02());
		res.addSegmentValidations(ER3109PosLbPpiu1110.genRowValidation03());
		res.addSegmentValidations(ER3109PosLbPpiu1110.genRowValidation07());
		res.addSegmentValidations(ER3109PosLbPpiu1110.genRowValidation10());
		res.addSegmentValidations(ER3109PosLbPpiu1110.genRowValidation14());
		res.addSegmentValidations(ER3109PosLbPpiu1110.genRowValidation17A());
		res.addSegmentValidations(ER3109PosLbPpiu1110.genRowValidation17B());
		res.addSegmentValidations(ER3109PosLbPpiu1110.genRowValidation18A());
		res.addSegmentValidations(ER3109PosLbPpiu1110.genRowValidation18B());
		res.addSegmentValidations(ER3109PosLbPpiu1110.genRowValidation19A());
		res.addSegmentValidations(ER3109PosLbPpiu1110.genRowValidation19B());
		res.addSegmentValidations(ER3109PosLbPpiu1110.genRowValidation20A());
		res.addSegmentValidations(ER3109PosLbPpiu1110.genRowValidation20B());
		res.addSegmentValidations(ER3109PosLbPpiu1110.genRowValidation21A());
		res.addSegmentValidations(ER3109PosLbPpiu1110.genRowValidation21B());
		res.addSegmentValidations(ER3109PosLbPpiu1110.genRowValidation23());
		res.addSegmentValidations(ER3109PosLbPpiu1110.genRowValidation28());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 14, 14, refTable).confReference(EHeaderMetadataLbUus.R3110_LB1110.getObject())
						.confRegex(patternNumeric)).confUnique(U));
		fs.add(sf(2, null, "Indonesian Rupiah", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "Mata Uang Asing", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Total", sv(M, 1, 16, numericNegatif)).addFieldValidations(ER3109PosLbPpiu1110.genFieldValidation4()));
		return res;
	}
}
