package id.go.ojk.asrjk.client.builder.field.rb.uus.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asrjk.client.builder.field.EFormRencanaBisnisUus;
import id.go.ojk.asrjk.client.builder.field.rb.uus.reference.EHeaderMetadataRbUus;
import id.go.ojk.asrjk.client.builder.field.rb.uus.reference.ER2100PosRbAsrju0101;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Rb0101 extends BaseMetadata {

	public Rb0101(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRencanaBisnisUus eEnum = EFormRencanaBisnisUus.RB_0101;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 15, 15, null, null, ER2100PosRbAsrju0101.getRequiredPos());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataRbUus.R2100_RB0101.getObject())).confUnique(U));
		fs.add(sf(2, null, "Kinerja Sept XX-1", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "Proyeksi - Desember XX-1", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Proyeksi - Juni", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(5, null, "Proyeksi - Desember", sv(M, 1, 16, numericNegatif)));
		return res;
	}
}
