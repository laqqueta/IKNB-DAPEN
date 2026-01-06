package id.go.ojk.pmvs.client.builder.field.rb.metadata;

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
import id.go.ojk.pmvs.client.builder.field.EFormRealisasiBisnis;
import id.go.ojk.pmvs.client.builder.field.rb.reference.EHeaderMetadataRb;
import id.go.ojk.pmvs.client.builder.field.rb.reference.ER2266PosRePmvs100402;

public class Re100402 extends BaseMetadata {

	public Re100402(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRealisasiBisnis eEnum = EFormRealisasiBisnis.RE_100402;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 53, 53, ER2266PosRePmvs100402.genFieldSave(), null, ER2266PosRePmvs100402.getRequiredPos());
		res.addSegmentValidations(ER2266PosRePmvs100402.genValidationArusKasBersihDariKegiatanOperasi());
		res.addSegmentValidations(ER2266PosRePmvs100402.genValidationArusKasMasukDariKegiatanOperasi());
		res.addSegmentValidations(ER2266PosRePmvs100402.genValidationArusKasMasukDariKegiatanUsahaLain());
		res.addSegmentValidations(ER2266PosRePmvs100402.genValidationArusKasKeluarUntukKegiatanOperasi());
		res.addSegmentValidations(ER2266PosRePmvs100402.genValidationArusKasKeluarUntukKegiatanUsahaLain());
		res.addSegmentValidations(ER2266PosRePmvs100402.genValidationArusKasBersihDariKegiatanInvestasi());
		res.addSegmentValidations(ER2266PosRePmvs100402.genValidationArusKasMasukDariKegiatanInvestasi());
		res.addSegmentValidations(ER2266PosRePmvs100402.genValidationArusKasKeluarUntukKegiatanInvestasi());
		res.addSegmentValidations(ER2266PosRePmvs100402.genValidationArusKasBersihDariKegiatanPendanaan());
		res.addSegmentValidations(ER2266PosRePmvs100402.genValidationArusKasMasukDariKegiatanPendanaan());
		res.addSegmentValidations(ER2266PosRePmvs100402.genValidationArusKasKeluarUntukKegiatanPendanaan());
		res.addSegmentValidations(ER2266PosRePmvs100402.genValidationKenaikanBersihKasDanSetaraKas());
		res.addSegmentValidations(ER2266PosRePmvs100402.genValidationKasDanSetaraKasPadaAkhirPeriode());
		res.addSegmentValidations(ER2266PosRePmvs100402.genValidationFormKasDanSetaraKasPadaAkhirPeriode());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 14, 14, refTable).confReference(EHeaderMetadataRb.R2266_RE100402.getObject())).confUnique(U));
		fs.add(sf(2, null, "Proyeksi - Juni xx", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "Realisasi - Juni xx", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Deviasi", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER2266PosRePmvs100402.genValidationSum()));
		return res;
	}
}
