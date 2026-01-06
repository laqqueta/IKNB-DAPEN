package id.go.ojk.fink.client.builder.field.lb.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.patternNumeric;
import static id.go.ojk.client.model.config.SimpleValidation.PATTERN_REFERENCE_2;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.fink.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.fink.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.fink.client.builder.field.lb.reference.ER3009PosLbFink6901;

public class Lb6901 extends BaseMetadata {

	public Lb6901(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_6901;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 194, 194, ER3009PosLbFink6901.genFieldSave(), ER3009PosLbFink6901.genFieldSave(),
				ER3009PosLbFink6901.getRequiredPos());
		res.addSegmentValidations(ER3009PosLbFink6901.genRowValidation001());
		res.addSegmentValidations(ER3009PosLbFink6901.genRowValidation008());
		res.addSegmentValidations(ER3009PosLbFink6901.genRowValidation042());
		res.addSegmentValidations(ER3009PosLbFink6901.genRowValidation050());
		res.addSegmentValidations(ER3009PosLbFink6901.genRowValidation056());
		res.addSegmentValidations(ER3009PosLbFink6901.genRowValidation090());
		res.addSegmentValidations(ER3009PosLbFink6901.genRowValidation097());
		res.addSegmentValidations(ER3009PosLbFink6901.genRowValidation104());
		res.addSegmentValidations(ER3009PosLbFink6901.genRowValidation139());
		res.addSegmentValidations(ER3009PosLbFink6901.genRowValidation147());
		res.addSegmentValidations(ER3009PosLbFink6901.genRowValidation153());
		res.addSegmentValidations(ER3009PosLbFink6901.genRowValidation187());
		res.addSegmentValidations(ER3009PosLbFink6901.genRowValidation188());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 12, 12, refTable)
				.confReference(EHeaderMetadataLb.R3009_LB6901.getObject()).confRegex(patternNumeric)).confUnique(U));
		fs.add(sf(2, null, "Sandi Wilayah (DATI 1)",
				sv(C, 1, 6, all).confRegex(PATTERN_REFERENCE_2)
						.confConditionalRequired(ER3009PosLbFink6901.genConditional2()))
				.addFieldValidations(ER3009PosLbFink6901.genFieldValidation2()));
		fs.add(sf(3, null, "Sejak Perusahaan didirikan sampai dengan akhir bulan Posisi Tanggal Laporan",
				sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Periode Bulan Laporan", sv(M, 1, 16, numericNegatif)));
		return res;
	}
}
