package id.go.ojk.dppkk.client.builder.field.rb.metadata;

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
import id.go.ojk.dppkk.client.builder.field.EFormRencanaBisnis;
import id.go.ojk.dppkk.client.builder.field.rb.reference.EHeaderMetadataRb;
import id.go.ojk.dppkk.client.builder.field.rb.reference.ER2012PosRbDppkk1300;

public class Rb1300 extends BaseMetadata {

	public Rb1300(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRencanaBisnis eEnum = EFormRencanaBisnis.RB_1300;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 0, null);
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataRb.R2012_RB1300.getObject())));
		fs.add(sf(2, null, "Jenis Kantor", sv(O, 0, 200, all)));
		fs.add(sf(3, null, "Waktu Pelaksanaan",
				sv(C, 1, 6, yearMonth).confConditionalRequired(ER2012PosRbDppkk1300.genConditionalAllExist())));
		fs.add(sf(4, null, "Lokasi",
				sv(C, 1, 200, all).confConditionalRequired(ER2012PosRbDppkk1300.genConditionalAllExist())));
		fs.add(sf(5, null, "Keterangan",
				sv(C, 1, 300, all).confConditionalRequired(ER2012PosRbDppkk1300.genConditionalAllExist())));
		return res;
	}
}
