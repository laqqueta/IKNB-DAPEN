package id.go.ojk.asrus.client.builder.field.rb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asrus.client.builder.field.EFormRencanaBisnis;
import id.go.ojk.asrus.client.builder.field.rb.reference.EHeaderMetadataRb;
import id.go.ojk.asrus.client.builder.field.rb.reference.ER2031PosRbAsrus1208;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Rb1208 extends BaseMetadata {

	public Rb1208(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRencanaBisnis eEnum = EFormRencanaBisnis.RB_1208;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 33, 33, ER2031PosRbAsrus1208.genFieldSave(), null,
				ER2031PosRbAsrus1208.getRequiredPos());
		res.addSegmentValidations(ER2031PosRbAsrus1208.genValidationPeningkatanSaldoKas());
		res.addSegmentValidations(ER2031PosRbAsrus1208.genValidationSaldoAkhirKas());
		res.addSegmentValidations(ER2031PosRbAsrus1208.genValidationArusKasDariAktivitasOperasi());
		res.addSegmentValidations(ER2031PosRbAsrus1208.genValidationArusKasMasukOperasi());
		res.addSegmentValidations(ER2031PosRbAsrus1208.genValidationArusKasKeluarOperasi());
		res.addSegmentValidations(ER2031PosRbAsrus1208.genValidationArusKasDariAktivitasInvestasi());
		res.addSegmentValidations(ER2031PosRbAsrus1208.genValidationArusKasMasukInvestasi());
		res.addSegmentValidations(ER2031PosRbAsrus1208.genValidationArusKasKeluarInvestasi());
		res.addSegmentValidations(ER2031PosRbAsrus1208.genValidationArusKasDariAktivitasPendanaan());
		res.addSegmentValidations(ER2031PosRbAsrus1208.genValidationArusKasMasukPendanaan());
		res.addSegmentValidations(ER2031PosRbAsrus1208.genValidationArusKasKeluarPendanaan());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 14, 14, refTable).confReference(EHeaderMetadataRb.R2031_RB1208.getObject())).confUnique(U));
		fs.add(sf(2, null, "Aktual per 30 Sept 20XX-1", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "Proyeksi per 31 Des 20xx - 1", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Proyeksi per 30 Jun 20xx", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(5, null, "Proyeksi per 31 Des 20xx", sv(M, 1, 16, numericNegatif)));
		return res;
	}
}
