package id.go.ojk.asruk.client.builder.field.lb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asruk.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.asruk.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.asruk.client.builder.field.lb.reference.ER3056PosLbAsruk604;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Lb604 extends BaseMetadata {

	public Lb604(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_604;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 165, 165, ER3056PosLbAsruk604.genFieldSave(), null,
				ER3056PosLbAsruk604.getRequiredPos());
		res.addSegmentValidations(ER3056PosLbAsruk604.genValidationPremi());
		res.addSegmentValidations(ER3056PosLbAsruk604.genValidationKomisi());
		res.addSegmentValidations(
				ER3056PosLbAsruk604.genValidationCadanganAtasPremiYangBelumMerupakanPendapatanTahunLalu());
		res.addSegmentValidations(
				ER3056PosLbAsruk604.genValidationCadanganAtasPremiYangBelumMerupakanPendapatanTahunBerjalan());
		res.addSegmentValidations(ER3056PosLbAsruk604.genValidationPendapatanPremi());
		res.addSegmentValidations(ER3056PosLbAsruk604.genValidationKlaimDibayar());
		res.addSegmentValidations(ER3056PosLbAsruk604.genValidationBiayaAdjuster());
		res.addSegmentValidations(ER3056PosLbAsruk604.genValidationCadanganOutstandingKlaimTahunLalu());
		res.addSegmentValidations(ER3056PosLbAsruk604.genValidationCadanganOutstandingKlaimTahunBerjalan());
		res.addSegmentValidations(ER3056PosLbAsruk604.genValidationBebanKlaim());
		res.addSegmentValidations(ER3056PosLbAsruk604.genValidationSurplusUnderwriting());
		res.addSegmentValidations(ER3056PosLbAsruk604.genValidationPendapatanPremi2());
		res.addSegmentValidations(ER3056PosLbAsruk604.genValidationBebanKlaim2());
		res.addSegmentValidations(ER3056PosLbAsruk604.genValidationSurplusUnderwriting2());
		res.addSegmentValidations(ER3056PosLbAsruk604.genValidationPendapatanPremi3());
		res.addSegmentValidations(ER3056PosLbAsruk604.genValidationBebanKlaim3());
		res.addSegmentValidations(ER3056PosLbAsruk604.genValidationSurplusUnderwriting3());
		res.addSegmentValidations(ER3056PosLbAsruk604.genValidationPendapatanPremi4());
		res.addSegmentValidations(ER3056PosLbAsruk604.genValidationBebanKlaim4());
		res.addSegmentValidations(ER3056PosLbAsruk604.genValidationSurplusUnderwriting4());
		res.addSegmentValidations(ER3056PosLbAsruk604.genValidationPendapatanPremi5());
		res.addSegmentValidations(ER3056PosLbAsruk604.genValidationBebanKlaim5());
		res.addSegmentValidations(ER3056PosLbAsruk604.genValidationSurplusUnderwriting5());
		res.addSegmentValidations(ER3056PosLbAsruk604.genValidationPendapatanPremi6());
		res.addSegmentValidations(ER3056PosLbAsruk604.genValidationBebanKlaim6());
		res.addSegmentValidations(ER3056PosLbAsruk604.genValidationSurplusUnderwriting6());
		res.addSegmentValidations(ER3056PosLbAsruk604.genValidationPendapatanPremi7());
		res.addSegmentValidations(ER3056PosLbAsruk604.genValidationBebanKlaim7());
		res.addSegmentValidations(ER3056PosLbAsruk604.genValidationSurplusUnderwriting7());
		res.addSegmentValidations(ER3056PosLbAsruk604.genValidationPendapatanPremi8());
		res.addSegmentValidations(ER3056PosLbAsruk604.genValidationBebanKlaim8());
		res.addSegmentValidations(ER3056PosLbAsruk604.genValidationSurplusUnderwriting8());
		res.addSegmentValidations(ER3056PosLbAsruk604.genValidationPendapatanPremi9());
		res.addSegmentValidations(ER3056PosLbAsruk604.genValidationBebanKlaim9());
		res.addSegmentValidations(ER3056PosLbAsruk604.genValidationSurplusUnderwriting9());
		res.addSegmentValidations(ER3056PosLbAsruk604.genValidationPendapatanPremi10());
		res.addSegmentValidations(ER3056PosLbAsruk604.genValidationBebanKlaim10());
		res.addSegmentValidations(ER3056PosLbAsruk604.genValidationSurplusUnderwriting10());
		res.addSegmentValidations(ER3056PosLbAsruk604.genValidationPendapatanPremi11());
		res.addSegmentValidations(ER3056PosLbAsruk604.genValidationBebanKlaim11());
		res.addSegmentValidations(ER3056PosLbAsruk604.genValidationSurplusUnderwriting11());
		res.addSegmentValidations(ER3056PosLbAsruk604.genValidationPendapatanPremi12());
		res.addSegmentValidations(ER3056PosLbAsruk604.genValidationBebanKlaim12());
		res.addSegmentValidations(ER3056PosLbAsruk604.genValidationSurplusUnderwriting12());
		res.addSegmentValidations(ER3056PosLbAsruk604.genValidationPendapatanPremi13());
		res.addSegmentValidations(ER3056PosLbAsruk604.genValidationBebanKlaim13());
		res.addSegmentValidations(ER3056PosLbAsruk604.genValidationSurplusUnderwriting13());
		res.addSegmentValidations(ER3056PosLbAsruk604.genValidationPendapatanPremi14());
		res.addSegmentValidations(ER3056PosLbAsruk604.genValidationBebanKlaim14());
		res.addSegmentValidations(ER3056PosLbAsruk604.genValidationSurplusUnderwriting14());
		res.addSegmentValidations(ER3056PosLbAsruk604.genValidationPendapatanPremi15());
		res.addSegmentValidations(ER3056PosLbAsruk604.genValidationBebanKlaim15());
		res.addSegmentValidations(ER3056PosLbAsruk604.genValidationSurplusUnderwriting15());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 12, 12, refTable).confReference(EHeaderMetadataLb.R3056_LB604.getObject())).confUnique(U));
		fs.add(sf(2, null, "Kode Lini Usaha", sv(M, 1, 2, alfaNumeric))
				.addFieldValidations(ER3056PosLbAsruk604.genFieldValidation2()));
		fs.add(sf(3, null, "Pos Langsung", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Reasuransi Masuk - Dalam Negeri", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(5, null, "Reasuransi Masuk - ASEAN", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(6, null, "Reasuransi Masuk - Non ASEAN", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(7, null, "Reasuransi Keluar - Dalam Negeri", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(8, null, "Reasuransi Keluar - ASEAN", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(9, null, "Reasuransi Keluar - Non ASEAN", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(10, null, "Jumlah", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER3056PosLbAsruk604.genFieldValidation10()));
		return res;
	}
}
