package id.go.ojk.ppk.client.builder.field.rb.metadata;

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
import id.go.ojk.ppk.client.builder.field.EFormRencanaBisnis;
import id.go.ojk.ppk.client.builder.field.rb.reference.EHeaderMetadataRb;
import id.go.ojk.ppk.client.builder.field.rb.reference.ER2019PosRbPpk100401;

public class Rb100401 extends BaseMetadata {

	public Rb100401(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRencanaBisnis eEnum = EFormRencanaBisnis.RB_100401;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 53, 53, ER2019PosRbPpk100401.genFieldSave(), null, ER2019PosRbPpk100401.getRequiredPos());
		res.addSegmentValidations(ER2019PosRbPpk100401.genValidationArusKasBersihDariKegiatanOperasi());
		res.addSegmentValidations(ER2019PosRbPpk100401.genValidationArusKasMasukDariKegiatanOperasi());
		res.addSegmentValidations(ER2019PosRbPpk100401.genValidationArusKasKeluarUntukKegiatanOperasi());
		res.addSegmentValidations(ER2019PosRbPpk100401.genValidationArusKasBersihDariKegiatanInvestasi());
		res.addSegmentValidations(ER2019PosRbPpk100401.genValidationArusKasMasukDariKegiatanInvestasi());
		res.addSegmentValidations(ER2019PosRbPpk100401.genValidationArusKasKeluarKasUntukKegiatanInvestasi());
		res.addSegmentValidations(ER2019PosRbPpk100401.genValidationArusKasBersihDariKegiatanPendanaan());
		res.addSegmentValidations(ER2019PosRbPpk100401.genValidationArusKasMasukDariKegiatanPendanaan());
		res.addSegmentValidations(ER2019PosRbPpk100401.genValidationArusKasKeluarUntukKegiatanPendanaan());
		res.addSegmentValidations(ER2019PosRbPpk100401.genValidationKenaikanBersihKasDanSetaraKas());
		res.addSegmentValidations(ER2019PosRbPpk100401.genValidationKasDanSetaraKasPadaAkhirPeriode());
		res.addSegmentValidations(ER2019PosRbPpk100401.genValidationFormKasDanSetaraKasPadaAkhirPeriode());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 14, 14, refTable).confReference(EHeaderMetadataRb.R2019_RB100401.getObject())).confUnique(U));
		fs.add(sf(2, null, "Kinerja Sept XX-1", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "Proyeksi - Desember XX-1", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Proyeksi - Juni xx", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(5, null, "Proyeksi - Desember xx", sv(M, 1, 16, numericNegatif)));
		return res;
	}
}
