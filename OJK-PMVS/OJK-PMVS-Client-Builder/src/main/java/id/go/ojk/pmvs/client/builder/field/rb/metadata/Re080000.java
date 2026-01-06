package id.go.ojk.pmvs.client.builder.field.rb.metadata;

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
import id.go.ojk.pmvs.client.builder.field.EFormRealisasiBisnis;
import id.go.ojk.pmvs.client.builder.field.rb.reference.EHeaderMetadataRb;
import id.go.ojk.pmvs.client.builder.field.rb.reference.ER2259PosRePmvs080000;
import id.go.ojk.pmvs.client.builder.field.reference.EHeaderMetadataShared;

public class Re080000 extends BaseMetadata {

	public Re080000(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRealisasiBisnis eEnum = EFormRealisasiBisnis.RE_080000;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 0, null);
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 14, 14, refTable).confReference(EHeaderMetadataRb.R2259_RE080000.getObject())));
		fs.add(sf(2, null, "Rencana Pengembangan/Perubahan Kantor",
				sv(O, 0, 10, refTable).confReference(EHeaderMetadataShared.R005.getObject())));
		fs.add(sf(3, null, "Jenis Kantor",
				sv(C, 0, 10, refTable).confReference(EHeaderMetadataShared.R006.getObject())
						.confConditionalRequired(ER2259PosRePmvs080000.genConditionalField3()))
				.addFieldValidations(ER2259PosRePmvs080000.genValidationField3()));
		fs.add(sf(4, null, "Waktu Pelaksanaan",
				sv(C, 0, 6, yearMonth).confConditionalRequired(ER2259PosRePmvs080000.genConditionalField4())));
		fs.add(sf(5, null, "Rencana Investasi/Biaya",
				sv(C, 0, 16, numericNegatif).confConditionalRequired(ER2259PosRePmvs080000.genConditionalField5())));
		fs.add(sf(6, null, "Realisasi Investasi/Biaya",
				sv(C, 0, 16, numericNegatif).confConditionalRequired(ER2259PosRePmvs080000.genConditionalField6())));
		fs.add(sf(7, null, "Deviasi",
				sv(C, 0, 16, numericNegatif).confConditionalRequired(ER2259PosRePmvs080000.genConditionalField7()))
				.addFieldValidations(ER2259PosRePmvs080000.genValidationField7()));
		fs.add(sf(8, null, "Lokasi",
				sv(C, 0, 10, refTable).confConditionalRequired(ER2259PosRePmvs080000.genConditionalField8())
						.confReference(EHeaderMetadataShared.R002.getObject())));
		fs.add(sf(9, null, "Keterangan",
				sv(C, 0, 1000, all).confConditionalRequired(ER2259PosRePmvs080000.genConditionalField9())));
		return res;
	}
}
