package id.go.ojk.fink.client.builder.field.lb.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.PATTERN_REFERENCE_2;
import static id.go.ojk.client.model.config.SimpleValidation.patternNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
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
import id.go.ojk.fink.client.builder.field.lb.reference.ER3010PosLbFink6902;

public class Lb6902 extends BaseMetadata {

	public Lb6902(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_6902;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 127, 127, ER3010PosLbFink6902.genFieldSave(), ER3010PosLbFink6902.genFieldSave(),
				ER3010PosLbFink6902.getRequiredPos());
		res.addSegmentValidations(ER3010PosLbFink6902.genRowValidation001());
		res.addSegmentValidations(ER3010PosLbFink6902.genRowValidation008());
		res.addSegmentValidations(ER3010PosLbFink6902.genRowValidation042());
		res.addSegmentValidations(ER3010PosLbFink6902.genRowValidation043());
		res.addSegmentValidations(ER3010PosLbFink6902.genRowValidation044());
		res.addSegmentValidations(ER3010PosLbFink6902.genRowValidation051());
		res.addSegmentValidations(ER3010PosLbFink6902.genRowValidation084());
		res.addSegmentValidations(ER3010PosLbFink6902.genRowValidation085());
		res.addSegmentValidations(ER3010PosLbFink6902.genRowValidation086());
		res.addSegmentValidations(ER3010PosLbFink6902.genRowValidation093());
		res.addSegmentValidations(ER3010PosLbFink6902.genRowValidation126());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 12, 12, refTable)
				.confReference(EHeaderMetadataLb.R3010_LB6902.getObject()).confRegex(patternNumeric)).confUnique(U));
		fs.add(sf(2, null, "Sandi Wilayah (DATI 1)",
				sv(C, 1, 6, alfaNumeric).confRegex(PATTERN_REFERENCE_2)
						.confConditionalRequired(ER3010PosLbFink6902.genConditional2()))
				.addFieldValidations(ER3010PosLbFink6902.genFieldValidation2()));
		fs.add(sf(3, null, "Sejak Perusahaan didirikan sampai dengan akhir bulan Posisi Tanggal Laporan",
				sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Periode Bulan Laporan",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3010PosLbFink6902.genConditional4())));
		return res;
	}
}
