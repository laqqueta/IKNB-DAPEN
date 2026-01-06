package id.go.ojk.ppk.client.builder.field.rb.uus.metadata;

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
import id.go.ojk.ppk.client.builder.field.EFormRencanaBisnisUus;
import id.go.ojk.ppk.client.builder.field.rb.uus.reference.EHeaderMetadataRbUus;
import id.go.ojk.ppk.client.builder.field.rb.uus.reference.ER2508PosRbPpu060101;

public class Rb060101 extends BaseMetadata {

	public Rb060101(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRencanaBisnisUus eEnum = EFormRencanaBisnisUus.RB_060101;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 3, 3, ER2508PosRbPpu060101.genFieldSave(), null, ER2508PosRbPpu060101.getRequiredPos());
		res.addSegmentValidations(ER2508PosRbPpu060101.genValidationNumeric());
		res.addSegmentValidations(ER2508PosRbPpu060101.genValidationNumericDot());
		res.addSegmentValidations(ER2508PosRbPpu060101.genValidationFormRasioPermodalan());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 14, 14, refTable).confReference(EHeaderMetadataRbUus.R2508_RB060101.getObject())).confUnique(U));
		fs.add(sf(2, null, "Kinerja Sept XX-1", sv(M, 0, 16, all)));
		fs.add(sf(3, null, "Proyeksi - Desember XX-1", sv(M, 0, 16, all)));
		fs.add(sf(4, null, "Proyeksi - Juni xx", sv(M, 0, 16, all)));
		fs.add(sf(5, null, "Proyeksi - Desember xx", sv(M, 0, 16, all)));
		return res;
	}
}
