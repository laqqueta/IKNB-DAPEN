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
import id.go.ojk.pmvs.client.builder.field.EFormRencanaBisnis;
import id.go.ojk.pmvs.client.builder.field.rb.reference.EHeaderMetadataRb;
import id.go.ojk.pmvs.client.builder.field.rb.reference.ER2016PosRbPmvs100402;

public class Rb100402 extends BaseMetadata {

	public Rb100402(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRencanaBisnis eEnum = EFormRencanaBisnis.RB_100402;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 53, 53, ER2016PosRbPmvs100402.genFieldSave(), null, ER2016PosRbPmvs100402.getRequiredPos());
		res.addSegmentValidations(ER2016PosRbPmvs100402.genValidationArusKasBersihDariKegiatanOperasi());
		res.addSegmentValidations(ER2016PosRbPmvs100402.genValidationArusKasMasukDariKegiatanOperasi());
		res.addSegmentValidations(ER2016PosRbPmvs100402.genValidationArusKasMasukDariKegiatanUsahaLain());
		res.addSegmentValidations(ER2016PosRbPmvs100402.genValidationArusKasKeluarUntukKegiatanOperasi());
		res.addSegmentValidations(ER2016PosRbPmvs100402.genValidationArusKasKeluarUntukKegiatanUsahaLain());
		res.addSegmentValidations(ER2016PosRbPmvs100402.genValidationArusKasBersihDariKegiatanInvestasi());
		res.addSegmentValidations(ER2016PosRbPmvs100402.genValidationArusKasMasukDariKegiatanInvestasi());
		res.addSegmentValidations(ER2016PosRbPmvs100402.genValidationArusKasKeluarUntukKegiatanInvestasi());
		res.addSegmentValidations(ER2016PosRbPmvs100402.genValidationArusKasBersihDariKegiatanPendanaan());
		res.addSegmentValidations(ER2016PosRbPmvs100402.genValidationArusKasMasukDariKegiatanPendanaan());
		res.addSegmentValidations(ER2016PosRbPmvs100402.genValidationArusKasKeluarUntukKegiatanPendanaan());
		res.addSegmentValidations(ER2016PosRbPmvs100402.genValidationKenaikanBersihKasDanSetaraKas());
		res.addSegmentValidations(ER2016PosRbPmvs100402.genValidationKasDanSetaraKasPadaAkhirPeriode());
		res.addSegmentValidations(ER2016PosRbPmvs100402.genValidationFormKasDanSetaraKasPadaAkhirPeriode());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 14, 14, refTable).confReference(EHeaderMetadataRb.R2016_RB100402.getObject())).confUnique(U));
		fs.add(sf(2, null, "Kinerja Sept XX-1", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "Proyeksi - Desember XX-1", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Proyeksi - Juni xx", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(5, null, "Proyeksi - Desember xx", sv(M, 1, 16, numericNegatif)));
		return res;
	}
}
