package id.go.ojk.asrjs.client.builder.field.lb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.numericDotNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asrjs.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.asrjs.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.asrjs.client.builder.field.lb.reference.ER3040PosLbAsrjs231;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Lb231 extends BaseMetadata {

	public Lb231(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_231;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 18, 18, ER3040PosLbAsrjs231.genFieldSave(), null,
				ER3040PosLbAsrjs231.getRequiredPos());
		res.addSegmentValidations(ER3040PosLbAsrjs231.genValidationNumericNegative());
		res.addSegmentValidations(ER3040PosLbAsrjs231.genValidationNumericDotNegative());
		res.addSegmentValidations(ER3040PosLbAsrjs231.genValidationMaxLength6());
		res.addSegmentValidations(ER3040PosLbAsrjs231.genValidationTotalDanaTabaruDanTanahud());
		res.addSegmentValidations(ER3040PosLbAsrjs231.genValidationRasioAsetDanaTabaruDanTanahud());
		res.addSegmentValidations(ER3040PosLbAsrjs231.genValidationTotalDanaPerusahaan());
		res.addSegmentValidations(ER3040PosLbAsrjs231.genValidationRasioAsetDanaPerusahaan());
		res.addSegmentValidations(ER3040PosLbAsrjs231.genValidationTotalDanaInvestasiPerusahaan());
		res.addSegmentValidations(ER3040PosLbAsrjs231.genValidationRasioAsetDanaInvestasiPerusahaan());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3040_LB231.getObject())).confUnique(U));
		fs.add(sf(2, null, "Aset-Rupiah", sv(M, 1, 16, all)));
		fs.add(sf(3, null, "Aset-Valas", sv(M, 1, 16, all)));
		fs.add(sf(4, null, "Aset-Total", sv(M, 1, 16, all)).addFieldValidations(ER3040PosLbAsrjs231.genValidation4()));
		fs.add(sf(5, null, "Liabilitas-Rupiah", sv(M, 1, 16, all)));
		fs.add(sf(6, null, "Liabilitas-Valas", sv(M, 1, 16, all)));
		fs.add(sf(7, null, "Liabilitas-Total", sv(M, 1, 16, all))
				.addFieldValidations(ER3040PosLbAsrjs231.genValidation7()));
		fs.add(sf(8, null, "Rasio Aset terhadap Liabilitas - Rupiah", sv(M, 1, 6, numericDotNegatif))
				.addFieldValidations(ER3040PosLbAsrjs231.genValidation8()));
		fs.add(sf(9, null, "Rasio Aset terhadap Liabilitas - Valas", sv(M, 1, 6, numericDotNegatif))
				.addFieldValidations(ER3040PosLbAsrjs231.genValidation9()));
		fs.add(sf(10, null, "Rasio Aset terhadap Liabilitas - Total", sv(M, 1, 6, numericDotNegatif))
				.addFieldValidations(ER3040PosLbAsrjs231.genValidation10()));
		return res;
	}
}
