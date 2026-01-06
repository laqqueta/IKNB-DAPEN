package id.go.ojk.lpei.client.builder.field.lb.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.patternNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.lib.client.model.config.DataType;
import id.go.ojk.lpei.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.lpei.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.lpei.client.builder.field.lb.reference.ER5007PosLbLpeig1100;
import id.go.ojk.lpei.client.builder.field.lb.reference.ER5011PosLbLpeig2000;
import id.go.ojk.lpei.client.builder.field.reference.EHeaderMetadataShared;

public class Lb2000 extends BaseMetadata {

	public Lb2000(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_2000;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 1, null);

		res.setRequiredPos(ER5011PosLbLpeig2000.getRequiredPos());
		res.setUniquePos(ER5011PosLbLpeig2000.getUniquePos());
		res.setSavePos(ER5011PosLbLpeig2000.genFieldSave());
		res.setSavePosForm(ER5011PosLbLpeig2000.genFieldSave());

		res.addSegmentValidations(ER5011PosLbLpeig2000.genRowValidationJumlah());

		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 10, 10, refTable)
				.confReference(EHeaderMetadataLb.R5011_LB2000.getObject())
				.confRegex(patternNumeric)));
		fs.add(sf(2, null, "Jenis", sv(C, 1, 10, refTable)
				.confReference(EHeaderMetadataShared.R051.getObject())
				.confRegex(SimpleValidation.PATTERN_REFERENCE_1.c())
				.confConditionalRequired(ER5011PosLbLpeig2000.genConditionalExist())));
		fs.add(sf(3, null, "Jenis Valuta", sv(C, 1, 10, refTable)
				.confReference(EHeaderMetadataShared.R020.getObject())
				.confRegex(SimpleValidation.PATTERN_REFERENCE_3.c())
				.confConditionalRequired(ER5011PosLbLpeig2000.genConditionalExist())));
		fs.add(sf(4, null, "Jumlah", sv(M, 1, 20, DataType.numeric)));
		fs.add(sf(5, null, "Persentase Terhadap Modal", sv(M, 1, 10, DataType.numericDot))
				.addFieldValidations(UtilFieldValidation.genEqualsDivisionForm("4","5",EFormLaporanBulanan.LB_1100.getCode(),
						ER5007PosLbLpeig1100.R_11000600000000.getKey(),"4",
						"Kolom Jumlah di form 2000 dibagi Total Ekuitas (11000600000000) Pada Kolom Jumlah di Form 1100")));
		return res;
	}
}
