package id.go.ojk.asruk.client.builder.field.rb.uus.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asruk.client.builder.field.EFormRencanaBisnisUus;
import id.go.ojk.asruk.client.builder.field.rb.uus.reference.EHeaderMetadataRbUus;
import id.go.ojk.asruk.client.builder.field.rb.uus.reference.ER2134PosRbAsruu1301;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Rb1301 extends BaseMetadata {

	public Rb1301(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRencanaBisnisUus eEnum = EFormRencanaBisnisUus.RB_1301;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 25, 25, ER2134PosRbAsruu1301.genFieldSave(), null,
				ER2134PosRbAsruu1301.getRequiredPos());
		res.addSegmentValidations(ER2134PosRbAsruu1301.genValidationNumeric());
		res.addSegmentValidations(ER2134PosRbAsruu1301.genValidationNumericDot());
		res.addSegmentValidations(ER2134PosRbAsruu1301.genValidationTingkatSolvabilitas());
		res.addSegmentValidations(ER2134PosRbAsruu1301
				.genValidationRasioTingkatSolvabilitasSebelumMemperhitungkanAsetYangTersediaUntukQardh());
		res.addSegmentValidations(ER2134PosRbAsruu1301
				.genValidationAsetYgTersediaUntukQardhYgDiperhitungkanSebagaiPenambahAYDDanaTabarruDanTanahud());
		res.addSegmentValidations(ER2134PosRbAsruu1301
				.genValidationKekuranganTingkatSolvabilitasDariTargetInternal());
		res.addSegmentValidations(ER2134PosRbAsruu1301
				.genValidationRasioTingkatSolvabilitasDanaPerusahaan());
		res.addSegmentValidations(ER2134PosRbAsruu1301.genValidationRasioLikuiditas());
		res.addSegmentValidations(ER2134PosRbAsruu1301.genValidationRasioPendapatanInvestasiNeto());
		res.addSegmentValidations(ER2134PosRbAsruu1301.genValidationPerubahanDanaPerusahaan());
		res.addSegmentValidations(ER2134PosRbAsruu1301.genValidationRasioPerubahanDana());
		res.addSegmentValidations(ER2134PosRbAsruu1301.genValidationRasioAsetUnitSyariah());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 14, 14, refTable).confReference(EHeaderMetadataRbUus.R2134_RB1301.getObject())).confUnique(U));
		fs.add(sf(2, null, "Aktual per 30 Sept 20XX-1", sv(M, 1, 16, all)));
		fs.add(sf(3, null, "Proyeksi per 31 Des 20xx - 1", sv(M, 1, 16, all)));
		fs.add(sf(4, null, "Proyeksi per 30 Jun 20xx", sv(M, 1, 16, all)));
		fs.add(sf(5, null, "Proyeksi per 31 Des 20xx", sv(M, 1, 16, all)));
		return res;
	}
}
