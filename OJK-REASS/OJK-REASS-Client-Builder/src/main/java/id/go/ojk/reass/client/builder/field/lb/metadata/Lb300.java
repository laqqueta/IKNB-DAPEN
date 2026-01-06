package id.go.ojk.reass.client.builder.field.lb.metadata;

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
import id.go.ojk.reass.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.reass.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.reass.client.builder.field.lb.reference.ER3008PosLbReass300;

public class Lb300 extends BaseMetadata {

	public Lb300(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_300;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 51, 51, ER3008PosLbReass300.genFieldSave(), null, ER3008PosLbReass300.getRequiredPos());
		res.addSegmentValidations(ER3008PosLbReass300.genValidationPeningkatanPenurunanSaldoKas());
		res.addSegmentValidations(ER3008PosLbReass300.genValidationSaldoAkhirKas());
		res.addSegmentValidations(ER3008PosLbReass300.genValidationArusKasDariAktivitasOperasi());
		res.addSegmentValidations(ER3008PosLbReass300.genValidationArusKasMasukDariAktivitasOperasi());
		res.addSegmentValidations(ER3008PosLbReass300.genValidationArusKasKeluarDariAktivitasOperasi());
		res.addSegmentValidations(ER3008PosLbReass300.genValidationArusKasDariAktivitasInvestasi());
		res.addSegmentValidations(ER3008PosLbReass300.genValidationArusKasMasukDariAktivitasInvestasi());
		res.addSegmentValidations(ER3008PosLbReass300.genValidationArusKasKeluarDariAktivitasInvestasi());
		res.addSegmentValidations(ER3008PosLbReass300.genValidationArusKasDariAktivitasPendanaan());
		res.addSegmentValidations(ER3008PosLbReass300.genValidationArusKasMasukDariAktivitasPendanaan());
		res.addSegmentValidations(ER3008PosLbReass300.genValidationArusKasKeluarDariAktivitasPendanaan());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3008_LB300.getObject())).confUnique(U));
		fs.add(sf(2, null, "Dana Perusahaan", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "Dana Tabarru'", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Akad Wakalah Bil Ujrah", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(5, null, "Akad Mudharabah", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(6, null, "Gabungan", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER3008PosLbReass300.genValidation6()));
		return res;
	}
}
