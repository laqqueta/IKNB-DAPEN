package id.go.ojk.reask.client.builder.field.rb.uus.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.O;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.reask.client.builder.field.EFormRencanaBisnisUus;
import id.go.ojk.reask.client.builder.field.rb.uus.reference.EHeaderMetadataRbUus;
import id.go.ojk.reask.client.builder.field.rb.uus.reference.ER2113PosRbReasu0901;

public class Rb0901 extends BaseMetadata {

	public Rb0901(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRencanaBisnisUus eEnum = EFormRencanaBisnisUus.RB_0901;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 4, null);
		res.setRequiredPos(ER2113PosRbReasu0901.getRequiredPos());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataRbUus.R2113_RB0901.getObject())));
		fs.add(sf(2, null, "Jenis Kantor", sv(O, 1, 1000, all)));
		fs.add(sf(3, null, "Waktu Pelaksanaan",
				sv(C, 1, 1000, all).confConditionalRequired(ER2113PosRbReasu0901.genConditionalField())));
		fs.add(sf(4, null, "Lokasi",
				sv(C, 1, 1000, all).confConditionalRequired(ER2113PosRbReasu0901.genConditionalField())));
		fs.add(sf(5, null, "Perkiraan Investasi/Biaya",
				sv(C, 1, 16, numeric).confConditionalRequired(ER2113PosRbReasu0901.genConditionalField())));
		fs.add(sf(6, null, "Keterangan",
				sv(C, 1, 1000, all).confConditionalRequired(ER2113PosRbReasu0901.genConditionalField())));
		return res;
	}
}
