package id.go.ojk.reass.client.builder.field.lb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.numericDotNegatif;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.reass.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.reass.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.reass.client.builder.field.lb.reference.ER3020PosLbReass212;
import id.go.ojk.reass.client.builder.field.reference.EHeaderMetadataShared;

public class Lb212 extends BaseMetadata {

	public Lb212(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_212;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 0, null);
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3020_LB212.getObject())));
		fs.add(sf(2, null, "Jenis Reasuradur",
				sv(M, 1, 4, refTable).confReference(EHeaderMetadataShared.R002.getObject())));
		fs.add(sf(3, null, "Nama Reasuradur", sv(M, 1, 50, all)));
		fs.add(sf(4, null, "Penyisihan Teknis Beban Reasuradur", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(5, null, "Deposit dan atau Kontribusi yang ditahan di Perusahaan", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(6, null, "Eksposur Reasuransi Netto ((2)-(3))", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER3020PosLbReass212.genValidation6()));
		fs.add(sf(7, null, "Faktor", sv(M, 1, 6, numericDotNegatif))
				.addFieldValidations(ER3020PosLbReass212.genValidation7()));
		fs.add(sf(8, null, "Jumlah Deviasi", sv(M, 1, 19, numericNegatif))
				.addFieldValidations(ER3020PosLbReass212.genValidation8()));
		return res;
	}
}
