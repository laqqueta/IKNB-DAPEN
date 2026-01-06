package id.go.ojk.asrjs.client.builder.field.lb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asrjs.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.asrjs.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.asrjs.client.builder.field.lb.reference.ER3006PosLbAsrjs100;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Lb100 extends BaseMetadata {

	public Lb100(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_100;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 52, 52, ER3006PosLbAsrjs100.genFieldSave(), null,
				ER3006PosLbAsrjs100.getRequiredPos());
		res.addSegmentValidations(ER3006PosLbAsrjs100.genValidationAsetA());
		res.addSegmentValidations(ER3006PosLbAsrjs100.genValidationAsetB());
		res.addSegmentValidations(ER3006PosLbAsrjs100.genValidationInvestasi());
		res.addSegmentValidations(ER3006PosLbAsrjs100.genValidationBukanInvestasi());
		res.addSegmentValidations(ER3006PosLbAsrjs100.genValidationLiabilitas());
		res.addSegmentValidations(ER3006PosLbAsrjs100.genValidationPenyisihanTeknis());
		res.addSegmentValidations(ER3006PosLbAsrjs100.genValidationEkuitasDana());
		res.addSegmentValidations(ER3006PosLbAsrjs100.genValidationKekayaanYangTidakDiperkenankan());
		res.addSegmentValidations(ER3006PosLbAsrjs100.genValidationLiabilitasDanEkuitas());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3006_LB100.getObject())).confUnique(U));
		fs.add(sf(2, null, "Dana Perusahaan - Saldo SAK", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "Dana Perusahaan - Saldo SAP", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Dana Tabarru' - Saldo SAK", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(5, null, "Dana Tabarru' - Saldo SAP", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(6, null, "Dana Investasi Peserta - Saldo SAK", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(7, null, "Dana Investasi Peserta - Saldo SAP", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(8, null, "Kolom Penyesuaian",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3006PosLbAsrjs100.genConditional8())));
		fs.add(sf(9, null, "Kolom Gabungan - Saldo SAK", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER3006PosLbAsrjs100.genValidation9()));
		return res;
	}
}
