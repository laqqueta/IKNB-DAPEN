package id.go.ojk.asrjk.client.builder.field.rb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.O;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asrjk.client.builder.field.EFormRencanaBisnis;
import id.go.ojk.asrjk.client.builder.field.rb.reference.EHeaderMetadataRb;
import id.go.ojk.asrjk.client.builder.field.rb.reference.ER2008PosRbAsrjk0900;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Rb0900 extends BaseMetadata {

	public Rb0900(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRencanaBisnis eEnum = EFormRencanaBisnis.RB_0900;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 0, null);
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataRb.R2008_RB0900.getObject())));
		fs.add(sf(2, null, "Jenis Kantor", sv(O, 0, 1000, all)));
		fs.add(sf(3, null, "Waktu Pelaksanaan",
				sv(C, 0, 1000, all).confConditionalRequired(ER2008PosRbAsrjk0900.genConditionalField())));
		fs.add(sf(4, null, "Lokasi",
				sv(C, 0, 1000, all).confConditionalRequired(ER2008PosRbAsrjk0900.genConditionalField())));
		fs.add(sf(5, null, "Perkiraan Investasi/Biaya",
				sv(C, 0, 16, numeric).confConditionalRequired(ER2008PosRbAsrjk0900.genConditionalField())));
		fs.add(sf(6, null, "Keterangan",
				sv(C, 0, 1000, all).confConditionalRequired(ER2008PosRbAsrjk0900.genConditionalField())));
		return res;
	}
}
