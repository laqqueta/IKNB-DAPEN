package id.go.ojk.ppk.client.builder.field.rb.uus.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.O;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.ppk.client.builder.field.EFormRealisasiBisnisUus;
import id.go.ojk.ppk.client.builder.field.rb.uus.reference.EHeaderMetadataRbUus;
import id.go.ojk.ppk.client.builder.field.rb.uus.reference.ER2765PosRePpu090203;

public class Re090203 extends BaseMetadata {

	public Re090203(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRealisasiBisnisUus eEnum = EFormRealisasiBisnisUus.RE_090203;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 0, null);
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 14, 14, refTable).confReference(EHeaderMetadataRbUus.R2765_RE090203.getObject())));
		fs.add(sf(2, null, "Nama Tenaga Kerja Asing (apabila ada) / Jumlah Tenaga Kerja Asing", sv(O, 0, 1000, all)));
		fs.add(sf(3, null, "Posisi Jabatan",
				sv(C, 0, 1000, all).confConditionalRequired(ER2765PosRePpu090203.genConditionalField())));
		fs.add(sf(4, null, "Bidang Kerja Penugasan",
				sv(C, 0, 1000, all).confConditionalRequired(ER2765PosRePpu090203.genConditionalField())));
		fs.add(sf(5, null, "Jangka Waktu",
				sv(C, 0, 255, all).confConditionalRequired(ER2765PosRePpu090203.genConditionalField())));
		fs.add(sf(6, null, "Nama Tenaga Pendamping",
				sv(C, 0, 1000, all).confConditionalRequired(ER2765PosRePpu090203.genConditionalField())));
		fs.add(sf(7, null, "Realisasi Program Alih Pengetahuan",
				sv(C, 0, 1000, all).confConditionalRequired(ER2765PosRePpu090203.genConditionalField())));
		fs.add(sf(8, null, "Alasan",
				sv(C, 0, 4000, all).confConditionalRequired(ER2765PosRePpu090203.genConditionalField())));
		return res;
	}
}
