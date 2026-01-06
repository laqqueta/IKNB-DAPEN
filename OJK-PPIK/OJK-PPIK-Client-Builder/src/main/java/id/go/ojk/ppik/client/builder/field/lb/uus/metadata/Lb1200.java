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
import id.go.ojk.ppik.client.builder.field.lb.uus.reference.ER3110PosLbPpiu1200;

public class Lb1200 extends BaseMetadata {

	public Lb1200(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulananUus eEnum = EFormLaporanBulananUus.LB_1200;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 77, 77, ER3110PosLbPpiu1200.genFieldSave(), ER3110PosLbPpiu1200.genFieldSave(),
				ER3110PosLbPpiu1200.getRequiredPos());
		res.addSegmentValidations(ER3110PosLbPpiu1200.genRowValidation02());
		res.addSegmentValidations(ER3110PosLbPpiu1200.genRowValidation03());
		res.addSegmentValidations(ER3110PosLbPpiu1200.genRowValidation04());
		res.addSegmentValidations(ER3110PosLbPpiu1200.genRowValidation05());
		res.addSegmentValidations(ER3110PosLbPpiu1200.genRowValidation13());
		res.addSegmentValidations(ER3110PosLbPpiu1200.genRowValidation20());
		res.addSegmentValidations(ER3110PosLbPpiu1200.genRowValidation26());
		res.addSegmentValidations(ER3110PosLbPpiu1200.genRowValidation32());
		res.addSegmentValidations(ER3110PosLbPpiu1200.genRowValidation36());
		res.addSegmentValidations(ER3110PosLbPpiu1200.genRowValidation37());
		res.addSegmentValidations(ER3110PosLbPpiu1200.genRowValidation38());
		res.addSegmentValidations(ER3110PosLbPpiu1200.genRowValidation43());
		res.addSegmentValidations(ER3110PosLbPpiu1200.genRowValidation48());
		res.addSegmentValidations(ER3110PosLbPpiu1200.genRowValidation49());
		res.addSegmentValidations(ER3110PosLbPpiu1200.genRowValidation58());
		res.addSegmentValidations(ER3110PosLbPpiu1200.genRowValidation68());
		res.addSegmentValidations(ER3110PosLbPpiu1200.genRowValidation71A());
		res.addSegmentValidations(ER3110PosLbPpiu1200.genRowValidation71B());
		res.addSegmentValidations(ER3110PosLbPpiu1200.genRowValidation71C());
		res.addSegmentValidations(ER3110PosLbPpiu1200.genRowValidation71D());
		res.addSegmentValidations(ER3110PosLbPpiu1200.genRowValidation72A());
		res.addSegmentValidations(ER3110PosLbPpiu1200.genRowValidation72B());
		res.addSegmentValidations(ER3110PosLbPpiu1200.genRowValidation72C());
		res.addSegmentValidations(ER3110PosLbPpiu1200.genRowValidation72D());
		res.addSegmentValidations(ER3110PosLbPpiu1200.genRowValidation78());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 16, 16, refTable).confReference(EHeaderMetadataLbUus.R3111_LB1200.getObject())
						.confRegex(patternNumeric)).confUnique(U));
		fs.add(sf(2, null, "Indonesian Rupiah", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "Mata Uang Asing", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Total", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER3110PosLbPpiu1200.genFieldValidation4()));
		return res;
	}
}
