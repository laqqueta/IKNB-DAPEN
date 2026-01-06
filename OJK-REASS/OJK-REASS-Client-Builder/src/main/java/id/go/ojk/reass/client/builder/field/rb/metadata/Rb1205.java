package id.go.ojk.reass.client.builder.field.rb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.reass.client.builder.field.EFormRencanaBisnis;
import id.go.ojk.reass.client.builder.field.rb.reference.EHeaderMetadataRb;
import id.go.ojk.reass.client.builder.field.rb.reference.ER2023PosRbReass1205;

public class Rb1205 extends BaseMetadata {

	public Rb1205(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRencanaBisnis eEnum = EFormRencanaBisnis.RB_1205;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 39, 39, ER2023PosRbReass1205.genFieldSave(), null, ER2023PosRbReass1205.getRequiredPos());
		res.addSegmentValidations(ER2023PosRbReass1205.genValidationPeningkatanSaldoKas());
		res.addSegmentValidations(ER2023PosRbReass1205.genValidationSaldoAkhirKas());
		res.addSegmentValidations(ER2023PosRbReass1205.genValidationArusKasDariAktivitasOperasi());
		res.addSegmentValidations(ER2023PosRbReass1205.genValidationArusKasMasukOperasi());
		res.addSegmentValidations(ER2023PosRbReass1205.genValidationArusKasKeluarOperasi());
		res.addSegmentValidations(ER2023PosRbReass1205.genValidationArusKasDariAktivitasInvestasi());
		res.addSegmentValidations(ER2023PosRbReass1205.genValidationArusKasMasukInvestasi());
		res.addSegmentValidations(ER2023PosRbReass1205.genValidationArusKasKeluarInvestasi());
		res.addSegmentValidations(ER2023PosRbReass1205.genValidationArusKasDariAktivitasPendanaan());
		res.addSegmentValidations(ER2023PosRbReass1205.genValidationArusKasMasukPendanaan());
		res.addSegmentValidations(ER2023PosRbReass1205.genValidationArusKasKeluarPendanaan());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 14, 14, refTable).confReference(EHeaderMetadataRb.R2023_RB1205.getObject())).confUnique(U));
		fs.add(sf(2, null, "Aktual per 30 Sept 20XX-1", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "Proyeksi per 31 Des 20xx - 1", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Proyeksi per 30 Jun 20xx", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(5, null, "Proyeksi per 31 Des 20xx", sv(M, 1, 16, numericNegatif)));
		return res;
	}
}
