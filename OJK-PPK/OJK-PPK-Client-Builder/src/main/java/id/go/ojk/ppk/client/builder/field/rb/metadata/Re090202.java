package id.go.ojk.ppk.client.builder.field.rb.metadata;

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
import id.go.ojk.ppk.client.builder.field.EFormRealisasiBisnis;
import id.go.ojk.ppk.client.builder.field.rb.reference.EHeaderMetadataRb;
import id.go.ojk.ppk.client.builder.field.rb.reference.ER2263PosRePpk090202;

public class Re090202 extends BaseMetadata {

	public Re090202(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRealisasiBisnis eEnum = EFormRealisasiBisnis.RE_090202;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 0, null);
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 14, 14, refTable).confReference(EHeaderMetadataRb.R2263_RE090202.getObject())));
		fs.add(sf(2, null, "Materi/Topik", sv(O, 0, 1000, all)));
		fs.add(sf(3, null, "Metode Diklat",
				sv(C, 0, 1000, all).confConditionalRequired(ER2263PosRePpk090202.genConditionalField())));
		fs.add(sf(4, null, "Waktu Diklat",
				sv(C, 0, 25, all).confConditionalRequired(ER2263PosRePpk090202.genConditionalField())));
		fs.add(sf(5, null, "Durasi Diklat",
				sv(C, 0, 1000, all).confConditionalRequired(ER2263PosRePpk090202.genConditionalField())));
		fs.add(sf(6, null, "Tempat",
				sv(C, 0, 1000, all).confConditionalRequired(ER2263PosRePpk090202.genConditionalField())));
		fs.add(sf(7, null, "Narasumber/Lembaga Diklat",
				sv(C, 0, 1000, all).confConditionalRequired(ER2263PosRePpk090202.genConditionalField())));
		fs.add(sf(8, null, "Jumlah Seluruh Peserta",
				sv(C, 0, 10, numeric).confConditionalRequired(ER2263PosRePpk090202.genConditionalField())));
		fs.add(sf(9, null, "Biaya Diklat",
				sv(C, 0, 16, numeric).confConditionalRequired(ER2263PosRePpk090202.genConditionalField())));
		return res;
	}
}
