package id.go.ojk.pmvk.client.builder.field.rb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
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
import id.go.ojk.pmvk.client.builder.field.EFormRealisasiBisnis;
import id.go.ojk.pmvk.client.builder.field.rb.reference.EHeaderMetadataRb;
import id.go.ojk.pmvk.client.builder.field.rb.reference.ER2260PosRePmvk090202;
import id.go.ojk.pmvk.client.builder.field.reference.EHeaderMetadataShared;

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
				sv(M, 14, 14, refTable).confReference(EHeaderMetadataRb.R2260_RE090202.getObject())));
		fs.add(sf(2, null, "Materi Diklat", sv(O, 0, 1000, all)));
		fs.add(sf(3, null, "Metode Diklat", sv(C, 0, 10, refTable).confReference(EHeaderMetadataShared.R007.getObject())
				.confConditionalRequired(ER2260PosRePmvk090202.genConditionalField())));
		fs.add(sf(4, null, "Realisasi Waktu Diklat",
				sv(C, 0, 6, yearMonth).confConditionalRequired(ER2260PosRePmvk090202.genConditionalField())));
		fs.add(sf(5, null, "Durasi Diklat",
				sv(C, 0, 1000, all).confConditionalRequired(ER2260PosRePmvk090202.genConditionalField())));
		fs.add(sf(6, null, "Tempat",
				sv(C, 0, 1000, all).confConditionalRequired(ER2260PosRePmvk090202.genConditionalField())));
		fs.add(sf(7, null, "Narasumber/Lembaga Diklat",
				sv(C, 0, 1000, all).confConditionalRequired(ER2260PosRePmvk090202.genConditionalField())));
		fs.add(sf(8, null, "Jumlah Seluruh Peserta",
				sv(C, 0, 1000, numericNegatif).confConditionalRequired(ER2260PosRePmvk090202.genConditionalField())));
		fs.add(sf(9, null, "Rencana Biaya Diklat",
				sv(C, 0, 16, numericNegatif).confConditionalRequired(ER2260PosRePmvk090202.genConditionalField())));
		fs.add(sf(10, null, "Realisasi Biaya Diklat",
				sv(C, 0, 16, numericNegatif).confConditionalRequired(ER2260PosRePmvk090202.genConditionalField())));
		fs.add(sf(11, null, "Deviasi",
				sv(C, 0, 16, numericNegatif).confConditionalRequired(ER2260PosRePmvk090202.genConditionalField()))
				.addFieldValidations(ER2260PosRePmvk090202.genValidationField11()));
		return res;
	}
}
