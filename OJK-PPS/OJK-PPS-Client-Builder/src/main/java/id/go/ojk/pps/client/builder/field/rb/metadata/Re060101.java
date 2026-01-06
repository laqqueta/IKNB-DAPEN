package id.go.ojk.pps.client.builder.field.rb.metadata;

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
import id.go.ojk.pps.client.builder.field.EFormRealisasiBisnis;
import id.go.ojk.pps.client.builder.field.rb.reference.EHeaderMetadataRb;
import id.go.ojk.pps.client.builder.field.rb.reference.ER2258PosRePps060101;

public class Re060101 extends BaseMetadata {

	public Re060101(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRealisasiBisnis eEnum = EFormRealisasiBisnis.RE_060101;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 3, 3, ER2258PosRePps060101.genFieldSave(), null, ER2258PosRePps060101.getRequiredPos());
		res.addSegmentValidations(ER2258PosRePps060101.genValidationNumeric());
		res.addSegmentValidations(ER2258PosRePps060101.genValidationNumericDot());
		res.addSegmentValidations(ER2258PosRePps060101.genValidationFormRasioPermodalan());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 14, 14, refTable).confReference(EHeaderMetadataRb.R2258_RE060101.getObject())).confUnique(U));
		fs.add(sf(2, null, "Proyeksi", sv(M, 1, 16, all)));
		fs.add(sf(3, null, "Realisasi", sv(M, 1, 16, all)));
		fs.add(sf(4, null, "Deviasi", sv(M, 1, 16, all)).addFieldValidations(ER2258PosRePps060101.genValidationSum()));
		return res;
	}
}
