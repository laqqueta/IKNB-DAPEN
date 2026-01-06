package id.go.ojk.fink.client.builder.field.lb.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.patternAlfaNumeric;
import static id.go.ojk.client.model.config.SimpleValidation.patternNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.fink.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.fink.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.fink.client.builder.field.reference.EHeaderMetadataShared;

public class Lb0001 extends BaseMetadata {

	public Lb0001(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_0001;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 0, null);
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 12, 12, refTable)
				.confReference(EHeaderMetadataLb.R3001_LB0001.getObject()).confRegex(patternNumeric)));
		fs.add(sf(2, null, "Sandi Bank (Escrow)", sv(M, 1, 3, refTable)
				.confReference(EHeaderMetadataShared.R003.getObject()).confRegex(patternAlfaNumeric)));
		fs.add(sf(3, null, "Nama Bank", sv(M, 1, 100, all)));
		fs.add(sf(4, null, "Nomor Rekening", sv(M, 1, 20, alfaNumeric)));
		fs.add(sf(5, null, "Saldo Awal Bulan (Rp)", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(6, null, "Total Debit (Rp)", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(7, null, "Total Kredit (Rp)", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(8, null, "Saldo Akhir Bulan (Rp)", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(9, null, "Hak Lender (Rp)", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(10, null, "Hak Borrower (Rp)", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(11, null, "Hak Pihak Ketiga (Rp)", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(12, null, "Hak Platform (Rp)", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(13, null, "Keterangan", sv(M, 1, 100, all)));
		return res;
	}
}
