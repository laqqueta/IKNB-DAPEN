package id.go.ojk.asrjk.client.builder.field.lb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asrjk.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.asrjk.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.asrjk.client.builder.field.lb.reference.ER3052PosLbAsrjk604;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Lb604 extends BaseMetadata {

	public Lb604(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_604;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 47, 47, ER3052PosLbAsrjk604.genFieldSave(), null,
				ER3052PosLbAsrjk604.getRequiredPos());
		res.addSegmentValidations(ER3052PosLbAsrjk604.genValidationPremiTunggal1());
		res.addSegmentValidations(ER3052PosLbAsrjk604.genValidationPremiReguler1());
		res.addSegmentValidations(ER3052PosLbAsrjk604.genValidationPremiTunggal2());
		res.addSegmentValidations(ER3052PosLbAsrjk604.genValidationPremiReguler2());
		res.addSegmentValidations(ER3052PosLbAsrjk604.genValidationPremiTunggal12());
		res.addSegmentValidations(ER3052PosLbAsrjk604.genValidationPremiReguler12());
		res.addSegmentValidations(ER3052PosLbAsrjk604.genValidationPremi());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3052_LB604.getObject())).confUnique(U));
		fs.add(sf(2, null, "Premi Pertanggungan Baru", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "Premi Lanjutan", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Premi Murni", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(5, null, "Komisi Pertanggungan Baru", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(6, null, "Komisi Lanjutan", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(7, null, "Biaya Akuisisi Lainnya", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(8, null, "Biaya Pemeliharaan Polis", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(9, null, "Biaya Lainnya", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(10, null, "Total Biaya", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER3052PosLbAsrjk604.genFieldValidation10()));
		fs.add(sf(11, null, "Total Premi", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER3052PosLbAsrjk604.genFieldValidation11()));
		return res;
	}
}
