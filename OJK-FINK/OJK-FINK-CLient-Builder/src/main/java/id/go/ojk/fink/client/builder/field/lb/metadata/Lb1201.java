package id.go.ojk.fink.client.builder.field.lb.metadata;

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
import id.go.ojk.fink.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.fink.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.fink.client.builder.field.lb.reference.ER3006PosLbFink1201;

public class Lb1201 extends BaseMetadata {

	public Lb1201(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_1201;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 6, 6, ER3006PosLbFink1201.genFieldSave(), ER3006PosLbFink1201.genFieldSave(),
				ER3006PosLbFink1201.getRequiredPos());
//		res.addSegmentValidations(ER3006PosLbFink1201.genRowValidation2());//disable, request by OJK
		res.addSegmentValidations(ER3006PosLbFink1201.genRowValidation3());
		res.addSegmentValidations(ER3006PosLbFink1201.genRowValidation6());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 12, 12, refTable)
				.confReference(EHeaderMetadataLb.R3006_LB1201.getObject()).confRegex(patternNumeric)).confUnique(U));
		fs.add(sf(2, null, "Nominal", sv(M, 1, 16, numericNegatif)));
		return res;
	}
}
