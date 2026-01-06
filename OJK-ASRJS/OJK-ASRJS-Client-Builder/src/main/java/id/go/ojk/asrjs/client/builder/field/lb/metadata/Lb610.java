package id.go.ojk.asrjs.client.builder.field.lb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asrjs.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.asrjs.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.asrjs.client.builder.field.reference.EHeaderMetadataShared;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Lb610 extends BaseMetadata {

	public Lb610(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_610;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 0, null);
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3049_LB610.getObject())));
		fs.add(sf(2, null, "Masa Pertanggungan",
				sv(M, 1, 4, refTable).confReference(EHeaderMetadataShared.R027.getObject())));
		fs.add(sf(3, null, "Jenis Polis",
				sv(M, 1, 4, refTable).confReference(EHeaderMetadataShared.R025.getObject())));
		fs.add(sf(4, null, "Jenis Produk",
				sv(M, 1, 4, refTable).confReference(EHeaderMetadataShared.R028.getObject())));
		fs.add(sf(5, null, "Jumlah Polis", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(6, null, "Jumlah Peserta", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(7, null, "Jumlah Uang Pertanggungan", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(8, null, "Penyisihan Kontribusi - Term", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(9, null, "Penyisihan Kontribusi - P.A", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(10, null, "Penyisihan Kontribusi - Health", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(11, null, "Akumulasi Dana", sv(M, 1, 16, numericNegatif)));
		return res;
	}
}
