package id.go.ojk.fink.client.builder.field.lb.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.patternNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
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
import id.go.ojk.fink.client.builder.field.lb.reference.ER3014PosLbFink6910;

public class Lb6910 extends BaseMetadata {

	public Lb6910(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_6910;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 7, 7, ER3014PosLbFink6910.genFieldSave(), null, ER3014PosLbFink6910.getRequiredPos());
		res.addSegmentValidations(ER3014PosLbFink6910.genValidationDecimal());
		res.addSegmentValidations(ER3014PosLbFink6910.genValidationNumeric());
		res.addSegmentValidations(ER3014PosLbFink6910.genValidation2());
		res.addSegmentValidations(ER3014PosLbFink6910.genValidation6());
		res.addSegmentValidations(ER3014PosLbFink6910.genValidation7());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 12, 12, refTable)
				.confReference(EHeaderMetadataLb.R3014_LB6910.getObject()).confRegex(patternNumeric)).confUnique(U));
		fs.add(sf(2, null, "Rincian", sv(M, 1, 16, all)));
		return res;
	}
}
