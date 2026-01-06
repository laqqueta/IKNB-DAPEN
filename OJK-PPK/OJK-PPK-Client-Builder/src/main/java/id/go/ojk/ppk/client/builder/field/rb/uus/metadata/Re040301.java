package id.go.ojk.ppk.client.builder.field.rb.uus.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.ppk.client.builder.field.EFormRealisasiBisnisUus;
import id.go.ojk.ppk.client.builder.field.rb.uus.reference.EHeaderMetadataRbUus;
import id.go.ojk.ppk.client.builder.field.rb.uus.reference.ER2753PosRePpu040301;
import id.go.ojk.ppk.client.builder.field.reference.EHeaderMetadataShared;

public class Re040301 extends BaseMetadata {

	public Re040301(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRealisasiBisnisUus eEnum = EFormRealisasiBisnisUus.RE_040301;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 3, null, ER2753PosRePpu040301.genFieldSave(), null, ER2753PosRePpu040301.getRequiredPos());
		res.addSegmentValidations(ER2753PosRePpu040301.genValidationNumeric());
		res.addSegmentValidations(ER2753PosRePpu040301.genValidationNumericDot());
		res.addSegmentValidations(ER2753PosRePpu040301.genValidationTotalPenyaluranPembiayaankepadaPihakTerkait());
		res.addSegmentValidations(
				ER2753PosRePpu040301.genValidationRasioPenyaluranPembiayaanPihakTerkaitTerhadapEkuitas());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 14, 14, refTable).confReference(EHeaderMetadataRbUus.R2753_RE040301.getObject())));
		fs.add(sf(2, null, "Nama Debitur Pihak Terkait",
				sv(C, 0, 255, all).confConditionalRequired(ER2753PosRePpu040301.genConditionalFieldMustEmpty())));
		fs.add(sf(3, null, "Jenis Pembiayaan",
				sv(C, 0, 6, refTable).confReference(EHeaderMetadataShared.R001.getObject())
						.confConditionalRequired(ER2753PosRePpu040301.genConditionalField1())));
		fs.add(sf(4, null, "Skema Pembiayaan",
				sv(C, 0, 6, refTable).confReference(EHeaderMetadataShared.R002.getObject())
						.confConditionalRequired(ER2753PosRePpu040301.genConditionalField1())));
		fs.add(sf(5, null, "Proyeksi",
				sv(C, 0, 16, all).confConditionalRequired(ER2753PosRePpu040301.genConditionalField2())));
		fs.add(sf(6, null, "Realisasi",
				sv(C, 0, 16, all).confConditionalRequired(ER2753PosRePpu040301.genConditionalField2())));
		fs.add(sf(7, null, "Deviasi",
				sv(C, 0, 16, all).confConditionalRequired(ER2753PosRePpu040301.genConditionalField2()))
				.addFieldValidations(ER2753PosRePpu040301.genValidationSum()));
		return res;
	}
}
