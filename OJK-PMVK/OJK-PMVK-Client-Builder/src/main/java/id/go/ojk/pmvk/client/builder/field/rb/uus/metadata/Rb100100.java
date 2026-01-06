package id.go.ojk.pmvk.client.builder.field.rb.uus.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.pmvk.client.builder.field.EFormRencanaBisnisUus;
import id.go.ojk.pmvk.client.builder.field.rb.uus.reference.EHeaderMetadataRbUus;
import id.go.ojk.pmvk.client.builder.field.rb.uus.reference.ER2513PosRbPmvu100100;

public class Rb100100 extends BaseMetadata {

	public Rb100100(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRencanaBisnisUus eEnum = EFormRencanaBisnisUus.RB_100100;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 10, null, null, null, ER2513PosRbPmvu100100.getRequiredPos());
		res.addSegmentValidations(ER2513PosRbPmvu100100.genValidationNumeric());
		res.addSegmentValidations(ER2513PosRbPmvu100100.genValidationNumericDot());
		res.addSegmentValidations(ER2513PosRbPmvu100100.genValidationMaxLengthNumeric());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 14, 14, refTable).confReference(EHeaderMetadataRbUus.R2513_RB100100.getObject())));
		fs.add(sf(2, null, "Asumsi Lainnya",
				sv(C, 0, 200, all).confConditionalRequired(ER2513PosRbPmvu100100.genConditionalMustEmpty())));
		fs.add(sf(3, null, "Kinerja Sept XX-1", sv(M, 1, 200, all)));
		fs.add(sf(4, null, "Proyeksi - Desember XX-1", sv(M, 1, 200, all)));
		fs.add(sf(5, null, "Proyeksi - Juni xx", sv(M, 1, 200, all)));
		fs.add(sf(6, null, "Proyeksi - Desember xx", sv(M, 1, 200, all)));
		return res;
	}
}
