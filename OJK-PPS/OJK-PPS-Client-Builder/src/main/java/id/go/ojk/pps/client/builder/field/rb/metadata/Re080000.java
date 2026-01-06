package id.go.ojk.pps.client.builder.field.rb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.date;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.O;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.pps.client.builder.field.EFormRealisasiBisnis;
import id.go.ojk.pps.client.builder.field.rb.reference.EHeaderMetadataRb;
import id.go.ojk.pps.client.builder.field.rb.reference.ER2263PosRePps080000;
import id.go.ojk.pps.client.builder.field.reference.EHeaderMetadataShared;

public class Re080000 extends BaseMetadata {

	public Re080000(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRealisasiBisnis eEnum = EFormRealisasiBisnis.RE_080000;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 0, null, ER2263PosRePps080000.genFieldSave());
		res.addSegmentValidations(ER2263PosRePps080000.genValidationUnique());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 14, 14, refTable).confReference(EHeaderMetadataRb.R2263_RE080000.getObject())));
		fs.add(sf(2, null, "Rencana Pengembangan/Perubahan",
				sv(O, 0, 6, refTable).confReference(EHeaderMetadataShared.R004.getObject())));
		fs.add(sf(3, null, "Jenis Kantor",
				sv(C, 0, 5, refTable).confReference(EHeaderMetadataShared.R005.getObject())
						.confConditionalRequired(ER2263PosRePps080000.genConditionalField3()))
				.addFieldValidations(ER2263PosRePps080000.genValidationField3()));
		fs.add(sf(4, null, "Waktu Pelaksanaan",
				sv(C, 0, 8, date).confConditionalRequired(ER2263PosRePps080000.genConditionalField4())));
		fs.add(sf(5, null, "Perkiraan Investasi/Biaya",
				sv(C, 0, 16, numericNegatif).confConditionalRequired(ER2263PosRePps080000.genConditionalField5())));
		fs.add(sf(6, null, "Lokasi", sv(C, 0, 8, refTable).confReference(EHeaderMetadataShared.R006.getObject())
				.confConditionalRequired(ER2263PosRePps080000.genConditionalField6())));
		fs.add(sf(7, null, "Keterangan",
				sv(C, 0, 1000, all).confConditionalRequired(ER2263PosRePps080000.genConditionalField7())));
		return res;
	}
}
