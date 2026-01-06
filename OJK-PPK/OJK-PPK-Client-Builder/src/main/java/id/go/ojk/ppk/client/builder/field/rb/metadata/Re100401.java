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
import id.go.ojk.ppk.client.builder.field.EFormRealisasiBisnis;
import id.go.ojk.ppk.client.builder.field.rb.reference.EHeaderMetadataRb;
import id.go.ojk.ppk.client.builder.field.rb.reference.ER2269PosRePpk100401;

public class Re100401 extends BaseMetadata {

	public Re100401(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRealisasiBisnis eEnum = EFormRealisasiBisnis.RE_100401;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 53, 53, ER2269PosRePpk100401.genFieldSave(), null, ER2269PosRePpk100401.getRequiredPos());
		res.addSegmentValidations(ER2269PosRePpk100401.genValidationArusKasBersihDariKegiatanOperasi());
		res.addSegmentValidations(ER2269PosRePpk100401.genValidationArusKasMasukDariKegiatanOperasi());
		res.addSegmentValidations(ER2269PosRePpk100401.genValidationArusKasKeluarUntukKegiatanOperasi());
		res.addSegmentValidations(ER2269PosRePpk100401.genValidationArusKasBersihDariKegiatanInvestasi());
		res.addSegmentValidations(ER2269PosRePpk100401.genValidationArusKasMasukDariKegiatanInvestasi());
		res.addSegmentValidations(ER2269PosRePpk100401.genValidationArusKasKeluarKasUntukKegiatanInvestasi());
		res.addSegmentValidations(ER2269PosRePpk100401.genValidationArusKasBersihDariKegiatanPendanaan());
		res.addSegmentValidations(ER2269PosRePpk100401.genValidationArusKasMasukDariKegiatanPendanaan());
		res.addSegmentValidations(ER2269PosRePpk100401.genValidationArusKasKeluarUntukKegiatanPendanaan());
		res.addSegmentValidations(ER2269PosRePpk100401.genValidationKenaikanBersihKasDanSetaraKas());
		res.addSegmentValidations(ER2269PosRePpk100401.genValidationKasDanSetaraKasPadaAkhirPeriode());
		res.addSegmentValidations(ER2269PosRePpk100401.genValidationFormKasDanSetaraKasPadaAkhirPeriode());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 14, 14, refTable).confReference(EHeaderMetadataRb.R2269_RE100401.getObject())).confUnique(U));
		fs.add(sf(2, null, "Proyeksi", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "Realisasi", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Deviasi", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER2269PosRePpk100401.genValidationSum()));
		return res;
	}
}
