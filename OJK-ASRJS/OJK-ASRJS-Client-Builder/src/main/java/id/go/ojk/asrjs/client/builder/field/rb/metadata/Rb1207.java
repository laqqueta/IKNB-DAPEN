package id.go.ojk.asrjs.client.builder.field.rb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asrjs.client.builder.field.EFormRencanaBisnis;
import id.go.ojk.asrjs.client.builder.field.rb.reference.EHeaderMetadataRb;
import id.go.ojk.asrjs.client.builder.field.rb.reference.ER2030PosRbAsrjs1207;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Rb1207 extends BaseMetadata {

	public Rb1207(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRencanaBisnis eEnum = EFormRencanaBisnis.RB_1207;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 39, 39, ER2030PosRbAsrjs1207.genFieldSave(), null,
				ER2030PosRbAsrjs1207.getRequiredPos());
		res.addSegmentValidations(ER2030PosRbAsrjs1207.genValidationPeningkatanSaldoKas());
		res.addSegmentValidations(ER2030PosRbAsrjs1207.genValidationSaldoAkhirKas());
		res.addSegmentValidations(ER2030PosRbAsrjs1207.genValidationArusKasDariAktivitasOperasi());
		res.addSegmentValidations(ER2030PosRbAsrjs1207.genValidationArusKasMasukOperasi());
		res.addSegmentValidations(ER2030PosRbAsrjs1207.genValidationArusKasKeluarOperasi());
		res.addSegmentValidations(ER2030PosRbAsrjs1207.genValidationArusKasDariAktivitasInvestasi());
		res.addSegmentValidations(ER2030PosRbAsrjs1207.genValidationArusKasMasukInvestasi());
		res.addSegmentValidations(ER2030PosRbAsrjs1207.genValidationArusKasKeluarInvestasi());
		res.addSegmentValidations(ER2030PosRbAsrjs1207.genValidationArusKasDariAktivitasPendanaan());
		res.addSegmentValidations(ER2030PosRbAsrjs1207.genValidationArusKasMasukPendanaan());
		res.addSegmentValidations(ER2030PosRbAsrjs1207.genValidationArusKasKeluarPendanaan());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 14, 14, refTable).confReference(EHeaderMetadataRb.R2030_RB1207.getObject())).confUnique(U));
		fs.add(sf(2, null, "Aktual per 30 Sept 20XX-1", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "Proyeksi per 31 Des 20xx - 1", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Proyeksi per 30 Jun 20xx", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(5, null, "Proyeksi per 31 Des 20xx", sv(M, 1, 16, numericNegatif)));
		return res;
	}
}
