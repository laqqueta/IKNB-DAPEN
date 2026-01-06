package id.go.ojk.pnjk.client.builder.field.lb.uus.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.date;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.config.DataType.numericDot;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.O;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.pnjk.client.builder.field.EFormLaporanBulananUus;
import id.go.ojk.pnjk.client.builder.field.lb.uus.reference.EHeaderMetadataLbUus;
import id.go.ojk.pnjk.client.builder.field.lb.uus.reference.ER3124PosLbPnju3000;

public class Lb3000 extends BaseMetadata {

	public Lb3000(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulananUus eEnum = EFormLaporanBulananUus.LB_3000;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 0, null);
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLbUus.R3124_LB3000.getObject())));
		fs.add(sf(2, null, "Nama Obligasi", sv(M, 1, 100, all)));
		fs.add(sf(3, null, "Nominal", sv(M, 1, 16, numeric)));
		fs.add(sf(4, null, "Premium/Diskonto", sv(M, 1, 16, numeric)));
		fs.add(sf(5, null, "Tingkat Suku Bunga", sv(M, 3, 6, numericDot))
				.addFieldValidations(ER3124PosLbPnju3000.genFieldValidation5()));
		fs.add(sf(6, null, "Jangka Waktu-Mulai", sv(M, 8, 8, date)));
		fs.add(sf(7, null, "Jangka Waktu-Jatuh Tempo", sv(O, 8, 8, date))
				.addFieldValidations(ER3124PosLbPnju3000.genFieldValidation7()));
		fs.add(sf(8, null, "Jangka Waktu-Tenor", sv(M, 1, 8, numeric))
				.addFieldValidations(ER3124PosLbPnju3000.genFieldValidationGreater("1")));
		return res;
	}
}
