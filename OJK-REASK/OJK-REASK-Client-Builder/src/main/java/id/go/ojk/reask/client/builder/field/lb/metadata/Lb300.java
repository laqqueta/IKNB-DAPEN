package id.go.ojk.reask.client.builder.field.lb.metadata;

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
import id.go.ojk.reask.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.reask.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.reask.client.builder.field.lb.reference.ER3007PosLbReask300;

public class Lb300 extends BaseMetadata {

	public Lb300(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_300;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 35, 35, ER3007PosLbReask300.genFieldSave(), ER3007PosLbReask300.genFieldSave(),
				ER3007PosLbReask300.getRequiredPos());
		res.addSegmentValidations(ER3007PosLbReask300.genValidationSaldoAwalEqualAkhir());
		res.addSegmentValidations(ER3007PosLbReask300.genValidationArusKasMasukAktivitasOperasi());
		res.addSegmentValidations(ER3007PosLbReask300.genValidationArusKasKeluarAktivitasOperasi());
		res.addSegmentValidations(ER3007PosLbReask300.genValidationArusKasAktivitasOperasi());
		res.addSegmentValidations(ER3007PosLbReask300.genValidationArusKasAktivitasInvestasi());
		res.addSegmentValidations(ER3007PosLbReask300.genValidationArusKasMasukAktivitasInvestasi());
		res.addSegmentValidations(ER3007PosLbReask300.genValidationArusKasKeluarAktivitasInvestasi());
		res.addSegmentValidations(ER3007PosLbReask300.genValidationArusKasMasukAktivitasPendanaan());
		res.addSegmentValidations(ER3007PosLbReask300.genValidationArusKasKeluarAktivitasPendanaan());
		res.addSegmentValidations(ER3007PosLbReask300.genValidationArusKasAktivitasPendanaan());
		res.addSegmentValidations(ER3007PosLbReask300.genValidationSaldoAkhirKasDanBank());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3007_LB300.getObject())).confUnique(U));
		fs.add(sf(2, null, "Tahun Berjalan", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "Tahun Sebelumnya", sv(M, 1, 16, numericNegatif)));
		return res;
	}
}
