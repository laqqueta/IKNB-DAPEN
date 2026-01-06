package id.go.ojk.dppks.client.builder.field.rb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.DataType.yearMonth;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.O;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.dppks.client.builder.field.EFormRencanaBisnis;
import id.go.ojk.dppks.client.builder.field.rb.reference.EHeaderMetadataRb;
import id.go.ojk.dppks.client.builder.field.rb.reference.ER2005PosRbDppks0600;

public class Rb0600 extends BaseMetadata {

	public Rb0600(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRencanaBisnis eEnum = EFormRencanaBisnis.RB_0600;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 0, null);
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataRb.R2005_RB0600.getObject())));
		fs.add(sf(2, null, "Jenis Manfaat Lain", sv(O, 0, 300, all)));
		fs.add(sf(3, null, "Deskripsi Umum Manfaat Lain",
				sv(C, 0, 300, all).confConditionalRequired(ER2005PosRbDppks0600.genConditionalAllExist())));
		fs.add(sf(4, null, "Waktu Pelaksanaan Manfaat Lain",
				sv(C, 0, 6, yearMonth).confConditionalRequired(ER2005PosRbDppks0600.genConditionalAllExist())));
		fs.add(sf(5, null, "Tujuan Manfaat Lain",
				sv(C, 0, 300, all).confConditionalRequired(ER2005PosRbDppks0600.genConditionalAllExist())));
		fs.add(sf(6, null, "Risiko atas Pelaksanaan Manfaat Lain",
				sv(C, 0, 300, all).confConditionalRequired(ER2005PosRbDppks0600.genConditionalAllExist())));
		fs.add(sf(7, null, "Mitigasi Risiko atas Pelaksanaan Manfaat Lain",
				sv(C, 0, 300, all).confConditionalRequired(ER2005PosRbDppks0600.genConditionalAllExist())));
		fs.add(sf(8, null, "Alasan dan Pertimbangan",
				sv(C, 0, 300, all).confConditionalRequired(ER2005PosRbDppks0600.genConditionalAllExist())));
		fs.add(sf(9, null, "Strategi",
				sv(C, 0, 300, all).confConditionalRequired(ER2005PosRbDppks0600.genConditionalAllExist())));
		return res;
	}
}
